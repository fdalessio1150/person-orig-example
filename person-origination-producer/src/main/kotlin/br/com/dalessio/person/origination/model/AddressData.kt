package br.com.dalessio.person.origination.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AddressData (
        @JsonProperty("logradouro") var logradouro: String? = null,
        @JsonProperty("proposito") var proposito: MutableList<Int> = mutableListOf(),
        @JsonProperty("pais") var pais: String? = null
)