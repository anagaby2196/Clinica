package com.clinica.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.clinica.model.Servicio

@Dao
interface ServicioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addServicio(servicio: Servicio)

    @Update (onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateServicio(servicio: Servicio)

    @Delete
    suspend fun deleteServicio(servicio: Servicio)

    @Query ("SELECT * FROM SERVICIO")
    fun getAllData(): LiveData<List<Servicio>>


}