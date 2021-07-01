package com.mistersomov.coinjet.data.database

import androidx.room.*
import com.mistersomov.coinjet.data.database.dao.CoinDao
import com.mistersomov.coinjet.data.database.dao.SearchCoinDao
import com.mistersomov.coinjet.data.database.entity.CoinEntity
import com.mistersomov.coinjet.data.database.entity.SearchCoinEntity

@Database(
    entities = [CoinEntity::class, SearchCoinEntity::class],
    version = 1,
)
abstract class CoinjetDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

    abstract fun searchDao(): SearchCoinDao
}