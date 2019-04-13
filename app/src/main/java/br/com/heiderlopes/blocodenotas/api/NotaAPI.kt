package br.com.heiderlopes.blocodenotas.api

import br.com.heiderlopes.blocodenotas.model.Nota
import retrofit2.Call
import retrofit2.http.GET

interface NotaAPI {

    @GET("/nota")
    fun getNotas() : Call<List<Nota>>

    /*@GET("/nota/{id}")
    fun getNotas(@Path("id") id:String)*/
}