package ru.vsu.educational_weather_app.features.weather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vsu.educational_weather_app.R

class MainWeatherFragment : Fragment() {
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
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_weather, container, false)

        // а что ты биндинги не стал юзать?
        cityTextView = view.findViewById(R.id.fragment_main_weather__title_city)
        temperatureTextView = view.findViewById(R.id.fragment_main_weather__row_temperature)
        conditionTextView = view.findViewById(R.id.fragment_main_weather__row_text_weather)
        weatherImage = view.findViewById(R.id.fragment_main_weather__row_image)
        menuButton = view.findViewById(R.id.fragment_main_weather__header_menu)
        dateTextView = view.findViewById(R.id.fragment_main_weather__title_date)

        menuButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainWeatherFragment_to_settingsFragment)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // в продолжение  флоу/лайв-дата - если тут будет вторая, будет более карсиво
                // сейчас смотрится страшновато)
                launch {
                    vm.cityState.collect {
                        cityTextView.text = it
                    }
                }

                launch {
                    vm.weatherState.collect {
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
                }

                launch {
                    vm.updateWeather()
                }
            }
        }
        return view
    }
}