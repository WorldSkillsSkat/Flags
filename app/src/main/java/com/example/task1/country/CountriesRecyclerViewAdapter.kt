package com.example.task1.country

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.databinding.CountriesItemBinding

class CountriesRecyclerViewAdapter(private val countries: Array<Country>) :
    RecyclerView.Adapter<CountriesRecyclerViewAdapter.ViewHolder>() {



    class ViewHolder(private val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(country: Country) {
            binding.country = country
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CountriesItemBinding.inflate(layoutInflater, parent, false)
                return (ViewHolder(binding))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size
    }

}