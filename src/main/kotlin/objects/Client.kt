package org.example.objects

class Client {
    private var nom:String = ""
    private var cognoms:String = ""
    private var dni:String = "12345678A"
    private var edad:Int = 16

    constructor(){}

    constructor(nom:String,cognoms:String,dni:String,edad:Int){
        this.nom=nom
        this.cognoms=cognoms
        this.dni=dni
        this.edad=edad
    }

    fun setNom(nom:String){
        this.nom=nom
    }
    fun getNom():String{
        return nom
    }

    fun setCognom(cognoms:String){
        this.cognoms=cognoms
    }
    fun getCognom():String{
        return cognoms
    }

    fun setDni(dni:String){
        this.dni=dni
    }
    fun getDni():String{
        return dni
    }

    fun setEdad(dni:Int){
        this.edad=edad
    }
    fun getEdad():Int{
        return edad
    }

    override fun toString(): String {
        return "\n -Nom: $nom\n"+
                " -Cognom: $cognoms\n"+
                " -DNI: $dni\n"+
                " -Edad: $edad\n"
    }

}