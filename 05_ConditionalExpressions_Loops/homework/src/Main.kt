//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    calculationFibonacci()
}

fun calculationFibonacci()
{
    var result: Long = 0
    var numberOne: Long = 0
    var numberTwo: Long = 1

    while (result.toInt() == 0) {
        println("Введите число больше 0: ")
        val n = readLine()?.toIntOrNull()

        if (n == null || n <= 0) {
            println("Ошибка")
            continue
        } else if (n == 1) {
            result = 1

        } else {
            for (i in 2..n) {
                result = numberOne + numberTwo
                numberOne = numberTwo
                numberTwo = result
            }
        }
        if (result < 0) {
            println("Ошибка на стороне сервера")
            return
        }
        println("Число Фибоначчи для $n: $result")
    }
}
