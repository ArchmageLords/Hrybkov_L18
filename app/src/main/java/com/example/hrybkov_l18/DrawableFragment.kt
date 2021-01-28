package com.example.hrybkov_l18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hrybkov_l18.databinding.DrawableFragmentBinding

class DrawableFragment: Fragment() {
    private lateinit var binding: DrawableFragmentBinding

    companion object {
        fun newInstance() = DrawableFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DrawableFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}