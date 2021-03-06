package br.com.dalessio.person.origination.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime

data class Validation (
        @JsonProperty("id_jornada")
        var jornada: Int? = null,

        @JsonProperty("nivel_completude")
        var nivelCompletude: Int? = null,

        @JsonProperty("data_atualizacao")
        @JsonDeserialize(using = LocalDateTimeDeserializer::class)
        @JsonSerialize(using = LocalDateTimeSerializer::class)
        var dataAtualizacao: LocalDateTime? = null,

        @JsonProperty("chave_dominio")
        var chaveDominio: Collection<Int> = mutableListOf(),

        @JsonProperty("is_critico")
        var isCritical: Boolean = false
)