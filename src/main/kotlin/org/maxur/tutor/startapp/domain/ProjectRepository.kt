package org.maxur.tutor.startapp.domain

import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.jooq.SelectWhereStep
import org.maxur.tutor.startapp.db.schema.Tables.ISSUES
import org.maxur.tutor.startapp.db.schema.Tables.PROJECTS
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


/**
 * The Project repository.
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 *
 */
@Repository
@Transactional
open class ProjectRepository(val dsl: DSLContext) {

    private val select: SelectWhereStep<Record>
        get() = this.dsl.select()
                .from(PROJECTS)
                .leftJoin(ISSUES)
                .on(PROJECTS.PROJECT_ID.eq(ISSUES.PROJECT_ID))

    fun findAll(): List<Project> = select
            .fetch()
            .intoGroups(PROJECTS.fields())
            .values
            .map {
                r ->
                assemble(r)
            }

    fun findOne(id: String): Project? =
            assemble(select
                    .where(PROJECTS.PROJECT_ID.eq(id))
                    .fetch()
                    .into(
                            PROJECTS.PROJECT_ID,
                            PROJECTS.NAME,
                            ISSUES.ISSUE_ID,
                            ISSUES.NAME,
                            ISSUES.DESCRIPTION
                    ))


    private fun assemble(record: Result<out Record>): Project {
        val project = record
                .into(PROJECTS.PROJECT_ID, PROJECTS.NAME)
                .get(0)
        val issues = record
                .sortAsc(PROJECTS.PROJECT_ID)
                .into(ISSUES.ISSUE_ID, ISSUES.NAME, ISSUES.DESCRIPTION)
                .filter { iss -> iss.value1() != null }
                .map { iss -> Issue(iss.value1(), iss.value2(), iss.value3(), project.value1()) }
                .toList()
                .orEmpty()
        return Project(project.value1(), project.value2(), issues)
    }

}