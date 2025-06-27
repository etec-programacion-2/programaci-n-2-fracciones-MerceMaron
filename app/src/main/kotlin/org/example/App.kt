package org.example

fun main() {
    val valores = Fraccion(1, 2)
    valores.mostrar()
    val valores2 = Fraccion(1, 4)
    valores2.mostrar()
    println("Suma: ${valores + valores2}")
    println("Resta: ${valores - valores2}")
}