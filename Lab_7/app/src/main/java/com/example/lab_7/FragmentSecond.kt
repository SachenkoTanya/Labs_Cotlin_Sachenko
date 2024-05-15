package com.example.lab_7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.lab_7.FragmentSecondArgs
import com.example.lab_7.databinding.Fragment2Binding

class FragmentSecond : Fragment() {
    private lateinit var binding: Fragment2Binding
    private val args: FragmentSecondArgs by navArgs()

    private var name = ""
    private var surname = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = args.name
        surname = args.surname
        binding.textView.text = "$name $surname"
    }
}
