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
import ru.vsu.educational_weather_app.features.weather.view.MainWeatherVM

class SettingsFragment : Fragment() {
    val vm: SettingsVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.setting__toolbar)
        toolbar.setupWithNavController(findNavController())

        return view
    }
}