package br.com.heiderlopes.blocodenotas.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.heiderlopes.blocodenotas.R
import br.com.heiderlopes.blocodenotas.model.Nota
import kotlinx.android.synthetic.main.nota_item.view.*

class MainListAdapter(
    val context: Context,
    val notas: List<Nota>,
    val clickLista: (Nota) -> Unit
) :
    RecyclerView.Adapter<MainListAdapter.NotaViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotaViewHolder {

        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.nota_item, p0, false)

        return NotaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notas.size
    }

    override fun onBindViewHolder(p0: NotaViewHolder, position: Int) {
        val nota = notas[position]
        p0.bindView(nota, clickLista)
    }


    class NotaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(
            nota: Nota,
            clickLista: (Nota) -> Unit
        ) = with(itemView) {
            tvTitulo.text = nota.titulo
            tvDescricao.text = nota.descricao

            setOnClickListener { clickLista(nota) }
        }

    }
}