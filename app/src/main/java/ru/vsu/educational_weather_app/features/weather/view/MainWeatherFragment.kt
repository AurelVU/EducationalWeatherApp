package ru.vsu.educational_weather_app.features.weather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vsu.educational_weather_app.R
import ru.vsu.educational_weather_app.databinding.FragmentMainWeatherBinding

class MainWeatherFragment : Fragment() {
    private lateinit var binding: FragmentMainWeatherBinding

    private val vm: MainWeatherVM by viewModel()

    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var conditionTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var weatherImage: ImageView
    private lateinit var menuButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainWeatherBinding.inflate(inflater, container, false)
        val view = binding.root

        cityTextView = binding.fragmentMainWeatherTitleCity
        temperatureTextView = binding.fragmentMainWeatherRowTemperature
        conditionTextView = binding.fragmentMainWeatherRowTextWeather
        weatherImage = binding.fragmentMainWeatherRowImage
        menuButton = binding.fragmentMainWeatherHeaderMenu
        dateTextView = binding.fragmentMainWeatherTitleDate

        menuButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainWeatherFragment_to_settingsFragment)
        }

        vm.cityState.observe(viewLifecycleOwner) {
            cityTextView.text = it
        }

        vm.weatherState.observe(viewLifecycleOwner) {
            temperatureTextView.text = it?.current?.tempC?.toInt().toString()
            conditionTextView.text = it?.current?.condition?.text?.replace(' ', '\n')
            dateTextView.text = it?.current?.lastUpdated

            when (it?.current?.condition?.code) {
                1000 -> {
                    weatherImage.setImageResource(R.drawable.sunny)
                }
                1001 -> {
                    weatherImage.setImageResource(R.drawable.cloud)
                }
                1002 -> {
                    weatherImage.setImageResource(R.drawable.cloud_with_sun)
                }
                1003 -> {
                    weatherImage.setImageResource(R.drawable.cloud_with_sun_and_rain)
                }
            }
        }

        vm.updateWeather()
        return view
    }
}