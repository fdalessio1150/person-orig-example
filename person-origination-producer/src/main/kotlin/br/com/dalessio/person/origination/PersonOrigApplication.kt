package br.com.dalessio.person.origination

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
open class PersonOriginationApplication

fun main(args: Array<String>) {
	runApplication<PersonOriginationApplication>(*args)
}
