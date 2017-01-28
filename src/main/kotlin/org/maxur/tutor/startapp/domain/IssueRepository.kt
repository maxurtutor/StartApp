package org.maxur.tutor.startapp.domain

import org.springframework.stereotype.Repository

/**
 * The Issue repository.
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 *
 */
@Repository
class IssueRepository {

    val element = Issue("1", "Issue-001", "Stub")

    fun findOne(id: String): Issue? =
            // TODO Stub
            if (id == "1") {
                element
            } else {
                null
            }

}