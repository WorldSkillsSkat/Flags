package com.example.task1.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
        setupObserverViewModel()

        viewModel.getCountries()

        return binding.root
    }

    private fun initBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, R.layout.countries_fragment, container, false)
        binding.viewModel = viewModel
    }

    private fun setupObserverViewModel() {
        viewModel.countries.observe(viewLifecycleOwner, {
            configureRecyclerView(it)
        })

        viewModel.showToast.observe(viewLifecycleOwner, {
            showToast(it)
        })

        viewModel.openDiagrammsFragment.observe(viewLifecycleOwner, {
            if (it) findNavController().navigate(R.id.action_flagsFragment_to_diagramFragment)
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private fun configureRecyclerView(countries: Array<Country>) {
        val adapter = CountriesRecyclerViewAdapter(countries)
        binding.countriesRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.countriesRecyclerView.adapter = adapter
    }

}