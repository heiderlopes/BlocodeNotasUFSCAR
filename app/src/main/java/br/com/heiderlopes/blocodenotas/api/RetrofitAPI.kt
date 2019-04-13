package br.com.heiderlopes.blocodenotas.api

import retrofit2.Retrofit

class RetrofitAPI<T> {

    fun getClient(c: Class<T>) : T {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://blocodenotasmeunome.herokuapp.com/")
            .build()

        return retrofit.create(c)
    }
}

fun getNotaAPI(): NotaAPI {
    return RetrofitAPI<NotaAPI>().getClient(NotaAPI::class.java)
}