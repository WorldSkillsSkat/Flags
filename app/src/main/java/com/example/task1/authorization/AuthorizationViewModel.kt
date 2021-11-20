package com.example.task1.authorization

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.NetworkService
import com.example.task1.data.User
import kotlinx.coroutines.launch
import retrofit2.HttpException

class AuthorizationViewModel(private val networkService: NetworkService) : ViewModel() {
    private var _openFlagsFragment = MutableLiveData<Boolean>(false)
    val openFragsFragment: LiveData<Boolean>
        get() = _openFlagsFragment

    private var _isFailure = MutableLiveData<Boolean>(false)
    val isFailure: LiveData<Boolean>
        get() = _isFailure

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                networkService.signIn(User(email, password))
                _openFlagsFragment.value = true
            } catch (ex: HttpException) {
                _isFailure.value = true
            }
        }
    }
}