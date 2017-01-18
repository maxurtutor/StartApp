package org.maxur.tutor.startapp.infrastructure.resources

import org.maxur.tutor.startapp.domain.Issue
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.stereotype.Component

/**
 * @author myunusov
 * @version 1.0
 * @since <pre>19.01.2017</pre>
 */
@Component
open class IssueResourceProcessor : ResourceProcessor<Resource<Issue>> {

    @Override
    override fun process(resource: Resource<Issue>): Resource<Issue> {
        val issue = resource.getContent()
        resource.add(ControllerLinkBuilder.linkTo(IssueResourceController::class.java)
                .slash(issue.id)
                .withRel("update"))
        resource.add(ControllerLinkBuilder.linkTo(IssueResourceController::class.java)
                .slash(issue.id)
                .withRel("deletion"))
        return resource
    }

}