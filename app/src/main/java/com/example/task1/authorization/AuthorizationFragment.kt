package com.example.task1.authorization

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.task1.R
import com.example.task1.databinding.FragmentAutorizationBinding
import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAutorizationBinding
    private val viewModel by viewModel<AuthorizationViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container)
        return binding.root
    }

    private fun initBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_autorization, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun setupObserverViewModel() {
        viewModel.openFragsFragment.observe(viewLifecycleOwner, Observer {

        })

        viewModel.isFailure.observe(viewLifecycleOwner, Observer {

        })
    }


}