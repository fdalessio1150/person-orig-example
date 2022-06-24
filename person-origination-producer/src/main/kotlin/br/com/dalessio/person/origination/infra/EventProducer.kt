package br.com.dalessio.person.origination.infra

import org.apache.kafka.clients.producer.ProducerRecord

interface EventProducer {

    fun send(event: Any)
    fun envelopEvent(event: Any): ProducerRecord<Any, Any>
    fun sendAll(events: List<Any>)
}