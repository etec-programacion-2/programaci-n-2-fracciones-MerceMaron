package org.example

class Fraccion (private var _numerador: Int, private var _denominador: Int){

    init {
        if (_denominador == 0){
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
    }

   var numerador: Int
       get() = _numerador
       set(value) { _numerador = value }
   
   var denominador: Int
       get() = _denominador
       set(value) { 
           if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
           _denominador = value 
       }

    override fun toString(): String {
        return "${numerador}/${denominador}"
        }

    open fun mostrar(){
        println("Fraccion: ${this.toString()}")
    }

}
