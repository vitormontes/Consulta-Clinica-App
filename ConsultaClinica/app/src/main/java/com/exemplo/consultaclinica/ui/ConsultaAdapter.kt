package com.exemplo.consultaclinica.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exemplo.consultaclinica.R
import com.exemplo.consultaclinica.data.Consulta

class ConsultaAdapter(
    private var lista: List<Consulta>,
    private val onClickRemover: (Consulta) -> Unit
) : RecyclerView.Adapter<ConsultaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val paciente: TextView = view.findViewById(R.id.txtPaciente)
        val dataHora: TextView = view.findViewById(R.id.txtDataHora)
        val btnRemover: ImageButton = view.findViewById(R.id.btnRemover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_consulta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val consulta = lista[position]
        holder.paciente.text = consulta.paciente
        holder.dataHora.text = "${consulta.data} às ${consulta.hora}"
        holder.btnRemover.setOnClickListener { onClickRemover(consulta) }
    }

    override fun getItemCount() = lista.size

    fun atualizarLista(novaLista: List<Consulta>) {
        lista = novaLista
        notifyDataSetChanged()
    }
}
