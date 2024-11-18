package ru.vsu.educational_weather_app.features.settings.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vsu.educational_weather_app.R
import ru.vsu.educational_weather_app.databinding.FragmentMainWeatherBinding
import ru.vsu.educational_weather_app.databinding.FragmentSettingsBinding
import ru.vsu.educational_weather_app.features.weather.view.MainWeatherVM

class SettingsFragment : Fragment() {
    val vm: SettingsVM by viewModel()

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        val view = binding.root

        val toolbar = binding.settingToolbar
        toolbar.setupWithNavController(findNavController())

        return view
    }
}