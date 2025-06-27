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
}


/*/### Etapa 2: Suma y Resta de Fracciones

4. **Validaciones:**
   - Verificar que las fracciones a operar sean válidas (denominador ≠ 0)
   - Manejar casos de fracciones negativas
5. **Push al repositorio** con el mensaje "Etapa 2: Implementación de operadores suma y resta de fracciones".*/
