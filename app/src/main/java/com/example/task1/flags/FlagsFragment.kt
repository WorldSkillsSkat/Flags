package com.example.task1.flags

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task1.R
import org.koin.android.viewmodel.ext.android.viewModel

class FlagsFragment : Fragment() {

    private val viewModel: FlagsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.flags_fragment, container, false)
    }


}