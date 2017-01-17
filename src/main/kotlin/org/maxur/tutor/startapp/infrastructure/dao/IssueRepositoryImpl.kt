package org.maxur.tutor.startapp.infrastructure.dao

import org.maxur.tutor.startapp.domain.Issue
import org.maxur.tutor.startapp.domain.IssueRepository
import org.springframework.stereotype.Repository

/**
 * @author myunusov
 * @version 1.0
 * @since <pre>17.01.2017</pre>
 */
@Repository
open class IssueRepositoryImpl : IssueRepository {

    private val list = Array(3, { i -> Issue(i.toString(), "issue " + i.toString(), "test") }).asList()

    override fun findAll(): List<Issue> {
        return list
    }

    override fun findBy(id: String): Issue {
        return list.first { it -> it.id == id }
    }

}