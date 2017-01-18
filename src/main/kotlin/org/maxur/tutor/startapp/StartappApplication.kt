package org.maxur.tutor.startapp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication



@SpringBootApplication
open class StartappApplication

fun main(args: Array<String>) {
    SpringApplication.run(StartappApplication::class.java, *args)

}
