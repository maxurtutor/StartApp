package org.maxur.tutor.startapp.domain

/**
 * The Project
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 */
data class Project(val id: String, val name: String, val issues: Collection<Issue>)