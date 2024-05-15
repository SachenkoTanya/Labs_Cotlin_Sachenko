package com.example.lab_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab_7.databinding.Fragment1Binding
import com.example.lab_7.databinding.FragmentNewBinding

class NewFragment : Fragment() {

    private lateinit var binding: FragmentNewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}