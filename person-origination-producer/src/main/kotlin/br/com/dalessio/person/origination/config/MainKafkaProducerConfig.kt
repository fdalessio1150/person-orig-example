package br.com.dalessio.person.origination.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import java.util.*

@Configuration
open class MainKafkaProducerConfig {

    @Value("\${kafka.producer.bootstrap.servers}")
    val bootstrapServers: String = ""

    @Value("\${kafka.producer.key.serializer}")
    val keySerializer: String = ""

    @Value("\${kafka.producer.value.serializer}")
    val valueSerializer: String = ""

    @Value("\${kafka.producer.client.id}")
    val clientId: String = ""

    @Value("\${kafka.producer.compression.type}")
    val compressionType: String = ""

    @Value("\${kafka.producer.batch.size}")
    val batchSize: String = ""

    @Value("\${kafka.producer.retry.backoff.ms}")
    val retryBackoffMs: String = ""

    @Value("\${kafka.producer.max.in.flight.requests.per.connection}")
    val maxInFlightRequestsPerConnection: String = ""

    @Value("\${kafka.producer.delivery.timeout.ms}")
    val deliveryTimeoutMs: String = ""

    @Value("\${kafka.producer.request.timeout.ms}")
    val requestTimeoutMs: String = ""

    @Value("\${kafka.producer.linger.ms}")
    val lingerMs: String = ""

    @Value("\${kafka.producer.metrics.recording.level}")
    val metricsRecordingLevel: String = ""

    @Value("\${kafka.producer.acks}")
    val acks: String = ""

    @Value("\${kafka.producer.retries}")
    val retries: String = ""

    @Value("\${kafka.main.topic.min.insync.replicas}")
    val minInsyncReplicas: String = ""

    @Value("\${kafka.main.topic}")
    val topic: String = ""

    @Bean("mainKafkaProducerTemplate")
    open fun kafkaProducerTemplate(): KafkaTemplate<Any, Any> {
        return KafkaTemplate(DefaultKafkaProducerFactory<Any, Any>(mapOf("bootstrap.servers" to bootstrapServers,
                "key.serializer" to keySerializer,
                "value.serializer" to valueSerializer,
                "acks" to acks,
                "retries" to retries,
                "client.id" to clientId + "-" + UUID.randomUUID(),
                "compression.type" to compressionType,
                "delivery.timeout.ms" to deliveryTimeoutMs,
                "batch.size" to batchSize,
                "retry.backoff.ms" to retryBackoffMs,
                "max.in.flight.requests.per.connection" to maxInFlightRequestsPerConnection,
                "request.timeout.ms" to requestTimeoutMs,
                "linger.ms" to lingerMs,
                "metrics.recording.level" to metricsRecordingLevel)))
    }

    @Bean("mainKafkaTopicProperty")
    open fun kafkaMainTopicProperty(): Properties {
        val props = Properties()
        props["topic"] = topic
        props["min.insync.replicas"] = minInsyncReplicas

        return props
    }
}