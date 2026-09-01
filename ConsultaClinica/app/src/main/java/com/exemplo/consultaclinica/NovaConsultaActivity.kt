package com.exemplo.consultaclinica

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemplo.consultaclinica.data.AppDatabase
import com.exemplo.consultaclinica.data.Consulta
import kotlinx.coroutines.launch
import java.util.Calendar

class NovaConsultaActivity : AppCompatActivity() {

    private lateinit var edtPaciente: EditText
    private lateinit var edtObservacao: EditText
    private lateinit var btnEscolherData: Button
    private lateinit var btnEscolherHora: Button
    private lateinit var btnSalvar: Button

    private var dataSelecionada = ""
    private var horaSelecionada = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nova_consulta)

        edtPaciente = findViewById(R.id.edtPaciente)
        edtObservacao = findViewById(R.id.edtObservacao)
        btnEscolherData = findViewById(R.id.btnEscolherData)
        btnEscolherHora = findViewById(R.id.btnEscolherHora)
        btnSalvar = findViewById(R.id.btnSalvar)

        btnEscolherData.setOnClickListener {
            escolherData()
        }

        btnEscolherHora.setOnClickListener {
            escolherHora()
        }

        btnSalvar.setOnClickListener {
            salvarConsulta()
        }
    }

    private fun escolherData() {

        val calendario = Calendar.getInstance()

        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            this,
            { _, anoSelecionado, mesSelecionado, diaSelecionado ->

                dataSelecionada = String.format(
                    "%02d/%02d/%04d",
                    diaSelecionado,
                    mesSelecionado + 1,
                    anoSelecionado
                )

                btnEscolherData.text = dataSelecionada
            },
            ano,
            mes,
            dia
        )

        datePicker.show()
    }

    private fun escolherHora() {

        val calendario = Calendar.getInstance()

        val hora = calendario.get(Calendar.HOUR_OF_DAY)
        val minuto = calendario.get(Calendar.MINUTE)

        val timePicker = TimePickerDialog(
            this,
            { _, horaSelecionadaPicker, minutoSelecionado ->

                horaSelecionada = String.format(
                    "%02d:%02d",
                    horaSelecionadaPicker,
                    minutoSelecionado
                )

                btnEscolherHora.text = horaSelecionada
            },
            hora,
            minuto,
            true
        )

        timePicker.show()
    }

    private fun salvarConsulta() {

        val paciente = edtPaciente.text.toString().trim()
        val observacao = edtObservacao.text.toString().trim()

        if (paciente.isEmpty()) {

            Toast.makeText(
                this,
                "Digite o nome do paciente",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (dataSelecionada.isEmpty()) {

            Toast.makeText(
                this,
                "Escolha uma data",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (horaSelecionada.isEmpty()) {

            Toast.makeText(
                this,
                "Escolha um horário",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        val consulta = Consulta(
            paciente = paciente,
            data = dataSelecionada,
            hora = horaSelecionada,
            observacao = observacao
        )

        val dao = AppDatabase
            .getInstance(this)
            .consultaDao()

        lifecycleScope.launch {

            dao.inserir(consulta)

            runOnUiThread {

                Toast.makeText(
                    this@NovaConsultaActivity,
                    "Consulta agendada com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                finish()
            }
        }
    }
}