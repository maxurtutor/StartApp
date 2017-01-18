package org.maxur.tutor.startapp

import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.maxur.tutor.startapp.domain.Issue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.hateoas.UriTemplate
import org.springframework.hateoas.hal.CurieProvider
import org.springframework.hateoas.hal.DefaultCurieProvider

/**
 * @author myunusov
 * @version 1.0
 * @since <pre>19.01.2017</pre>
 */
@Configuration
open class ApplicationConfiguration {

    @Bean
    open fun newJavaTimeModule(): Module {
        return JavaTimeModule()
    }

    @Configuration
    open class CustomRepositoryRestMvcConfiguration : RepositoryRestConfigurerAdapter() {

        override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
            config.exposeIdsFor(Issue::class.java)
        }

        override fun configureValidatingRepositoryEventListener(validatingListener: ValidatingRepositoryEventListener) {
        }

        @Bean
        open fun curieProvider(): CurieProvider {
            return DefaultCurieProvider("startapp", UriTemplate("http://localhost:8080/docs/api-guide.html#{rel}"))
        }

    }

}