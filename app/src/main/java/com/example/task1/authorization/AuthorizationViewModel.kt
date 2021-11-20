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
    private var _openFlagsFragment = MutableLiveData<Boolean>()
    val openFragsFragment: LiveData<Boolean>
        get() = _openFlagsFragment

    private var _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private val emailPattern = Regex("\\w+@[a-z\\d]+[.][a-z]{1,3}")

    fun signIn(email: String, password: String) {
        if (emailPattern.matches(email)) {
            viewModelScope.launch {
                try {
                    networkService.signIn(User(email, password))
                    _openFlagsFragment.value = true
                } catch (ex: HttpException) {
                    _showToast.value = "Пароль или почта не верны. Попробуйте еще раз"
                }
            }
        } else {
            _showToast.value = "Ваша почта не валидна. Попробуйте еще раз"
        }
    }
}