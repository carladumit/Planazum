package com.example.planazum.util

import kotlinx.datetime.Month

fun Month.toSpanishName(): String = when (this) {
    Month.JANUARY -> "Enero"
    Month.FEBRUARY -> "Febrero"
    Month.MARCH -> "Marzo"
    Month.APRIL -> "Abril"
    Month.MAY -> "Mayo"
    Month.JUNE -> "Junio"
    Month.JULY -> "Julio"
    Month.AUGUST -> "Agosto"
    Month.SEPTEMBER -> "Septiembre"
    Month.OCTOBER -> "Octubre"
    Month.NOVEMBER -> "Noviembre"
    Month.DECEMBER -> "Diciembre"
}
