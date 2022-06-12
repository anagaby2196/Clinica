package com.clinica.ui.servicio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clinica.R
import com.clinica.databinding.FragmentAddServicioBinding
import com.clinica.databinding.FragmentServicioBinding
import com.clinica.model.Servicio
import com.clinica.viewmodel.ServicioViewModel

class AddServicioFragment : Fragment() {

    private lateinit var servicioViewModel: ServicioViewModel
    private var _binding: FragmentAddServicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        servicioViewModel = ViewModelProvider(this)[ServicioViewModel::class.java]
        _binding = FragmentAddServicioBinding.inflate(inflater,container,false)

        binding.btAdd.setOnClickListener { addServicio() }

        return binding.root
    }

    private fun addServicio() {
        val nombreServicio=binding.etNombre.text.toString()
        val descripcion=binding.etDescripcion.text.toString()
        val costo=binding.etCosto.text.toString()

        if(nombreServicio.isNotEmpty()) {
            val servicio = Servicio(0,nombreServicio,descripcion,costo,"")
            servicioViewModel.addServicio(servicio)
            Toast.makeText(requireContext(),getString(R.string.servicioAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addServicioFragment_to_nav_clinica)
        } else {
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}