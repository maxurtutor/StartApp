package org.maxur.tutor.startapp.domain

import org.springframework.stereotype.Repository

val element = Project("1", "Stub", listOf(Issue("1", "Issue-001", "Stub")))

/**
 * The Project repository.
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 *
 */
@Repository
class ProjectRepository {

    fun findAll(): List<Project> =
            // TODO Stub
            listOf(element)


    fun findOne(id: String): Project? =
            // TODO Stub
            if (id == "1") {
                element
            } else {
                null
            }

}