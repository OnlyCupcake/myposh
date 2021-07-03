package com.mistersomov.coinjet.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CoinEntity.TABLE_COIN_NAME)
data class CoinEntity(
    @PrimaryKey
    val id: String,
    val symbol: String,
    val fullName: String,
    val fromSymbol: String,
    val toSymbol: String,
    val price: Double,
    val lastUpdate: String,
    val volume24Hour: Double,
    val volume24hourTo: Double,
    val open24Hour: Double,
    val high24Hour: Double,
    val low24Hour