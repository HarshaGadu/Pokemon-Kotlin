package com.thotakura.pokemon.network.response

import com.google.gson.annotations.SerializedName
import com.thotakura.pokemon.model.Pokemon

class PokemonListResponse : BaseResponse() {

    @SerializedName("count")
    var count: Int? = null

    @SerializedName("results")
    var results: ArrayList<Pokemon>? = null

}