package com.mistersomov.coinjet.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SearchCoinEntity.TABLE_SEARCH_COIN_NAME)
data class SearchCoinEntity(
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
    val low24Hour: Double,
    val changePct24Hour: Double,
    val changePctHour: Double,
    val mktCap: Double,
    val imageUrl: String,
) {

    companion object {
        const val TABLE_SEARCH_COIN_NAME = "search_coin_entity"
    }
}