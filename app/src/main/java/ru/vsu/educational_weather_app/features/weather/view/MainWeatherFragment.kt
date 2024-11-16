package ru.vsu.educational_weather_app.features.weather.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.vsu.educational_weather_app.R

class MainWeatherFragment : Fragment() {
    private val vm: MainWeatherVM by viewModel()

    private lateinit var cityTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var conditionTextView: TextView
    private lateinit var weatherImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_weather, container, false)

        cityTextView = view.findViewById(R.id.fragment_main_weather__title_city)
        temperatureTextView = view.findViewById(R.id.fragment_main_weather__row_temperature)
        conditionTextView = view.findViewById(R.id.fragment_main_weather__row_text_weather)
        weatherImage = view.findViewById(R.id.fragment_main_weather__row_image)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    vm.cityState.collect {
                        cityTextView.text = it
                    }
                }

                launch {
                    vm.weatherState.collect {
                        temperatureTextView.text = it?.current?.tempC?.toInt().toString()
                        conditionTextView.text = it?.current?.condition?.text

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