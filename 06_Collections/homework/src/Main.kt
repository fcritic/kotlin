//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    phoneDirectory()
}

fun phoneDirectory()
{
    val phoneBook = mutableMapOf<String, String?>()
    val phoneBookList: MutableList<String> = mutableListOf()
    var uniquePhoneNumbersLust: MutableList<String> = mutableListOf()

    try {
        while (true) {
            println("Какое кол-во контактов вы хотите добавить: ")
            val numberContacts = readLine()?.toIntOrNull()

            if (numberContacts === null || numberContacts <= 0) {
                println("Ошибка, вы ввели не корректное значение")
                continue
            } else {
                for (i in 1..numberContacts) {
                    val numberPhone = enteringCorrectNumber(i)

                    if (numberPhone != null) {
                        phoneBookList.add(numberPhone)
                    }
                    uniquePhoneNumbersLust = phoneBookList.toSet().toMutableList()
                }
            }
            break
        }
        uniquePhoneNumbersLust.forEach {
            println("Введите имя контакта телефона $it: ")
            var givenName = readLine()
            if (givenName == "") givenName = "Имя не задано"
            phoneBook.put(it, givenName)
        }

        val filterPhoneBook = phoneBook.filter { it.key.substring(0, 2) == "+7" }
        val phoneBookMap = filterPhoneBook.toSortedMap(compareBy<String>{ filterPhoneBook[it] }.thenBy { it })

        phoneBookMap.forEach { (key, value) ->
            println("Абонент: $value. Номер телефона: $key")
        }
        println("Сумму длин всех номеров телефонов: ${lengthAllNumbers(uniquePhoneNumbersLust)}")

    } catch (e: Exception) {
        println("Возникла не предвиденная ошибка")
        println(e.message)

    } finally {
        println("Скрипт завершен")
    }
}

fun lengthAllNumbers(uniquePhoneNumbersLust: MutableList<String>): Int
{
    val totalLength = uniquePhoneNumbersLust.sumOf { it.length }
    return totalLength
}

fun enteringCorrectNumber(i: Int): String?
{
    while (true) {
        println("Введите номер телефона #$i: ")
        val numberPhone = readLine()

        if (numberPhone == "") {
            println("Номер не может быть пустой")
            continue
        }
        return numberPhone
    }
}