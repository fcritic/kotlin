fun main()
{
    val firstName: String = "Vladislav"
    val lastName: String = "Bochkarev"
    var height: Double = 1.5
    val weight: Float = 70F

    height = 1.8
    val isChild: Boolean = height <= 1.5 || weight <= 40

    val info: String = """
        Информация о человеке
        Имя и Фамилия: $firstName $lastName
        Рост: $height
        Вес: $weight
        Является ли ребенком: ${if (isChild) "да" else "нет"}
        """.trimIndent()

    println(info)
}