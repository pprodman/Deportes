package com.example.deportes

import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class DeporteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imagen = view.findViewById<ImageView>(R.id.imageView)
    val nombre = view.findViewById<CheckBox>(R.id.checkbox)

    fun render(deporte: Deporte) {
        nombre.text = deporte.nombre
        imagen.setImageResource(deporte.imagen)
        // Asegúrate de que el CheckBox refleja el estado correcto
        nombre.isChecked = false
    }
}

