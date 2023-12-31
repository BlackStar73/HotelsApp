package com.hotel.testapp.presentation.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hotel.testapp.R
import com.hotel.testapp.databinding.FragmentRoomsBinding

class RoomsFragment : Fragment() {
    private var _binding: FragmentRoomsBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            toHotel.setOnClickListener {
                findNavController().navigate(R.id.action_roomsFragment_to_hotelsFragment)
            }
            roomReservation.setOnClickListener {
                findNavController().navigate(R.id.action_roomsFragment_to_bookingFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}