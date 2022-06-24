package br.com.dalessio.person.origination.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GenericPayload (
        @JsonProperty("valor_cadastral") var valorCadastral: Any? = null,
        @JsonProperty("validacao") var validacao: Validation? = Validation()
)