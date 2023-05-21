package com.example.aksoftqrandcode.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aksoftqrandcode.databinding.FragmentNotificationsBinding
import com.example.aksoftqrandcode.ui.ScanViewModel

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var scanViewModel: ScanViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scanViewModel = ViewModelProvider(requireActivity())[ScanViewModel::class.java]

        scanViewModel.allScans.observe(viewLifecycleOwner) { scans ->
            // Обработка полученного списка сканирований
            binding.dataTextView.text = scans.map { it.data }.toString()
            binding.nameTextView.text = scans.map { it.name }.toString()
            binding.colorTextView.text = scans.map { it.color }.toString()
            binding.sizeTextView.text = scans.map { it.size }.toString()
            binding.priceTextView.text = scans.map { it.price }.toString()
            binding.descriptionTextView.text = scans.map { it.description }.toString()
            binding.artikulTextView.text = scans.map { it.artikul }.toString()
        }
    }
}