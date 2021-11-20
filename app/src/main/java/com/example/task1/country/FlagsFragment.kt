package com.example.task1.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.task1.R
import com.example.task1.authorization.login.LoginViewModel
import com.example.task1.databinding.CountriesFragmentBinding
import com.example.task1.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FlagsFragment : Fragment() {

    private val viewModel: FlagsViewModel by viewModel()
    private lateinit var binding: CountriesFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container)
        return inflater.inflate(R.layout.countries_fragment, container, false)
    }

    private fun initBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
    }


}