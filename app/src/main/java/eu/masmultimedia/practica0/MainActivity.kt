package eu.masmultimedia.practica0

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Tarea 1", "${isPalindrome(121)}")
        Log.d("Tarea 1", "${isCapicua(121)}")

        Log.d("Tarea 2", "${media(listOf(1.0, 2.0, 3.0))}")
        Log.d("Tarea 2", "${moda(listOf(1.0, 2.0, 3.0, 3.0, 4.0, 4.0, 4.0))}")
        Log.d("Tarea 2", "${mediana(listOf(3.0, 1.0, 2.0))}")

        //Log.d("Tarea 3", "${longerWord(listOf("Hola chaval pimientito"))}")

        //Log.d("Tarea 4", "${primeNumbersUntil(100)}")

        Log.d("Tarea 5", "${reverse("Esto es una cadena de prueba")}")

        Log.d("Tarea 6", "${mirror("ESPEJO")}")

        Log.d("Tarea 7", "${romanic(1555)}")

        Log.d("Tarea 8", "Son números amigos: ${areFriendNumbers(24, 1)}")


    }

    /*
        Tarea 1 - Comprobar si un número entero es capicúa.
     */
    fun isPalindrome(value: Int): Boolean {

        var result: Boolean = true

        var numberAux = value
        var reversedNumber = 0

        while (numberAux > 0) {
            val rightDigit = numberAux % 10
            reversedNumber = reversedNumber * 10 + rightDigit
            numberAux /= 10
        }

        result = value == reversedNumber

        return result
    }

    fun isCapicua(number: Int): Boolean {
        var number = number.toString()
        var reversedNumber = number.reversed()
        return number == reversedNumber
    }

    /*
        Tarea 2 - Calcular media, moda y mediana de un listado de números.
    */
    fun media(numbers: List<Double>): Double {
        var media = numbers.average()

        return media
    }

/*    fun moda(numbers: List<Double>): Double {
        for (recorrido = 0; recorrido(numbers.size))
        return 1.0
    }*/

    fun moda(moda: List<Double>): Double {
        var maxValue: Double = 0.0
        var maxCount: Double = 0.0
        for (i in moda.indices) {
            var count = 0
            for (j in moda.indices) {
                if (moda[j] == moda[i]) ++count
            }
            if (count > maxCount) {
                maxCount = count.toDouble()
                maxValue = moda[i]
            }
        }
        return maxValue
    }

    /*
        Puesto que la mediana es el valor que se encuentra justo en la mitad ordenada de la lista,
        si esta tiene un número par de elementos, tendremos que hayar la media entre los dos valores
        que se encuentren en el centro
    */
    fun mediana(numbers: List<Double>): Double {
        val numbersSorted: List<Double> = numbers.sorted()
        var mediana = 0
        var mitad = numbersSorted.size / 2
        if (numbers.size % 2 == 0) {
            mediana = (numbersSorted[(mitad - 1)].toInt() + numbersSorted[(mitad)].toInt()) / 2
        } else {
            mediana = numbersSorted[mitad].toInt()
        }
        return mediana.toDouble()
    }

    /*
        Tarea 3 - Obtener la cadena de caracteres más larga contenida en un listado de cadenas.
    */
    fun longerWord(words: List<String>): String {
        var words = words.toString()
        var longerWordSize = 0
        var use = 0
        var longerWord = ""
        while (!words.isEmpty()) {
            words = words.trim() { it <= ' ' }
            use = words.indexOf(" ")
            if (use < 0) {
                break
            }
        }
        val cut = words.substring(0, use)
        if (cut.length > longerWordSize) {
            longerWord = cut
        }
        longerWordSize = longerWord.length
        words = words.substring(use + 1)
        return longerWord
    }

    /*
        Tarea 4 - Mostrar los números primos entre 1 y 100
    */
    fun primeNumbersUntil(number: Int): List<Int> {
        var low = 20
        var hightNumber: Int = number

        while (low < hightNumber) {
            var flag = false
            for (i in 2..low) {
                if (low % i == 0) {
                    flag = true
                    break
                }
            }
            if (!flag) {
                Log.d("Tarea 4", "$low")
                ++low
            }
        }
        return arrayListOf<Int>(low)
    }

    /*
        Tarea 5 - Invertir una cadena de caracteres dada
    */
    fun reverse(word: String): String? {
        var initialWord = word
        var invertedWord = word.reversed()

        return invertedWord
    }

    /*
        Tarea 6 - Retornar una cadena de caracteres dada invertida y con efecto espejo desde el último carácter.
        * Ejemplo: dada la cadena “android”, debe retornar “androidiordna”
    */
    fun mirror(word: String): String? {

        var initialWord = word
        var invertedWord = word.reversed()

        var mirrorWord = initialWord + invertedWord

        return mirrorWord
    }

    /*
        Tarea 7 - Dado un número positivo y mayor que 0, representarlo en número romano.
        * Ejemplo: 7 -> VII
    */
    fun romanic(number: Int): String? {

        val m = arrayOf("", "M", "MM", "MMM")
        val c = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        val x = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        val i = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

        val thousands = m[number / 1000]
        val hundreds = c[number % 1000 / 100]
        val tens = x[number % 100 / 10]
        val ones = i[number % 10]

        return thousands + hundreds + tens + ones
    }

    /*
        Tarea 8 - Dado dos números enteros, comprobar que sean amigos. Dos números son amigos,
        si la suma de sus factores (distintos de ellos mismos y de uno) son iguales.
        * Ejemplo: 24 (Factores: 2 y 3, Suma: 5) y 25 (Factores: 5, Suma: 5) son números amigos
    */
    fun areFriendNumbers(first: Int, second: Int): Boolean? {

        val factorListFirst: MutableList<Int> = mutableListOf() // Lista para guardar los factores
        val factorListSecond: MutableList<Int> = mutableListOf() // Lista para guardar los factores

        for (i in 1..first) { // bucle sobre un rango
            if (first % i == 0) { // si se cumple la condición, es un factor
                factorListFirst.add(i)
            }
        }

        for (i in 1..second) { // bucle sobre un rango
            if (first % i == 0) { // si se cumple la condición, es un factor
                factorListSecond.add(i)
            }
        }
        Log.d(
            "Tarea 8", "Factores de $first son: $factorListFirst \n Factores de $second " +
                    "son: $factorListSecond"
        )
        return factorListFirst.sum() == factorListSecond.sum()
    }

    /*
      Tarea 9 - Juego de mesa
        * Estamos construyendo un juego de mesa, y para el sistema de puntuación se nos ha ocurrido usar
        cartas de manera que sumando sus valores podamos llegar a cualquier puntuación.
        * Las cartas son caras así que NO queremos cartas REPETIDAS.
        * Dado un número P, tenemos que calcular el mínimo número de cartas necesarias para poder
        representar todos los números desde 1 a P
        * Ejemplo 1
            * Entrada -> 1
            * Salida -> Con la carta 1 ya representamos esa puntuación
        * Ejemplo 2
            * Entrada -> 6
            * Salida -> Nos hacen falta 3 cartas (1,2,3) para representar todos los números del 1 al 6
        * Ejemplo 3
            * Entrada -> 7
            * Salida -> 3 cartas. (1,2,4)
        Ejemplo 4
            * Entrada 15 ->
            * Salida -> 4 cartas (1,2,4,8)
    */
    fun minCards(number: Int): MutableList<Int?>? {
        return ArrayList()
    }

    /*
        Tarea 10 - La Gofrería
    * Tenéis una fantabulosa pastelería y vuestra especialidad son los gofres. Para organizar los
    tamaños contáis las líneas horizontales y verticales de cada gofre, pero vuestros clientes sólo
    quieren saber el tamaño del gofre en número de cuadrados.
    * Calcular dado el número de líneas verticales y el número de líneas horizontales el número de
    cuadrados del gofre.
    * Ejemplo
        * 5 Líneas verticales
        * 5 Líneas horizontales
        * 16 cuadrados

        NOTAS:

        Si tengo N horizontales por M verticales, tengo (N-1) * (M-1) cuadrados
        Opción 1: Pintar la matriz con los datos de filas y columnas que me den, luego contar los
        campos uno a uno
     */
    fun squares(verticalLinesCount: Int, horizontalLinesCount: Int): Int? {
        return -1
    }

    fun numeroCuadradosGofre(fil: Int, col: Int): Int? {

        var matriz = Array(fil) { IntArray(col) }
        var esSimetrica = true
        for (i in 0 until fil) {
            for (j in 0 until fil) {
                matriz[i][j] = Log.d("Tarea9", "Matriz[${i + 1}][${j + 1}]")
            }
        }
        var sumaFil = 0
        for (i in 0 until fil) {
            sumaFil = 0
            for (j in 0 until fil) {
                sumaFil = sumaFil + matriz[i][j]
            }
            println("La suma de la fila ${i + 1}=$sumaFil")
        }
        var sumaCol = 0
        for (j in 0 until col) {
            sumaCol = 0
            for (i in 0 until fil) {
                sumaCol = sumaCol + matriz[i][j]
            }
            println("La suma de la columna ${j + 1}=$sumaCol")
        }
        return 1
    }
}