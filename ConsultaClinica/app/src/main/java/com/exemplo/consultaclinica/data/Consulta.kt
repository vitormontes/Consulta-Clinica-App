package com.exemplo.consultaclinica.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "consultas")
data class Consulta(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val paciente: String,
    val data: String,
    val hora: String,
    val observacao: String = ""
)
