package org.example

fun main() {
    val valores = Fraccion(2, 3)
    valores.mostrar()
    val valores2 = Fraccion(1, 4)
    valores2.mostrar()
    println("Suma: ${valores + valores2}")
    println("Resta: ${valores - valores2}")
    println("Multiplicación: ${valores * valores2}")
    println("División: ${valores / valores2}")
    println("Comparación: el valor de la primera fracción es ${if (valores > valores2) "mayor" else "menor"} al de la segunda fracción")
    println("Comparación: el valor de la primera fracción es ${if (valores == valores2) "igual" else "diferente"} al de la segunda fracción")
    println("Fracción 1 a decimal: ${valores.aDecimal()}")
    println("Fracción 2 a decimal: ${valores2.aDecimal()}")
    println("Fracción 1 desde decimal: ${Fraccion.deDecimal_Fracción(0.64)}")

    



}