
package com.mistersomov.coinjet.data.database.dao

import androidx.room.*
import com.mistersomov.coinjet.data.database.entity.CoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(coinList: List<CoinEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertByEntity(entity: CoinEntity)

    @Query("SELECT * from ${CoinEntity.TABLE_COIN_NAME} ORDER BY mktCap DESC")
    suspend fun getAll(): List<CoinEntity>

    @Query("SELECT * from ${CoinEntity.TABLE_COIN_NAME} WHERE symbol == :symbol LIMIT 1")
    fun getBySymbol(symbol: String): Flow<CoinEntity>

    @Query("DELETE from ${CoinEntity.TABLE_COIN_NAME}")
    suspend fun deleteAll()
}