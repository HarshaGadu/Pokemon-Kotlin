package com.thotakura.pokemon.ui.pokemonlist

import com.thotakura.pokemon.network.response.PokemonListResponse
import com.thotakura.pokemon.ui.base.IView

interface PokemonListView : IView {
    fun setPokemonList(response: PokemonListResponse)
}
