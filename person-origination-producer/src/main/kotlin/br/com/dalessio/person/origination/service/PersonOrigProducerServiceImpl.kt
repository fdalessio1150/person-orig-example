package br.com.dalessio.person.origination.service

import br.com.dalessio.person.origination.infra.EventProducer
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class PersonOrigProducerServiceImpl(val eventProducer: EventProducer) {

    //@Scheduled(fixedDelay = 10000)
    fun produceEvents() {
        eventProducer.send("chave")
    }
}