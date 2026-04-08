package com.example.beyourcoach.domain.util

import java.text.NumberFormat
import java.util.*

fun Double.formatCurrency(): String {
    val locale = Locale.getDefault()
    val currencyFormat = NumberFormat.getCurrencyInstance(locale)

    // Manual override for requested logic if needed,
    // but system default usually handles this based on user locale.
    return currencyFormat.format(this)
}
