package br.com.dalessio.person.origination.controller

import br.com.dalessio.person.origination.model.EnrichedPerson
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class PersonController {

    @PostMapping("/person")
    fun createPerson(@RequestBody request: EnrichedPerson): EnrichedPerson? {
        var database = EnrichedPerson()

        return businessLogic(request, database)
    }

    fun businessLogic(request: EnrichedPerson, database: EnrichedPerson): EnrichedPerson? {
        var result: EnrichedPerson? = null


        return result
    }

}