package com.example.task1.country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.NetworkService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class FlagsViewModel(private val networkService: NetworkService) : ViewModel() {
    init {
        getCountries()
    }

    private var _countries = MutableLiveData<Array<Country>>()
    val countries: LiveData<Array<Country>>
        get() = _countries

    private var _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private fun getCountries() {
        viewModelScope.launch {
            try {
                _countries.value = networkService.getCountries()
            } catch (ex: HttpException) {
                _showToast.value = "Ошибка сервера"
            }
        }
    }

}