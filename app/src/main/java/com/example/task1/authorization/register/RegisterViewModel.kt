package com.example.task1.authorization.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.NetworkService
import com.example.task1.data.User
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RegisterViewModel(private val networkService: NetworkService) : ViewModel() {
    private var _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private var _openFlagsFragment = MutableLiveData<Boolean>(false)
    val openFragsFragment: LiveData<Boolean>
        get() = _openFlagsFragment

    private val emailPattern = Regex("\\w+@[a-z\\d]+[.][a-z]{1,3}")

    fun register(firstName: String, lastName: String, email: String, password: String) {

        if (email != "" && password != "" && firstName != "" && lastName != "") {
            if (emailPattern.matches(email)) {
                addUser(firstName, lastName, email, password)
            } else {
                _showToast.value = "Ваша почта не валидна. Попробуйте еще раз"
            }
        } else {
            _showToast.value = "Не все поля заполнены"
        }
    }

    fun addUser(firstName: String, lastName: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                networkService.addUser(User(firstName, lastName, email, password))
                _openFlagsFragment.value = true
            } catch (ex: HttpException) {
                _showToast.value = "Ошибка на сервере. Попробуйте еще раз"
            }
        }

        }


}