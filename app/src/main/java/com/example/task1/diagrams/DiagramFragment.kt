package com.example.task1.diagrams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task1.R
import com.example.task1.country.CountriesRecyclerViewAdapter
import com.example.task1.country.Country
import com.example.task1.databinding.DiagramFragmentBinding
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.ArrayList

class DiagramFragment : Fragment() {

    private val viewModel: DiagramViewModel by viewModel()
    private lateinit var binding: DiagramFragmentBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.diagram_fragment, container, false)
        binding.viewModel = viewModel
    }

    private fun setupObserverViewModel() {
        viewModel.countries.observe(viewLifecycleOwner, {
            initChat(it.toMutableList(), 1)
        })

        viewModel.showToast.observe(viewLifecycleOwner, {
            showToast(it)
        })

        viewModel.changeRadioGroup.observe(viewLifecycleOwner, {
            initChat(viewModel.countries.value!!.toMutableList(), it)
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initChat(countries: MutableList<Country>, mode: Int) {
        val currentCountries = viewModel.getFiveCountriesByCurrentMode(countries, mode)
        val labels = mutableListOf<String>()
        val entries = ArrayList<BarEntry>()

        for (i in 0 until currentCountries.size) {
            labels.add(currentCountries[i].name.name)
            entries.add(BarEntry(i.toFloat(), currentCountries[i].population.toFloat()))
        }
        val barSetEnties = BarDataSet(entries, "Countries population")

        val barData = BarData(barSetEnties)
        binding.chart.data = barData
        binding.chart.invalidate()

    }



}