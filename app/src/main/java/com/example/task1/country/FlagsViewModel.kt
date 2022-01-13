package com.example.task1.country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.NetworkService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class FlagsViewModel(private val networkService: NetworkService) : ViewModel() {

    private var _countries = MutableLiveData<Array<Country>>()
    val countries: LiveData<Array<Country>>
        get() = _countries

    private var _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private var _openDiagrammsFragment = MutableLiveData<Boolean>(false)
    val openDiagrammsFragment: LiveData<Boolean>
        get() = _openDiagrammsFragment

    fun getCountries() {
        viewModelScope.launch {
            try {
                _countries.value = networkService.getCountries()
            } catch (ex: HttpException) {
                _showToast.value = "Ошибка сервера"
            }
        }
    }

    fun openDiagrammsFragment() {
        _openDiagrammsFragment.value = true
    }

}