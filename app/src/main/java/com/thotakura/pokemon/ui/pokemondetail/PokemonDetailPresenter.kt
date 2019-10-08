package com.thotakura.pokemon.ui.pokemondetail

import com.thotakura.pokemon.ui.base.IPresenter


interface PokemonDetailPresenter : IPresenter {
    fun getPokemonDetail(name: String?)
}