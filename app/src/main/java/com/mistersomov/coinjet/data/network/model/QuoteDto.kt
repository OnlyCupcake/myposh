package com.mistersomov.coinjet.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @SerializedName("FROMSYMBOL")
    @Expose
    val fromSymbol: String? = null,

    @SerializedName("TOSYMBOL")
    @Expose
    val toSymbol: String? = null,

    @SerializedName("PRICE")
    @Expose
    val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    val lastUpdate: Long? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    val volume24hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    val volume24hourto: Double? = null,

    @SerializedName("MKTC