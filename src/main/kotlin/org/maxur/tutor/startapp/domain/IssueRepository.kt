package org.maxur.tutor.startapp.domain

import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.SelectWhereStep
import org.maxur.tutor.startapp.db.schema.Tables.ISSUES
import org.maxur.tutor.startapp.db.schema.tables.pojos.Issues
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * The Issue repository.
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 *
 */
@Repository
@Transactional
open class IssueRepository(val dsl: DSLContext) {

    private val select: SelectWhereStep<Record>
        get() = this.dsl.select()
                .from(ISSUES)

    fun findOne(id: String): Issue? =
            select.where(ISSUES.ISSUE_ID.eq(id))
                    .fetchOneInto(Issues::class.java)
                    ?.let { record -> Issue(record.issueId, record.name, record.description, record.projectId)}

    fun add(issue: Issue) {
        dsl.insertInto(ISSUES, ISSUES.ISSUE_ID, ISSUES.NAME, ISSUES.DESCRIPTION, ISSUES.PROJECT_ID)
                .values(issue.id, issue.name, issue.description, issue.projectId)
                .execute()

    }


}