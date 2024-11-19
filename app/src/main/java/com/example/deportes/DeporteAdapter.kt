package com.example.deportes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DeporteAdapter(private val deporteList: List<Deporte>) : RecyclerView.Adapter<DeporteViewHolder>() {

    private val selectedSports = mutableListOf<Deporte>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeporteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DeporteViewHolder(layoutInflater.inflate(R.layout.deporte_item, parent, false))
    }

    override fun getItemCount(): Int = deporteList.size

    override fun onBindViewHolder(holder: DeporteViewHolder, position: Int) {
        val item = deporteList[position]
        holder.render(item)

        // Actualizar la selección al marcar/desmarcar el CheckBox
        holder.nombre.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (!selectedSports.contains(item)) selectedSports.add(item)
            } else {
                selectedSports.remove(item)
            }
        }
    }

    fun getSelectedSports(): List<Deporte> = selectedSports
}
