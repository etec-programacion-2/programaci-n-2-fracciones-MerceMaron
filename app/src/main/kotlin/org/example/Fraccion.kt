package org.example

class Fraccion (private var _numerador: Int, private var _denominador: Int){ //los atributos siempre deben ser privados. MUY IMPORTANTE

    init { //init es la función que maneja el constructor. Si se quiere validar algo, se hace en init
        if (_denominador == 0){ // se valida que el denominador no sea cero
            throw IllegalArgumentException("El denominador no puede ser cero")
        }
    }

   var numerador: Int //se crean variables de tipo Int para el numerador y denominador, ambas públicas
       get() = _numerador
       set(value) { _numerador = value }
   
   var denominador: Int
       get() = _denominador
       set(value) { 
           if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
           _denominador = value 
       }

    override fun toString(): String { //se sobreescribe toString para que retorne la fracción en formato "numerador/denominador"
        return "${numerador}/${denominador}"
        }

    open fun mostrar(){ //se crea una función mostrar que imprime la fracción en consola
        println("Fraccion: ${this.toString()}")
    }

    operator fun plus(otra:Fraccion):Fraccion{ //se suman dos fracciones
        val nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador). simplificar () //se simplifica la fracción
    }
    
    operator fun minus (otra:Fraccion): Fraccion{ //se restan dos fracciones
        val nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador
        val nuevoDenominador = this.denominador * otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar() //se simplifica la fracción
    }

    private fun simplificar(): Fraccion { // Función que devuelve el MCD usando el algoritmo de Euclides
    fun mcd(a: Int, b: Int): Int { //se define una función mcd que recibe dos enteros y devuelve el máximo común divisor
        var num1 = a // se asigna el primer número a num1
        var num2 = b // se asigna el segundo número a num2
        while (num2 != 0) { // mientras num2 no sea cero, se ejecuta el bucle
            val resto = num1 % num2 // se calcula el resto de la división de num1 entre num2
            num1 = num2 // se asigna num2 a num1 y el resto a num2 para continuar con el bucle y poder encontrar el MCD
            num2 = resto
        }
        return num1
    }

    val divisorComun = mcd(numerador, denominador) // se obtiene el MCD de los números del numerador y denominador
    return Fraccion(numerador / divisorComun, denominador / divisorComun) // se devuelve una nueva fracción simplificada dividiendo el numerador y denominador por el MCD encontrado
    } 

    operator fun times(otra:Fraccion):Fraccion{ //se crea una función para multiplicar dos fracciones
        if (otra.numerador == 0 && this.numerador == 0 && otra.denominador==0 && this.denominador==0) { //validación para evitar división por cero
            throw IllegalArgumentException("Los valores (numerador o denominador) de las fracciones no pueden ser cero")
        }
        val nuevoNumerador=this.numerador*otra.numerador
        val nuevoDenominador=this.denominador*otra.denominador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    operator fun div (otra:Fraccion):Fraccion{
        val nuevoNumerador=this.numerador*otra.denominador
        if (otra.numerador == 0 && this.numerador == 0 && otra.denominador==0 && this.denominador==0) {
            throw IllegalArgumentException("Los valores (numerador o denominador) de las fracciones no pueden ser cero")
        }
        val nuevoDenominador=this.denominador*otra.numerador
        return Fraccion(nuevoNumerador, nuevoDenominador).simplificar()
    }

    operator fun compareTo(otra: Fraccion): Int { //se crea una función para comparar dos fracciones
        val thisDecimal = this.numerador.toDouble() / this.denominador //se convierte la fracción a decimal
        val otraDecimal = otra.numerador.toDouble() / otra.denominador //se convierte la otra fracción a decimal
        return thisDecimal.compareTo(otraDecimal) //se compara el valor decimal de ambas fracciones
    }

    override operator fun equals(other: Any?): Boolean { //se sobreescribe el operador de igualdad
        if (this === other) return true //si son la misma instancia, son iguales
        if (other !is Fraccion) return false //si el otro objeto no es una fracción, no son iguales
        return this.numerador * other.denominador == this.denominador * other.numerador //se compara el producto cruzado para verificar igualdad
    }

    fun esMayor(otra: Fraccion): Boolean { //se crea un método para verificar si una fracción es mayor que otra
        return this > otra //se utiliza el operador de comparación
    }

    fun esMenor(otra: Fraccion): Boolean { //se crea un método para verificar si una fracción es menor que otra
        return this < otra //se utiliza el operador de comparación
    }

    fun aDecimal (): Double { //se crea un método para convertir la fracción a decimal
        return this.numerador.toDouble() / this.denominador //se divide el numerador por el denominador y se convierte a Double
    }

    companion object { //se crea un objeto companion para definir métodos estáticos
        fun deDecimal_Fracción(decimal: Double): Fraccion { //método para crear una fracción a partir de un decimal
            val numerador = (decimal * 10000).toInt() //se multiplica el decimal por 10000 para evitar problemas de precisión
            val denominador = 10000 //se define el denominador como 10000
            return Fraccion(numerador, denominador).simplificar() //se devuelve la fracción simplificada
        }
    }

}
