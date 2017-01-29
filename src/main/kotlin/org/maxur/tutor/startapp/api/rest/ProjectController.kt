package org.maxur.tutor.startapp.api.rest

import org.maxur.tutor.startapp.domain.Issue
import org.maxur.tutor.startapp.domain.Project
import org.maxur.tutor.startapp.domain.ProjectRepository
import org.springframework.hateoas.ExposesResourceFor
import org.springframework.hateoas.ResourceSupport
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody



/**
 * Project Resource Controller
 *
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 */
@Controller
@ExposesResourceFor(Project::class)
@RequestMapping("/projects")
class ProjectController(val repository: ProjectRepository) {

    @ResponseBody
    @GetMapping(produces = arrayOf("application/hal+json"))
    fun allProjects(): ProjectsResource {
        val resource = ProjectsResource(repository.findAll().map { this.brief(it) })
        resource.add(linkTo(ProjectController::class.java).withSelfRel())
        return resource
    }

    @GetMapping("/{id}", produces = arrayOf("application/hal+json"))
    fun projectBy(@PathVariable id: String): HttpEntity<FullProjectResource> {
        val project = repository.findOne(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(full(project), HttpStatus.OK)
    }

    @Suppress("unused")
    class ProjectsResource(val projects: List<BriefProjectResource>) : ResourceSupport()

    private fun brief(project: Project): BriefProjectResource {
        val resource = BriefProjectResource(project.name)
        val link = linkTo(ProjectController::class.java)
                .slash(project.id)
                .withSelfRel()
        resource.add(link)
        return resource
    }

    @Suppress("unused")
    inner class BriefProjectResource(val name: String): ResourceSupport()

    private fun full(project: Project): FullProjectResource {
        val link = linkTo(ProjectController::class.java)
                .slash(project.id)
                .withSelfRel()
        val resource = FullProjectResource(project)
        resource.add(link)
        return resource
    }

    @Suppress("unused")
    inner class FullProjectResource(project: Project): ResourceSupport() {
        val name: String = project.name
        val issues: List<BrifIssueResource> = project.issues.map { brief(it) }

        private fun brief(issue: Issue): BrifIssueResource {
            val resource = BrifIssueResource(issue)
            val link = linkTo(IssueController::class.java)
                    .slash(issue.id)
                    .withSelfRel()
            resource.add(link)
            return resource
        }

        inner class BrifIssueResource(issue: Issue): ResourceSupport()  {
            val title: String = "${issue.id}: ${issue.name}"
        }
    }

}

