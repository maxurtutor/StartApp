package org.maxur.tutor.startapp.infrastructure.resources

import org.maxur.tutor.startapp.domain.Issue
import org.maxur.tutor.startapp.domain.IssueRepository
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author myunusov
 * @version 1.0
 * @since <pre>17.01.2017</pre>
 */
@RestController
@RequestMapping("/issues")
open class IssueResourceController(val repository: IssueRepository) {

    @ResponseBody
    @GetMapping("", produces = arrayOf("application/hal+json"))
    fun findAll(): Resources<Resource<Issue>>? {
        val issues = repository.findAll()

        val list = issues.map {it -> this.buildResource(it)}

        return Resources(
                list,
                linkTo(IssueResourceController::class.java).withSelfRel()
        )
    }

    @ResponseBody
    @GetMapping("/{id}", produces = arrayOf("application/hal+json"))
    fun get(@PathVariable id : String): Resource<Issue> {
        val issue = repository.findBy(id) ?: throw ResourceNotFoundException()
        return this.buildResource(issue)
    }

    @ResponseBody
    @PostMapping("", produces = arrayOf("application/hal+json"), consumes = arrayOf("application/json"))
    fun add(@RequestBody issue: Issue): ResponseEntity<Resource<Issue>>{
        repository.add(issue)
        val headers: HttpHeaders = HttpHeaders()
        headers.add(
                HttpHeaders.LOCATION,
                linkTo(IssueResourceController::class.java).slash(issue.id).withSelfRel().expand(issue.id).href
        )
        return ResponseEntity(buildResource(issue), headers, HttpStatus.CREATED)
    }

    private fun buildResource(issue: Issue): Resource<Issue> {
        val link = linkTo(IssueResourceController::class.java).slash(issue.id).withSelfRel()
        val result = Resource(issue, link.expand(issue.id))
        return result;
    }

}

