package org.maxur.tutor.startapp.domain

import org.springframework.hateoas.ResourceSupport

/**
 * @author myunusov
 * @version 1.0
 * @since <pre>18.01.2017</pre>
 */

data class Issue(val id: String, val name: String, val description: String)
