package com.thotakura.pokemon

import android.app.Application

class PokemonApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PokemonApplication().apply {
                return this
            }
    }
}