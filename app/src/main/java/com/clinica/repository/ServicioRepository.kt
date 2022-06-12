package com.clinica.repository

import androidx.lifecycle.LiveData
import com.clinica.data.ServicioDao
import com.clinica.model.Servicio

class ServicioRepository(private val servicioDao: ServicioDao) {

    val getAllData: LiveData<List<Servicio>> = servicioDao.getAllData()

    suspend fun addServicio(servicio: Servicio) {
        servicioDao.addServicio(servicio)
    }

    suspend fun updateServicio(servicio: Servicio) {
        servicioDao.updateServicio(servicio)
    }

    suspend fun deleteServicio(servicio: Servicio) {
        servicioDao.deleteServicio(servicio)
    }
}