package br.com.dalessio.person.origination

import br.com.dalessio.person.origination.EnrichedPersonFactory.EnrichedPersonFactory.create_Database_Empty
import br.com.dalessio.person.origination.EnrichedPersonFactory.EnrichedPersonFactory.create_Database_Only_With_Name
import br.com.dalessio.person.origination.EnrichedPersonFactory.EnrichedPersonFactory.create_Request_With_Two_Addresses_And_Two_Phones_200
import br.com.dalessio.person.origination.model.*
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.reflect.KClass

class PersonOriginationAddressPhoneEmailResolver {

	private val uniquePropositos: HashSet<Int> = hashSetOf(3001401, 3001402, 4001401, 4001402)
	private val mapper: ObjectMapper = ObjectMapper().registerModule(KotlinModule()).registerModule(JavaTimeModule())

	@DisplayName("Endereco com proposito unico e base de dados vazia.")
	@Test
	fun compare_Address_With_Unique_Purpose_And_Empty_Database() {
		var request: EnrichedPerson = create_Request_With_Two_Addresses_And_Two_Phones_200()
		var database: EnrichedPerson = create_Database_Only_With_Name()

		compare(request, database)
	}

	fun compare(request: EnrichedPerson, database: EnrichedPerson) {
		var requestNode: JsonNode = mapper.valueToTree(request)
		var databaseNode: JsonNode = mapper.valueToTree(database)

		if (null != requestNode.fields()) {
			requestNode.fields().forEach { field ->
				if (null != databaseNode.get(field.key)) {
					if (!field.value.isArray && field.value.isObject) {
						processSimpleFields(field.value, databaseNode.get(field.key))
					}
					if (field.key == "enderecos") {
						processAddress(field.value, databaseNode.get(field.key))
					}

				}
			}
		}
	}

	fun processSimpleFields (requestSimpleField: JsonNode, databaseSimpleField: JsonNode) {
		var genericObject: GenericPayload = mapper.treeToValue(requestSimpleField, GenericPayload::class.java)
		println(genericObject.valorCadastral)
	}


	fun processAddress (requestAddresses: JsonNode, databasesAddresses: JsonNode) {

	}

}
