package br.com.heiderlopes.blocodenotas.api

import br.com.heiderlopes.blocodenotas.model.Nota
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NotaAPI {

    @GET("/nota")
    fun getNotas() : Call<List<Nota>>

    @POST("/nota")
    fun salvar(@Body nota: Nota): Call<Nota>

    /*@GET("/nota/{id}")
    fun getNotas(@Path("id") id:String)*/
}