package org.maxur.tutor.startapp.api.rest

import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
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
@RequestMapping("/")
class ApplicationController {

    @ResponseBody
    @GetMapping(produces = arrayOf("application/hal+json"))
    fun allProjects(): Resource<Application> =
            Resource(
                    Application(),
                    linkTo(ApplicationController::class.java).withSelfRel(),
                    linkTo(ProjectController::class.java).withRel("projects")
            )

    @Suppress("unused")
    class Application {
        val name = "Start App"
    }

}
