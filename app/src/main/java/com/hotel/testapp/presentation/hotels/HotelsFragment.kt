package com.hotel.testapp.presentation.hotels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.hotel.testapp.R
import com.hotel.testapp.databinding.FragmentHotelsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HotelsFragment : Fragment() {
    private var _binding: FragmentHotelsBinding? = null
    private val viewModel: HotelsViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            viewLifecycleOwner.lifecycle.coroutineScope.launch {
                viewModel.state.collect { state ->
                    when (state.screenState) {
                        ScreenState.IDLE -> {

                        }

                        ScreenState.Loading -> {

                        }

                        ScreenState.Content -> {
                            if (!state.isEmpty) {
                                hotelName.text = state.content.first().name
                            } else {
                                Toast.makeText(context, "DATA IS EMPTY", Toast.LENGTH_SHORT).show()
                            }
                        }

                        ScreenState.Error -> {

                        }
                    }
                }
            }

            submitHotel.setOnClickListener {
                findNavController().navigate(R.id.action_hotelsFragment_to_roomsFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}