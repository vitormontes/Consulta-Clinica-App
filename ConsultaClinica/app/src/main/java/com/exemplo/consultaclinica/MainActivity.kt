package com.exemplo.consultaclinica

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.lifecycleScope
import com.exemplo.consultaclinica.data.AppDatabase
import com.exemplo.consultaclinica.ui.ConsultaAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ConsultaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = AppDatabase.getInstance(this).consultaDao()

        val recycler = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerConsultas)
        adapter = ConsultaAdapter(emptyList()) { consulta ->
            lifecycleScope.launch { dao.deletar(consulta) }
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        lifecycleScope.launch {
            dao.listarTodas().collect { lista ->
                adapter.atualizarLista(lista)
            }
        }

        findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabAdicionar)
            .setOnClickListener {
                startActivity(Intent(this, NovaConsultaActivity::class.java))
            }
    }
}
