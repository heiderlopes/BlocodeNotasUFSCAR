package br.com.heiderlopes.blocodenotas.repository

import br.com.heiderlopes.blocodenotas.api.getNotaAPI
import br.com.heiderlopes.blocodenotas.model.Nota
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotaRepository {

    fun buscarTodos(
        onComplete:(List<Nota>?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {

        getNotaAPI()
            .getNotas()
            .enqueue(object : Callback<List<Nota>>{
                override fun onFailure(call: Call<List<Nota>>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<List<Nota>>, response: Response<List<Nota>>) {
                    if(response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Erro ao buscar os dados"))
                    }
                }
            })

    }



    fun salvar(nota: Nota,
                onComplete: (Nota) -> Unit,
                onError: (Throwable?) -> Unit) {
        getNotaAPI()
            .salvar(nota)
            .enqueue(object : Callback<Nota>{
                override fun onFailure(call: Call<Nota>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Nota>, response: Response<Nota>) {
                    onComplete(response.body()!!)
                }
            })
    }





}