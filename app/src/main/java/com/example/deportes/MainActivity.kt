package com.example.deportes

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: DeporteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar la Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Iniciar el RecyclerView
        initRecyclerView()

        // Configurar el FAB
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            val selectedSports = adapter.getSelectedSports()
            if (selectedSports.isNotEmpty()) {
                val sportsNames = selectedSports.joinToString(", ") { it.nombre }
                Toast.makeText(this, "Has elegido: $sportsNames", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No has elegido ninguna opción", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método para inicializar el RecyclerView
    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = DeporteAdapter(DeporteProvider.listaDeporte)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(decoration)
    }

    // Método para crear el menú de opciones
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    // Método para manejar las acciones de los elementos del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            (R.id.action_settings) -> {return true}
            (R.id.action_add) -> {return true}
            (R.id.action_buscar) -> {return true}
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
