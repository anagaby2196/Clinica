package com.clinica.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="servicio")

data class Servicio(
    @PrimaryKey(autoGenerate = true)
                    val id:Int,
                    @ColumnInfo(name="nombreServicio")
                    val nombreServicio:String,
                    @ColumnInfo(name="descripcion")
                    val descripcion:String,
                    @ColumnInfo(name="costo")
                    val costo:String,
                    @ColumnInfo(name="rutaImagen")
                    val rutaImagen:String?
) : Parcelable
