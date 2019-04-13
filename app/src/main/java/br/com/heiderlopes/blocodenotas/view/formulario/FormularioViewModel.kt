package br.com.heiderlopes.blocodenotas.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.heiderlopes.blocodenotas.model.Nota
import br.com.heiderlopes.blocodenotas.model.ResponseStatus
import br.com.heiderlopes.blocodenotas.repository.NotaRepository

class FormularioViewModel : ViewModel() {

    val notaRepository = NotaRepository()
    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun salvar(
        titulo: String,
        descricao: String
    ) {
        isLoading.value = true
        val nota = Nota(titulo = titulo, descricao = descricao)
        notaRepository.salvar(nota,
            onComplete = {
                isLoading.value = false
                responseStatus.value = ResponseStatus(
                    true,
                    "Dado gravado com sucesso"
                )
            }, onError = {
                isLoading.value = false
                responseStatus.value = ResponseStatus(
                    false,
                    it?.message!!
                )
            })

    }

}