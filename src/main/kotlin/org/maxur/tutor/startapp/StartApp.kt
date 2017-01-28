package org.maxur.tutor.startapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author myunusov
 * @version 1.0
 * @since <pre>28.01.2017</pre>
 */
@SpringBootApplication
open class StartApp

fun main(args: Array<String>) {
    SpringApplication.run(StartApp::class.java, *args)
}
