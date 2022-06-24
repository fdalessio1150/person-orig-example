package br.com.dalessio.person.origination.model

import com.fasterxml.jackson.annotation.JsonProperty

data class PhoneData (
    @JsonProperty("ddd")
    var ddd: Int? = null,

    @JsonProperty("numero")
    var numero: Int? = null,

    @JsonProperty("proposito")
    var proposito: MutableList<Int> = mutableListOf()
)