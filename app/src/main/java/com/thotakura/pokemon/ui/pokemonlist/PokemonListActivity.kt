package com.thotakura.pokemon.ui.pokemonlist

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.thotakura.pokemon.R

import com.thotakura.pokemon.adapter.PokemonListAdapter
import com.thotakura.pokemon.model.Pokemon
import com.thotakura.pokemon.network.response.PokemonDetailResponse
import com.thotakura.pokemon.network.response.PokemonListResponse
import com.thotakura.pokemon.ui.base.BaseActivity
import com.thotakura.pokemon.ui.pokemondetail.*
import kotlinx.android.synthetic.main.activity_pokemon_list.*

const val KEY_NAME = "name"

class PokemonListActivity : BaseActivity(), PokemonListView, PokemonListAdapter.PokemonListener {


    private var presenter: PokemonListPresenter? = null
    private var pokemonPresenterDetails: PokemonDetailPresenter? = null
    private var pokemonListAdapter: PokemonListAdapter? = null
    private var dataList: ArrayList<Pokemon>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        presenter = PokemonListPresenterImpl(this, PokemonListInteractorImpl())
        pokemonPresenterDetails = PokemonDetailPresenterImpActivity(this, PokemonDetailInteractorImpl())


        init()
    }

    private fun init() {
        presenter?.getPokemonList()

    }

    override fun setPokemonList(response: PokemonListResponse) {
        setPokemonListAdapter(rvPokemon, response)
    }

    private fun setPokemonListAdapter(recyclerView: RecyclerView?, response: PokemonListResponse) {
        recyclerView?.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        dataList = response.results!!
        for (i in 0..(this.dataList?.size)!!.minus(1)){
            val intval:Int =  i + 1
            var str:String = intval.toString()
            val link = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+str+".png"
            dataList!![i].imageUrl = link

        }
        pokemonListAdapter = PokemonListAdapter(dataList!!, this, this)
        rvPokemon?.adapter = pokemonListAdapter

    }

    override fun showErrorMessage(errorMessage: String) {

    }

    override fun onPokemonClickedListener(pokemon: Pokemon) {
        val intent = Intent(this, PokemonDetailActivity::class.java)
        intent.putExtra(KEY_NAME, pokemon.name)
        startActivity(intent)
    }

    fun setPokemonDetail(response: PokemonDetailResponse) {
       /*test@for (i in 0..(this.dataList?.size)!!.minus(1)){
           if(i == 19){
               pokemonListAdapter = PokemonListAdapter(dataList!!, this, this)
               rvPokemon?.adapter = pokemonListAdapter
           }else if(this.dataList!![i].imageUrl.isNullOrBlank()){
                this.dataList!![i].imageUrl = response.sprites?.frontImage;
                break@test
            }

        }*/

    }

    fun getImageUrl(recyclerView: RecyclerView?){
        for (item: Pokemon in this.dataList!!) {
            pokemonPresenterDetails?.getPokemonDetail(item.name)
        }


    }


}
