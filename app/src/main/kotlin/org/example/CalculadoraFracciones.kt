package org.example
import java.util.Scanner

fun main() { //   NOTA: ACÁ EN LUGAR DE PONER fun main () DEBERÍA IR UNA CLASE. EL PROYECTO NO PUEDE TENER VARIAS fun main ().
    
    fun mostrarMenu() {
       println("=== CALCULADORA DE FRACCIONES ===")
       println("1. Sumar fracciones")
       println("2. Restar fracciones")
       println("3. Multiplicar fracciones")
       println("4. Dividir fracciones")
       println("5. Comparar fracciones")
       println("6. Convertir fracción a decimal")
       println("7. Crear fracción desde decimal")
       println("8. Ejemplos predefinidos")
       println("0. Salir")
       println("Ingrese su opción: ")
    }

    fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion { // Función para leer una fracción desde la entrada del usuario
        println(mensaje)
        print("Numerador: ")
        val numerador = scanner.nextInt() // Leer el numerador
        try denominador != 0 else {
           print("Denominador: ")
            val denominador = scanner.nextInt() // Leer el denominador
        } catch (e: IllegalArgumentException) {
            println("Error: el denominador no puede ser cero.")
            return leerFraccion(scanner, mensaje) // Volver a pedir la fracción
        } catch (e: InputMismatchException) {
            println("Error: Entrada inválida. Debe ingresar un número entero.")
            scanner.next() // Limpiar el buffer
            return leerFraccion(scanner, mensaje) // Volver a pedir la fracción
        } catch (e:InputMismatchException) {
            println("Error: Entrada inválida. Debe ingresar un número entero.")
            scanner.next() // Limpiar el buffer
            return leerFraccion(scanner, mensaje) // Volver a pedir la fracción
        }
        return Fraccion(numerador, denominador)
    }

    fun realizarSuma(scanner: Scanner) {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción para sumar:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción para sumar:")
        println("Resultado: ${f1 + f2}")
    }

    fun realizarResta(scanner: Scanner) {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción para restar:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción para restar:")
        println("Resultado: ${f1 - f2}")
    }

    fun realizarMultiplicacion(scanner: Scanner) {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción para multiplicar:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción para multiplicar:")
        println("Resultado: ${f1 * f2}")
    }

    fun realizarDivision(scanner: Scanner) {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción para dividir:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción para dividir:")
        try {
            println("Resultado: ${f1 / f2}")
        } catch (e: IllegalArgumentException) {
            println("Error: No se puede dividir por cero.")
        }
    }

    fun realizarComparacion(scanner: Scanner) {
        val f1 = leerFraccion(scanner, "Ingrese la primera fracción para comparar:")
        val f2 = leerFraccion(scanner, "Ingrese la segunda fracción para comparar:")
        when {
            f1 > f2 -> println("$f1 es mayor que $f2")
            f1 < f2 -> println("$f1 es menor que $f2")
            else -> println("$f1 es igual a $f2")
        }
    }

    fun convertirADecimal(scanner: Scanner) {
        val f = leerFraccion(scanner, "Ingrese la fracción a convertir a decimal:")
        println("Fracción a decimal: ${f.aDecimal()}")
    }

    fun crearDesdeDecimal(scanner: Scanner) {
        print("Ingrese un número decimal: ")
        val decimal = scanner.nextDouble()
        val fraccionDesdeDecimal = Fraccion.deDecimal_Fracción(decimal)
        println("Fracción equivalente: $fraccionDesdeDecimal")
    }

    fun mostrarEjemplos() {
       println("\n=== EJEMPLOS PREDEFINIDOS ===")
       
       val f1 = Fraccion(1, 2)  // 1/2
       val f2 = Fraccion(1, 3)  // 1/3
       
       println("Fracción 1: $f1")
       println("Fracción 2: $f2")
       println("Suma: $f1 + $f2 = ${f1 + f2}")
       println("Resta: $f1 - $f2 = ${f1 - f2}")
       println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
       println("División: $f1 / $f2 = ${f1 / f2}")
       println("¿$f1 > $f2? ${f1 > f2}")
       println("$f1 en decimal: ${f1.aDecimal()}")
    }

    val scanner = Scanner(System.`in`)
    var opcion: Int
       
       do {
           mostrarMenu()
           opcion = scanner.nextInt()
           
           when (opcion) { // Estructura de control para manejar las opciones del menú
               1 -> realizarSuma(scanner)
               2 -> realizarResta(scanner)
               3 -> realizarMultiplicacion(scanner)
               4 -> realizarDivision(scanner)
               5 -> realizarComparacion(scanner)
               6 -> convertirADecimal(scanner)
               7 -> crearDesdeDecimal(scanner)
               8 -> mostrarEjemplos()
               0 -> println("¡Hasta luego!")
               else -> println("Opción inválida. Intente de nuevo.")
           }
           
           if (opcion != 0) { // Si no se selecciona la opción de salir, se espera a que el usuario presione Enter para continuar
               println("\nPresione Enter para continuar...")
               scanner.nextLine() // Limpiar buffer
               scanner.nextLine() // Esperar Enter
           }
       } while (opcion != 0)
       
    scanner.close()
}
