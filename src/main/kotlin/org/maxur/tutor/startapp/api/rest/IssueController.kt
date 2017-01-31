package org.maxur.tutor.startapp.api.rest

import org.maxur.tutor.startapp.domain.Issue
import org.maxur.tutor.startapp.domain.IssueRepository
import org.springframework.hateoas.ExposesResourceFor
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

/**
 * Project Resource Controller
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 */
@Controller
@ExposesResourceFor(Issue::class)
@RequestMapping("/issues")
class IssueController(val repository: IssueRepository)  {

    @GetMapping("/{id}", produces = arrayOf("application/hal+json"))
    fun projectBy(@PathVariable id: String): HttpEntity<FullIssueResource> {
        val issue = repository.findOne(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(full(issue), HttpStatus.OK)
    }

    @ResponseBody
    @PostMapping("", produces = arrayOf("application/hal+json"), consumes = arrayOf("application/json"))
    fun add(@RequestBody issue: Issue): ResponseEntity<FullIssueResource>{
        repository.add(issue)
        val headers: HttpHeaders = HttpHeaders()
        headers.add(
                HttpHeaders.LOCATION,
                linkTo(IssueController::class.java).slash(issue.id).withSelfRel().expand(issue.id).href
        )
        return ResponseEntity(full(issue), headers, HttpStatus.CREATED)
    }

    private fun full(issue: Issue): FullIssueResource {
        val link = ControllerLinkBuilder.linkTo(IssueController::class.java)
                .slash(issue.id)
                .withSelfRel()
        val resource = FullIssueResource(issue)
        resource.add(link)
        return resource
    }

    @Suppress("unused")
    class FullIssueResource(issue: Issue) : ResourceSupport() {
        val id = issue.id
        val name = issue.name
        val description = issue.description
    }

}

