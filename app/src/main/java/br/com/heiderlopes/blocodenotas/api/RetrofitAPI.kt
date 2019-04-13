package br.com.heiderlopes.blocodenotas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAPI<T> {

    fun getClient(c: Class<T>) : T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://blocodenotasmeunome.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(c)
    }
}

fun getNotaAPI(): NotaAPI {
    return RetrofitAPI<NotaAPI>().getClient(NotaAPI::class.java)
}