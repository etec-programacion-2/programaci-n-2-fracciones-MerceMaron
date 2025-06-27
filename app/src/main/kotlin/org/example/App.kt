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
}