import java.math.BigInteger

fun main(args: Array<String>) {
    val data = listOf(1, 2, 3, 4, 5)
    println(perform(data, ::addValues))
    println(perform(data, ::multiply))
    println(factorial(BigInteger("500")))
    println(pythagoreanTriples(50))
}

fun perform(data: List<Int>, method: (Int, Int) -> Int) = data.reduce { a, b -> method(a, b) }

fun addValues(a: Int, b: Int) = a.and(b)

fun multiply(a: Int, b: Int) = a.times(b)

val one = BigInteger("1")
tailrec fun factorial(limit: BigInteger, result: BigInteger = one): BigInteger =
        if (limit <= one)
            result
        else
            factorial(limit.minus(one), limit.times(result))

fun pythagoreanTriples(limit: Int) = (1..limit).flatMap { a ->
    (a..limit).flatMap { b ->
        (b..limit).filter { c ->
            a.times(a) + b.times(b) == c.times(c)
        }.map { Triple(a, b, it) }
    }
}