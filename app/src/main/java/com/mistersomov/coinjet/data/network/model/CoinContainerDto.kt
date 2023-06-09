
package com.mistersomov.coinjet.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinContainerDto(
    @SerializedName("CoinInfo")
    @Expose
    val coin: CoinDto? = null,
)