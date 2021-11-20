package com.example.task1.authorization.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.task1.R
import com.example.task1.databinding.RegisterFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterFragment : Fragment() {


    private val viewModel: RegisterViewModel by viewModel<RegisterViewModel>()
    private lateinit var binding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container)
        setupObserverViewModel()
        return binding.root
    }

    private fun initBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.register_fragment, container, false)
        binding.email = ""
        binding.password = ""
        binding.firstName = ""
        binding.lastName = ""
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun setupObserverViewModel() {
        viewModel.openFragsFragment.observe(viewLifecycleOwner, {
            if (it) findNavController().navigate(R.id.action_registerFragment_to_flagsFragment)
        })

        viewModel.showToast.observe(viewLifecycleOwner, {
            showToast(it)
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}