package com.example.aksoftqrandcode

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.aksoftqrandcode.databinding.FragmentFillingBinding
import com.example.aksoftqrandcode.room.ScanData
import com.example.aksoftqrandcode.ui.ScanViewModel


class FillingFragment : Fragment() {

    private lateinit var binding: FragmentFillingBinding
    private lateinit var scanViewModel: ScanViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFillingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSave()
        getQrBr()
        onBack()

    }

    private fun onBack() {
        binding.restart.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun getQrBr() {
        val barcodeOrQrCode = arguments?.getString("key")
        when {
            barcodeOrQrCode != null -> {
                val editableText = Editable.Factory.getInstance().newEditable(barcodeOrQrCode)
                binding.barcode.text = editableText
            }
        }
    }

    private fun onSave() {

        scanViewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[ScanViewModel::class.java]

        binding.save.setOnClickListener {
            val scanData = ScanData(
                data = binding.barcode.text.toString(),
                name = binding.name.text.toString(),
                color = binding.color.text.toString(),
                size = binding.size.text.toString(),
                price = binding.price.text.toString(),
                artikul = binding.artikul.text.toString(),
                description = binding.description.text.toString()
            )
            scanViewModel.insertScanData(scanData)
        }
    }
}