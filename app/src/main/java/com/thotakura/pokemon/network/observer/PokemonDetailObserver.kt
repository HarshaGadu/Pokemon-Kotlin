package com.thotakura.pokemon.network.observer

import android.text.TextUtils
import com.thotakura.pokemon.network.response.PokemonDetailResponse
import com.thotakura.pokemon.ui.pokemondetail.PokemonDetailInteractor


class PokemonDetailObserver(private var listener: PokemonDetailInteractor.PokemonDetailListener) :
    BaseObserver<PokemonDetailResponse>() {

    override fun onNext(response: PokemonDetailResponse) {
        listener.onPokemonDetailSuccess(response)
    }

    override fun onError(e: Throwable) {
        super.onError(e)
        if (!TextUtils.isEmpty(errorMessage)) {
            listener.onPokemonDetailFailed(e, errorMessage)
        }
    }

}