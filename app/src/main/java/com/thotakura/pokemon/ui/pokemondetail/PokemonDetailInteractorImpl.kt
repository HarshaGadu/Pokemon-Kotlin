package com.thotakura.pokemon.ui.pokemondetail


import com.thotakura.pokemon.network.core.NetworkService
import com.thotakura.pokemon.network.observer.PokemonDetailObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonDetailInteractorImpl : PokemonDetailInteractor {
    override fun getPokemonDetail(name: String?, listener: PokemonDetailInteractor.PokemonDetailListener) {
        NetworkService.service()!!.getPokemonDetail(name)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PokemonDetailObserver(listener))
    }

}