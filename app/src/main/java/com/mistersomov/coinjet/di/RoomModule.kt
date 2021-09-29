
package com.mistersomov.coinjet.di

import android.content.Context
import androidx.room.Room
import com.mistersomov.coinjet.data.database.CoinjetDatabase
import com.mistersomov.coinjet.data.database.dao.CoinDao
import com.mistersomov.coinjet.data.database.dao.SearchCoinDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DB_NAME = "coinjet_database"

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): CoinjetDatabase =
        Room.databaseBuilder(
            context,
            CoinjetDatabase::class.java,
            DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideCoinDao(database: CoinjetDatabase): CoinDao = database.coinDao()

    @Singleton
    @Provides
    fun provideSearchDao(database: CoinjetDatabase): SearchCoinDao = database.searchDao()
}