package com.mistersomov.coinjet.utils

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import java.sql.Timestamp

fun Long?.convertTime(): String {
    return when {
        this == null -> ""
        else -> {
            val pattern = "HH:mm:ss"
            val timestamp = Timestamp(this * 1000)

            r