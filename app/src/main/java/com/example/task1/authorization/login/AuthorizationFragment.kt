package com.example.task1.authorization.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.task1.R
import com.example.task1.databinding.FragmentAutorizationBinding
import org.koin.android.viewmodel.ext.android.viewModel

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAutorizationBinding
    private val viewModel by viewModel<AuthorizationViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initBinding(inflater, container)
        setupObserverViewModel()
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

        viewModel.showToast.observe(viewLifecycleOwner, Observer {
            showToast(it)
        })

    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}