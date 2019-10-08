package com.thotakura.pokemon.ui.pokemonlist


import com.thotakura.pokemon.network.core.NetworkService
import com.thotakura.pokemon.network.observer.PokemonListObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonListInteractorImpl : PokemonListInteractor {
    override fun getPokemonList(listener: PokemonListInteractor.PokemonListListener) {
        NetworkService.service()!!.getPokemonList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(PokemonListObserver(listener))
    }

}
