package com.mistersomov.coinjet.data.repository

import com.mistersomov.coinjet.data.datasource.LocalDataSource
import com.mistersomov.coinjet.data.datasource.RemoteDataSource
import com.mistersomov.coinjet.data.toCoin
import com.mistersomov.coinjet.data.toCoinEntity
import com.mistersomov.coinjet.data.toSearchCoinEntity
import com.mistersomov.coinjet.di.qualifier.DefaultDispatcher
import com.mistersomov.coinjet.domain.m