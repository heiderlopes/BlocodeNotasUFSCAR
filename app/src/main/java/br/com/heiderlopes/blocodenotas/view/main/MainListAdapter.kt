package br.com.heiderlopes.blocodenotas.view.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import br.com.heiderlopes.blocodenotas.model.Nota

class MainListAdapter(
    val notas: List<Nota>
) :
    RecyclerView.Adapter<MainListAdapter.NotaViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotaViewHolder {
        return NotaViewHolder()
    }

    override fun getItemCount(): Int {
        return notas.size
    }

    override fun onBindViewHolder(p0: NotaViewHolder, p1: Int) {

    }


    class NotaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }


}