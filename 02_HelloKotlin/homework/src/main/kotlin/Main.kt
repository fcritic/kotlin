fun main() {

    val bloggerName = "Оксана" // имя блогера
    val dateVideoShown = "13.08.2023" // дата выхода ролика
    val payment = 35000 // оплата блогеру
    val percentageSales = 0.1 // процент от продаж

    val productName = "фитнес-браслет" // название товара

    val productBuyPrice = 700 // цена закупки товара
    val productSellPrice = 2400 // цена продажи товара

    val videoViews = 370000 // просмотры видео
    val linkClicked = 3250 // переходы по ссылке на покупку
    val salesAmount = 153 // количество покупок

    val totalIncome = salesAmount * productSellPrice // стоимость всех проданных товаров
    val totalBuyPrice = salesAmount * productBuyPrice // стоимость закупки товаров
    val salesProfit = totalIncome - totalBuyPrice // прибыль с продаж
    val amountSales = totalIncome * percentageSales // сумма от продаж блогеру
    val pureProfit = salesProfit - payment - amountSales// чистая прибыль


    val reportText = """
Отчёт о рекламной кампании
Блогер: $bloggerName
Ролик вышел $dateVideoShown
заплачено за ролик: $payment рублей
Процент от продаж блогеру: ${percentageSales * 100}%
Сумма от продаж блогеру: $amountSales


Рекламируемый товар: $productName
Закупочная цена: $productBuyPrice рублей
Цена продажи: $productSellPrice рублей

Количество просмотров рекламного ролика: $videoViews
Переходов по рекламной ссылке: $linkClicked
Покупок товара: $salesAmount
Общая стоимость проданного товара: $totalIncome рублей
Прибыль от продаж: $salesProfit рублей
Чистая прибыль: $pureProfit рублей
""".trimIndent()

    println(reportText)
}