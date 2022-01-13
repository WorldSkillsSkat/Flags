package com.example.task1.diagrams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.country.Country
import com.example.task1.data.NetworkService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.random.Random

class DiagramViewModel(private val networkService: NetworkService) : ViewModel() {
    private var _countries = MutableLiveData<Array<Country>>()
    val countries: LiveData<Array<Country>>
        get() = _countries

    private var _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private var _changeRadioGroup = MutableLiveData<Int>()
    val changeRadioGroup: LiveData<Int>
        get() = _changeRadioGroup

    private var _back = MutableLiveData<Boolean>()
    val back: LiveData<Boolean>
        get() = _back

    fun getCountries() {
        viewModelScope.launch {
            try {
                _countries.value = networkService.getCountries()
            } catch (ex: HttpException) {
                _showToast.value = "Ошибка сервера"
            }
        }
    }

    fun changeRadioGroup(mode: Int, bol: Boolean) {
        if (bol) { _changeRadioGroup.value = mode }
    }

    fun back() {
        _back.value = true
    }

    fun getFiveCountriesByCurrentMode(countries: MutableList<Country>, mode: Int): MutableList<Country> {
        return if (mode == 1) {
            getFiveBestCountriesByPopulation(countries)
        } else {
            getRandomFiveCountries(countries)
        }
    }

    private fun getRandomFiveCountries(countries: MutableList<Country>): MutableList<Country> {
        val tempList = mutableListOf<Country>()
        for (i in 0..4) {
            tempList.add(countries[Random.nextInt(0, countries.size)])
        }
        return tempList
    }

    private fun getFiveBestCountriesByPopulation(countries: MutableList<Country>): MutableList<Country> {
        sortListByPopulation(countries)
        return countries.subList(0, 5)
    }

    private fun sortListByPopulation(countries: MutableList<Country>) {
        for (i in 1 until (countries.size / 2)) {
            for (i in 1 until (countries.size)) {
                if (countries[i].population > countries[i - 1].population) {
                    val temp = countries[i]
                    countries[i] = countries[i - 1]
                    countries[i - 1] = temp
                }
            }
        }
    }
}