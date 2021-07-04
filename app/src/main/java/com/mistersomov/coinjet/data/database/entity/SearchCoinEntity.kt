package com.mistersomov.coinjet.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SearchCoinEntity.TABLE_SEARCH_COIN_NAME)
data class SearchCoinEntity(
    @PrimaryKey
    val id: String,
    val symbol: String,
    val fullName: String,
  