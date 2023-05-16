package com.example.aksoftqrandcode.ui.notifications

import android.os.Bundle
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
            val scanTextList = scans.map { it.data }
            val scanText = scanTextList.joinToString("\n")
            binding.textNotifications.text = scanText
        }


    }
}