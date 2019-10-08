package com.thotakura.pokemon.ui.pokemonlist

import com.thotakura.pokemon.network.response.PokemonListResponse


interface PokemonListInteractor {
    interface PokemonListListener {

        fun onPokemonListFailed(e: Throwable, errorMessage: String)

        fun onPokemonListSuccess(response: PokemonListResponse)
    }

    fun getPokemonList(listener: PokemonListListener)
}
