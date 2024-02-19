package org.example.objects

class Data {
    private var dia:Int = 16
    private var mes:Int = 2
    private var any:Int = 2024

    constructor(){}
    constructor(dia:Int,mes:Int,any:Int){
        this.dia=dia
        this.mes=mes
        this.any=any
    }

    fun setDia(dia:Int){
        this.dia=dia
    }
    fun getDia():Int{
        return dia
    }
    fun setMes(mes:Int){
        this.mes=mes
    }
    fun getMes():Int{
        return mes
    }
    fun setAny(any:Int){
        this.any=any
    }
    fun getAny():Int{
        return any
    }

    override fun toString(): String {
        return "$dia/$mes/$any"
    }
}