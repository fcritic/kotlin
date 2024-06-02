//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main()
{
    val priceList = mutableMapOf(
        "Milk" to 80,
        "Cheese" to 50,
        "Apples" to 150,
        "Bananas" to 70,
        "Coca-cola" to 180,
        "Yogurt" to 50
    )

    val sortedMap = priceList.toSortedMap(compareBy<String> { priceList[it] }.thenBy { it })
    println(sortedMap)
}


