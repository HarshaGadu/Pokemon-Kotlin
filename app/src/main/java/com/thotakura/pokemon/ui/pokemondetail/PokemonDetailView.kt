package com.thotakura.pokemon.ui.pokemondetail

import com.thotakura.pokemon.network.response.PokemonDetailResponse
import com.thotakura.pokemon.ui.base.IView


interface PokemonDetailView : IView {
    fun setPokemonDetail(response: PokemonDetailResponse)
}