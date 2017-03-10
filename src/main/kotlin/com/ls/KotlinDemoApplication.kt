package com.ls

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class Greeting(val id:Long, val content:String)

@RestController
class GreetingController {

    @RequestMapping("/greeting")
    fun Greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        println("dynamic reload...")
        return Greeting(1, name)
    }
}

@SpringBootApplication
class KotlinDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinDemoApplication::class.java, *args)
}
