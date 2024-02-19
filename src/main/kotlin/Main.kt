package org.example

import org.example.objects.*
import org.example.utilidades.*

fun main() {
    //var compte1:CompteCorrent = CompteCorrent(Data(19,2,2024),3426.4,Client("Hugo","Alonso Velasco","48196179R",20))
    //println(compte1)

    var llistaComptes:MutableList<CompteBancari> = mutableListOf()
    var llistaEstalvi:MutableList<CompteEstalvi> = mutableListOf()
    var llistaCorrent:MutableList<CompteCorrent> = mutableListOf()
    var llistaClients:MutableList<Client> = mutableListOf()

    var menu = false
    do{
        menu()
        var opcio = readInt("Introdueix la teva opció entr 0 i 8: ","Error al tipus de dada!","Error al valor de la dada!",0,8)

        when(opcio){
            1 -> {
                var client:Client = crearClient()

                llistaClients.add(client)

                var corrent:CompteCorrent = crearCorrent(client)

                var creable = comprovarExistencia(llistaComptes,client)

                if (creable){
                    llistaComptes.add(corrent)
                    llistaCorrent.add(corrent)
                }

                println(corrent)

            }
            2 -> {
                var client:Client = crearClient()
                llistaClients.add(client)

                var estalvi:CompteEstalvi = crearEstalvi(client)

                var creable = comprovarExistencia(llistaComptes,client)

                if (creable){
                    llistaComptes.add(estalvi)
                    llistaEstalvi.add(estalvi)
                }

                println(estalvi)

            }
            3 -> {
                var dniCompte = readDni("Introdueix el DNI asociat al compte","Ha de tenir 9 caracters!")
                var compte:CompteBancari

                for (i in llistaComptes.indices){
                    if (llistaComptes[i].getPropietari().getDni()==dniCompte){
                        compte = llistaComptes[i]
                        if(compte is CompteCorrent){
                            compte.ingresar()
                        }else {
                            compte.ingresar()
                        }
                    }else{
                        println("No n'hi ha cap compte amb aquest DNI!!")
                    }
                }
            }
            4 -> {
                var dniCompte = readDni("Introdueix el DNI asociat al compte","Ha de tenir 9 caracters!")
                var compte:CompteBancari
                for (i in llistaComptes.indices){
                    if (llistaComptes[i].getPropietari().getDni()==dniCompte){
                        compte = llistaComptes[i]
                        compte.consultarSaldo()
                    }else{
                        println("No n'hi ha cap compte amb aquest DNI!!")
                    }
                }
            }
            5 -> {
                var dniCompte = readDni("Introdueix el DNI asociat al compte","Ha de tenir 9 caracters!")
                var compte:CompteBancari
                for (i in llistaComptes.indices){
                    if (llistaComptes[i].getPropietari().getDni()==dniCompte){
                        compte = llistaComptes[i]
                        if(compte is CompteCorrent){
                            compte.retirarCorrent()
                            println(compte)
                        }else println("No pots retirar d'un compte d'estalvi!")
                    }else{
                        println("No n'hi ha cap compte amb aquest DNI!!")
                    }

                }
            }

            6 -> {
                var dniCompte = readDni("Introdueix el DNI asociat al compte","Ha de tenir 9 caracters!")
                var compte:CompteBancari
                for (i in llistaComptes.indices){
                    if (llistaComptes[i].getPropietari().getDni()==dniCompte){
                        compte = llistaComptes[i]
                        if(compte is CompteCorrent){
                            compte.retirarCorrent()
                            println(compte)
                        }else println("No pots retirar d'un compte d'estalvi!")
                    }else{
                        println("No n'hi ha cap compte amb aquest DNI!!")
                    }
                }
            }

            7 -> {
                for (i in llistaComptes.indices){
                    println("${llistaComptes[i]}\n")
                }
            }

            8 -> {
                for (i in llistaClients.indices){
                    println("${llistaClients[i]}\n")
                }
            }
            else -> menu = true
        }
    }while(!menu)



}

fun comprovarExistencia(llistaComptes: MutableList<CompteBancari>, client: Client): Boolean {
    for (i in llistaComptes.indices){
        if (llistaComptes[i].getPropietari().getDni()==client.getDni()){
            return false
        }
    }
    return true
}

fun printarSaldo(llistaComptes: MutableList<CompteBancari>) {
    var dniCompte = readDni("Introdueix el DNI asociat al compte","Ha de tenir 9 caracters!")

    for (i in llistaComptes.indices){
        if (llistaComptes[i].getPropietari().getDni()==dniCompte){
            println("El saldo del compte ${llistaComptes[i].getNomCompte()} es de ${roundToTwoDecimals(llistaComptes[i].getSaldo().toFloat())}")
        }else{
            println("No n'hi ha cap compte amb aquest DNI!!")
        }
    }
}

fun crearCorrent(client: Client): CompteCorrent {
    var saldo = readFloat("Escriu el saldo del teu compte: ","Tipus de dada incorrecte")

    return CompteCorrent(saldo.toDouble(),client)
}
fun crearEstalvi(client: Client): CompteEstalvi {
    var saldo = readFloat("Escriu el saldo del teu compte: ","Tipus de dada incorrecte")

    return CompteEstalvi(saldo.toDouble(),client)
}

fun crearClient(): Client {
    val nom = readWord("Escriu el nom pel compte d'usuari: ","Error al tipus de dada")
    val cognoms = readSentence("Escriu els teus cognoms pel compte d'usuari: ","Error al tipus de dada")
    val dni = readDni("Introdueix el DNI asociat al compte","Ha de tenir 9 caracters!")
    val edat = readInt("Si us plau, digues la teva edat: ","Tipus de dada incorrecte", "Has de tenir un minim de 16 anys!",16)

    return Client(nom,cognoms,dni,edat)
}

fun menu(){
    println(
        """
            
            Menu de CaixaBank
            0 -> Terminar Programa
            1 -> Crear un compte Corrent
            2 -> Crear un compte Estalvi
            3 -> Ingressar Diners
            4 -> Consultar el saldo d'un compte
            5 -> Retirar diners d'un compte corrent
            6 -> Liquidar Compte Estalvi

            OPCIONS ADMIN
            7 -> Veure tots els comptes
            8 -> Veure tots els clients
            
        """.trimIndent()
    )
}