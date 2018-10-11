@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var s = 0
    var m = n
    do {
        s = (s + 1)
        m = (n % 10)
    } while (m != 0)
    return (s)
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var s = 1
    var a = 1
    var b = 1
    if ((n == 1) || (n == 2)) return (1) else
        for (m in 3..n) {
            s = a
            a = b
            b = (a + s)
        }
    return (b)
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int = (m * n) / nod(m, n)

fun nod(m: Int, n: Int): Int {
    var a = m
    var b = n
    while ((a != 0) && (b != 0)) {
        if (a > b) a = (a % b)
        else b = (b % a)
    }
    return (a + b)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var s = 2
    while ((n % s) !== 0) {
        s = (s + 1)
    }
    return (s)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int = n / minDivisor(n)

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = (nod(m, n) == 1)

fun pow(x: Double, y: Double): Double {
    var s = x
    if (y == 1.0) return (x) else
        for (i in 2..y.toInt()) {
            s = (s * x)
        }
    return (s)
}

fun pow(x: Int, y: Int): Int {
    var s = x
    if (y == 1) return (x) else
        for (i in 2..y) {
            s = (s * x)
        }
    return (s)
}

fun pow(x: Int, y: Double): Int {
        var s = x
        if (y.toInt() == 1) return (x) else
            for (i in 2..y.toInt()) {
                s = (s * x)
            }
        return (s)
}

fun pow(x: Double, y: Int): Double {
    var s = x
    if (y == 1) return (x) else
        for (i in 2..y) {
            s = (s * x)
        }
    return (s)
}


/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 1
    while (k < sqrt(m.toDouble())) {
        k++
    }
    if (k <= sqrt(n.toDouble())) return (true) else return (false)
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var s = 0
    var n = x
    while (n != 1) {
        if (n % 2 == 0) n = (n / 2) else
            n = (3 * n + 1)
        s = (s + 1)
    }
    return (s)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var s = 1
    var st = 3
    var m = (x % (2 * PI))
    var sum = (m % (2 * PI))
    while (abs(m) >= abs(eps)) {
        s = (s + 2)
        m = (pow(x, s) / factorial(s))
        sum = (sum + pow(-1, (st)) * m)
        st = (st + 1)
    }
    return(sum)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var s = 2
    var m = 1.0
    var sum = m
    var st = 1
    while (abs(m) >= abs(eps)) {
        m = (pow((x % (2 * PI)), s) / factorial(s))
        sum = (sum + pow(-1, st) * m)
        st = (st + 1)
        s = (s + 2)
    }
    return(sum)
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var s = n
    var c = 0
    var rev = 0
    var st = 1
    while (s != 0) {
        c = (c + 1)
        s = (s % 10)
    }
    for (i in 1..c) {
        st = (st * 10)
    }
    s = n
    for (i in 1..c) {
        rev += ((s % 10) * st)
        st = (st / 10)
    }
    return (rev)
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean = TODO()


fun kc(x: Int): Int {
    var y = 0
    var z = x
    while (z != 0) {
        y = (y + 1)
        z = (z / 10)
    }
    return (y)
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var kv: Int
    var cifr = 0
    var i = 0
    var nc: Int
    while (cifr < n) {
        i = (i + 1)
        kv = sqr(i)
        cifr = (cifr + kc(kv))
    }
    kv = sqr(i)
    while (n < cifr) {
        kv = (kv / 10)
        cifr = (cifr - 1)
    }
    nc = (kv % 10)
    return (nc)
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var fb: Int
    var cifr = 0
    var i = 0
    var nc: Int
    while (cifr < n) {
        i = (i + 1)
        fb = fib(i)
        cifr = (cifr + kc(fb))
    }
    fb = fib(i)
    while (n < cifr) {
        fb = (fb / 10)
        cifr = (cifr - 1)
    }
    nc = (fb % 10)
    return (nc)
}
