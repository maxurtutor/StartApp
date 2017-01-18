package org.maxur.tutor.startapp.domain

interface IssueRepository {

    fun findAll(): List<Issue>
    fun findBy(id: String): Issue?
    fun add (issue: Issue)

}