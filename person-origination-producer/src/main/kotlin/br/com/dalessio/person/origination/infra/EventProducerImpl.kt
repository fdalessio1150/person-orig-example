package br.com.dalessio.person.origination.infra

import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class EventProducerImpl(@Qualifier("mainKafkaProducerTemplate") val mainKafkaProducerTemplate: KafkaTemplate<Any, Any>,
                        @Qualifier("mainKafkaTopicProperty") val kafkaMainTopicProperties: Properties): EventProducer {

    val logger: Logger = LogManager.getLogger(javaClass)

    override fun sendAll(events: List<Any>) {
        events.forEach { any ->
            send(any)
        }
    }

    override fun send(event: Any) {
        var record = envelopEvent(event)

        mainKafkaProducerTemplate.send(record)

        logger.info("Mensagem enviada com sucesso!")
    }

    override fun envelopEvent(event: Any): ProducerRecord<Any, Any> {
        return ProducerRecord(kafkaMainTopicProperties.getProperty("topic"), event, "valor")
    }
}