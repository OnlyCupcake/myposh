
package com.mistersomov.coinjet.domain.model

data class Coin(
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
)