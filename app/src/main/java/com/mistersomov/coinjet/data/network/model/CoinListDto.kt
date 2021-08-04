package com.mistersomov.coinjet.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinListDto(
    @SerializedName("Data")
    @Expose
    val coins: List<Coi