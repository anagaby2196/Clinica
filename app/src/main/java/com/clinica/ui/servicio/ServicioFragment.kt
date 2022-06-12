package com.clinica.ui.servicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clinica.R
import com.clinica.adapter.ServicioAdapter
import com.clinica.databinding.FragmentAddServicioBinding
import com.clinica.databinding.FragmentServicioBinding
import com.clinica.viewmodel.ServicioViewModel

class ServicioFragment : Fragment() {

    private lateinit var servicioViewModel: ServicioViewModel
    private var _binding: FragmentServicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        servicioViewModel = ViewModelProvider(this)[ServicioViewModel::class.java]
        _binding = FragmentServicioBinding.inflate(inflater,container,false)


        binding.addServicioButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_clinica_to_addServicioFragment)
        }

        //Activar el reciclador - RecyclerView
        val servicioAdapter = ServicioAdapter()
        val reciclador = binding.reciclador

        reciclador.adapter = servicioAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        servicioViewModel = ViewModelProvider(this)[ServicioViewModel::class.java]

        servicioViewModel.getAllData.observe(viewLifecycleOwner) {
                servicios -> servicioAdapter.setData(servicios)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}