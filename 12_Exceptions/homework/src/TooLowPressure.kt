class TooLowPressure : PressureException(
    message = "процедура удалась. Эксплуатация невозможна — давление превышает нормальное"
)