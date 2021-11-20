package com.example.task1.authorization

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1.data.NetworkService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class AuthorizationViewModel(private val networkService: NetworkService) : ViewModel() {

}