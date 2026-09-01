package com.exemplo.consultaclinica.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ConsultaDao {
    @Insert
    suspend fun inserir(consulta: Consulta)

    @Delete
    suspend fun deletar(consulta: Consulta)

    @Query("SELECT * FROM consultas ORDER BY data, hora")
    fun listarTodas(): Flow<List<Consulta>>
}
