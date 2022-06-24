package br.com.dalessio.person.origination

import br.com.dalessio.person.origination.model.*
import org.junit.jupiter.api.DisplayName
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneId
import java.time.ZonedDateTime

class EnrichedPersonFactory {

    companion object EnrichedPersonFactory {
        fun createAddressData(logradouro: String, propositos: Collection<Int>, pais: String): AddressData {
            var addressData: AddressData = AddressData()

            addressData.logradouro = logradouro
            addressData.proposito.addAll(propositos)
            addressData.pais = pais
            return addressData
        }

        fun createPhoneData(ddd: Int, numero: Int, propositos: Collection<Int>): PhoneData {
            var phoneData: PhoneData = PhoneData()

            phoneData.ddd = ddd
            phoneData.numero = numero
            phoneData.proposito.addAll(propositos)
            return phoneData
        }

        fun createValidation(jornada: Int, completude: Int, dateTime: LocalDateTime, chaveDominioList: Collection<Int>, isCritical: Boolean): Validation {
            return Validation(jornada, completude, dateTime, chaveDominioList, isCritical)
        }

        fun createAddress(addressData: AddressData, valiation: Validation): GenericPayload {
            return GenericPayload(addressData, valiation)
        }

        fun createPhone(phoneData: PhoneData, valiation: Validation): GenericPayload {
            return GenericPayload(phoneData, valiation)
        }

        fun createName(nomeCompleto: String, valiation: Validation): GenericPayload {
            return GenericPayload(nomeCompleto, valiation)
        }

        fun createFoundationBirthDate(dataNascimentoFundacao: LocalDateTime, valiation: Validation): GenericPayload {
            return GenericPayload(dataNascimentoFundacao, valiation)
        }

        fun createEnrichedPerson(idCliente: Int, nomeCompleto: GenericPayload, dataNascimentoFundacao: GenericPayload, addresses: Collection<Any>, phones: Collection<Any>): EnrichedPerson {
            return EnrichedPerson(idCliente, nomeCompleto, dataNascimentoFundacao, addresses, phones)
        }

        @DisplayName("Retorna uma lista de enderecos, conforme abaixo:" +
                "1 endereco com 2 propositos unicos" +
                "1 endereco com 1 proposito nao unico" +
                "2 validacoes com a completude 200 e data 2022/06/16 23:02:32")
        fun create_Two_Addresses_With_200(): Collection<GenericPayload> {
            var addressData1: AddressData = createAddressData("Rua da Mooca, 386", mutableListOf(2, 1), "BR")
            var addressData2: AddressData = createAddressData("Av. Paes de Barros, 1002", mutableListOf(3), "BR")

            var validation1: Validation = createValidation(5, 200, LocalDateTime.of(2022, Month.JUNE, 16, 23, 2, 32), mutableListOf(3001402, 3001401), false)
            var validation2: Validation = createValidation(5, 200, LocalDateTime.of(2022, Month.JUNE, 16, 23, 2, 32), mutableListOf(3001403), false)

            var address1: GenericPayload = createAddress(addressData1, validation1)
            var address2: GenericPayload = createAddress(addressData2, validation2)

            return mutableListOf(address1, address2)
        }

        @DisplayName("Retorna uma lista de telefones, conforme abaixo:" +
                "1 telefone com 1 proposito unico e 1 nao unico" +
                "1 telefone com 1 proposito nao unico" +
                "2 validacoes com a completude 200 e data 2022/06/16 23:02:32")
        fun create_Two_Phones_With_200(): Collection<GenericPayload> {
            var phoneData1: PhoneData = createPhoneData(11, 111, mutableListOf(1, 3))
            var phoneData2: PhoneData = createPhoneData(11, 222, mutableListOf(3))

            var validation1: Validation = createValidation(5, 200, LocalDateTime.of(2022, Month.JUNE, 16, 23, 2, 32), mutableListOf(4001401, 4001403), false)
            var validation2: Validation = createValidation(5, 200, LocalDateTime.of(2022, Month.JUNE, 16, 23, 2, 32), mutableListOf(4001403), false)

            var phone1: GenericPayload = createPhone(phoneData1, validation1)
            var phone2: GenericPayload = createPhone(phoneData2, validation2)

            return mutableListOf(phone1, phone2)
        }

        @DisplayName("Retorna um nome, com validacao abaixo:" +
                "1 validacao com a completude 200 e data 2022/06/16 23:02:32")
        fun create_Name_With_200(nomeCompleto: String): GenericPayload {
            var validation1: Validation = createValidation(5, 200, LocalDateTime.of(2022, Month.JUNE, 16, 23, 2, 32), mutableListOf(120), true)

            return createName(nomeCompleto, validation1)
        }

        @DisplayName("Retorna uma data de fundacao / nascimento, com validacao abaixo:" +
                "1 validacao com a completude 200 e data 2022/06/16 23:02:32")
        fun create_Foundation_Birth_Date_With_200(dataNascimentoFundacao: LocalDateTime): GenericPayload {
            var validation1: Validation = createValidation(5, 200, LocalDateTime.of(2022, Month.JUNE, 16, 23, 2, 32), mutableListOf(133), false)

            return createFoundationBirthDate(dataNascimentoFundacao, validation1)
        }

        fun create_Request_With_Two_Addresses_And_Two_Phones_200(): EnrichedPerson {
            return createEnrichedPerson(1,
                    create_Name_With_200("Felipe D'Alessio"),
                    create_Foundation_Birth_Date_With_200(LocalDateTime.of(1991, Month.JULY, 29, 8, 10, 42)),
                    create_Two_Addresses_With_200(),
                    create_Two_Phones_With_200()
            )
        }

        fun create_Database_Empty(): EnrichedPerson {
            return EnrichedPerson()
        }

        fun create_Database_Only_With_Name(): EnrichedPerson {
            var genericPayload: GenericPayload = GenericPayload()
            return createEnrichedPerson(1,
                    create_Name_With_200("Felipe D'Alessio"),
                    genericPayload,
                    mutableListOf(genericPayload),
                    mutableListOf(genericPayload)
            )
        }
    }

}