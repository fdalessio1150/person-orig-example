package br.com.dalessio.person.origination

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.math.max

class PersonOriginationApplicationTests {


	fun abbreviation(a: String, b: String): String {
		// Write your code here
		var aux = a.toCharArray()
		var upperCaseA = a.toUpperCase().toCharArray()
		var upperCaseB = b.toUpperCase().toCharArray()
		var finalArray: ArrayList<String> = ArrayList()

		var checkpointB: Int = 0
		var checkpointA: Int = 0


		while (checkpointB <= upperCaseB.size-1) {
			println("Caracter: "+ upperCaseB[checkpointB])
			if((checkpointA - (upperCaseA.size-1)) == 1) {
				return "NO"
			} else {
				for (i: Int in checkpointA..upperCaseA.size-1) {
					println("E igual a: "+ upperCaseA[i])

					if (upperCaseB[checkpointB] == upperCaseA[i]) {
						println("Encontrei: "+ upperCaseA[i])
						finalArray.add(aux.get(i).toString())
						checkpointB += 1
						checkpointA = i + 1
						break
					}

					if (Character.isLowerCase(aux.get(i)) || upperCaseB[maxOf(0,checkpointB-1)] == upperCaseA[i]) {
						finalArray.add(aux.get(i).toString())
					}


					if (i == upperCaseA.size-1) {
						println("Nao encontrei o caracter: "+ upperCaseB[checkpointB])
						checkpointB = upperCaseB.size
						return "NO"
					}
				}
			}
		}

		for (j: Int in checkpointA..upperCaseA.size-1) {
			if (Character.isLowerCase(aux.get(j)) || upperCaseB[maxOf(0,checkpointB-1)] == upperCaseA[j]) {
				finalArray.add(aux.get(j).toString())
			}
		}

		if (finalArray.size != a.length) {
			return "NO"
		}

		return "YES"
	}

	@Test
	fun hackerRank() {
		//var a: String = "BFZZVHdQYHQEMNEFFRFJTQmNWHFVXRXlGTFNBqWQmyOWYWSTDSTMJRYHjBNTEWADLgHVgGIRGKFQSeCXNFNaIFAXOiQORUDROaNoJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMvSTGEQCYAJSFvbqivjuqvuzafvwwifnrlcxgbjmigkms"
		//var b: String = "BFZZVHQYHQEMNEFFRFJTQNWHFVXRXGTFNBWQOWYWSTDSTMJRYHBNTEWADLHVGIRGKFQSCXNFNIFAXOQORUDRONJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMSTGEQCYAJSF"
		var a: String = "hHhAhhcahhacaccacccahhchhcHcahaahhchhhchaachcaCchhchcaccccchhhcaahhhhcaacchccCaahhaahachhacaahhaachhhaaaCalhhchaccaAahHcchcazhachhhaaahaahhaacchAahccacahahhcHhccahaachAchahacaahcahacaahcahacaHhccccaahaahacaachcchhahhacchahhhaahcacacachhahchcaAhhcaahchHhhaacHcacahaccccaaahacCHhChchhhahhchcahaaCccccahhcaachhhacaaahcaaaccccaacaaHachaahcchaahhchhhcahahahhcaachhchacahhahahahAahaAcchahaahcaaaaahhChacahcacachacahcchHcaahchhcahaachnachhhhcachchahhhacHhCcaHhhhcaCccccaaahcahacahchahcaachcchaachahhhhhhhhcahhacacCcchahccaaaaaHhhccaAaaaCchahhccaahhacaccchhcahhcahaahhgacahcahhchcaaAccchahhhaahhccaaHcchaccacahHahChachhcaaacAhacacaacacchhchchacchchcacchachacaahachccchhhaccahcacchaccaahaaaccccccaaaaaaaHhcahcchmcHchcchaaahaccchaaachchHahcaccaaccahcacacahAhaacaacaccaccaaacahhhcacAhaCchcaacCcccachhchchcchhchahchchahchchhchcacaachahhccacachaAhaaachchhchchchhaachahaahahachhaaaccacahhcacchhhaaachaaacAahhcachchachhhcacchacaaChCahhhccahChaachhcahacchanaaacchhhccacacchcahccchAcahacaaachhacchachccaaHacaacAhahcCh"
		var b: String = "HAHHCHAACCCAHCHHAHHAHCACCHCCHHCAAHHCACCCAHHHACAAHHHHCHHCAHHAHHAAAHAACAAHAHHCAHAHACHACHCHACACHAAHHAAAHCAHHACACAACHHHCHAHCAHCHHHAHAHACCAAAHCHHCHHCCAACCCCAACHACAACAAHACHCHAHHACCHCAHHHAAACHACAACHCACACAHHCCHAHACCCACCAACHCHHHCCCCCHCCAHHCAAHHAHHHHHHHAACCCCAHCCAAAAAHHHAAAACCAHHCAHACACCHHCHAHAHHCHAACHHHHHCCHCCAHAHCHCAAACCACCCCHACCACHHACHHACACHACCAACCCCAAAAHHAHCHHHCCAHCCHACHHAHCCACACCHAHAAACACCCCAHCCAHACCCCCCHCCHHCHHHHCHCHCAHHHACHAHAACCCAAAACHAACAAAHHAAHAAAHACHHCACHCCHCHAACHACACHHCCCCCAHCACHAAAHCHCAHACAAC"
		abbreviation(a, b)
	}

}
