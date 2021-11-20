package com.example.task1.authorization.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.task1.R
import com.example.task1.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModel<LoginViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container)
        setupObserverViewModel()
        return binding.root
    }

    private fun initBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.viewModel = viewModel
        binding.email = ""
        binding.password = ""
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun setupObserverViewModel() {
        viewModel.openFragsFragment.observe(viewLifecycleOwner, {
            if (it) findNavController().navigate(R.id.action_loginFragment_to_flagsFragment)
        })

        viewModel.openRegisterFragment.observe(viewLifecycleOwner, {
            if (it) findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        })

        viewModel.showToast.observe(viewLifecycleOwner, {
            showToast(it)
        })

    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}