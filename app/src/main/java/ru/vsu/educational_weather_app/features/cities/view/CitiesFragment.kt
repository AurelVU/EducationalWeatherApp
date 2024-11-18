package ru.vsu.educational_weather_app.features.cities.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vsu.educational_weather_app.databinding.FragmentCitiesBinding

class CitiesFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentCitiesBinding

    private val vm: CitiesVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}