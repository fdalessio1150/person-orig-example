package br.com.dalessio.person.origination.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty

class EnrichedPerson(
        @JsonProperty("id_cliente")
        var idCliente: Any? = GenericPayload(),

        @JsonProperty("nome_completo")
        var nomeCompleto: Any? = GenericPayload(),

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
        @JsonProperty("data_nascimento_fundacao")
        var dataNascimentoFundacao: Any? = GenericPayload(),

        @JsonProperty("enderecos")
        var enderecos: Collection<Any> = mutableListOf(),

        @JsonProperty("telefones")
        var telefones: Collection<Any> = mutableListOf()
)