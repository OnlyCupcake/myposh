
package com.mistersomov.coinjet.utils

import java.text.NumberFormat
import java.util.*

fun Double.asPercentage(): String = when {
    this < 0 -> String.format("%.2f", this).split("-")[1]
    this == 0.0 -> String.format("%.1f", this)
    else -> String.format("%.2f", this)
}

fun Double.formatCurrencyToDisplay(): String {
    val decimalFormat = NumberFormat.getInstance(Locale.US).also { it.maximumFractionDigits = 8 }
    return try {
        when {
            this == 1.0 -> String.format("%.1f", this)
            else -> decimalFormat.format(this)
        }
    } catch (e: Exception) {
        throw e
    }
}

fun Double.formatBigDecimalsToDisplay(): String {
    return try {
        when {
            this >= 1000000000.0 -> String.format("%.2fB", this / 1000000000)
            this >= 1000000.0 -> String.format("%.2fM", this / 1000000)
            this >=1000.0 -> String.format("%.2fK", this / 1000)
            else -> this.toString()
        }
    } catch (e: Exception) {
        throw e
    }
}