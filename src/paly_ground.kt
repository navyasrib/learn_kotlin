fun main(args: Array<String>) {
    val data = listOf(1, 2, 3, 4, 5)
    println(perform(data, ::addValues))
    println(perform(data, ::multiply))
    println(factorial(20))
}

fun factorial(limit: Int): Int = if (limit == 1) 1 else limit * factorial(limit - 1)


fun perform(data: List<Int>, method: (Int, Int) -> Int): Int = data.reduce({ a, b -> method(a, b) })

fun addValues(a: Int, b: Int): Int = a + b

fun multiply(a: Int, b: Int): Int = a * b




