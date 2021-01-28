package com.example.hrybkov_l18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.hrybkov_l18.databinding.GlideFragmentBinding

class GlideFragment : Fragment() {
    private lateinit var binding: GlideFragmentBinding

    companion object {
        fun newInstance() = GlideFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GlideFragmentBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnLoadImageGlide.setOnClickListener {
            binding.ivGlide.loadImageGlide(getString(R.string.panamera))
        }
    }

    private fun AppCompatImageView.loadImageGlide(pathToImage: String) {
        Glide.with(context)
            .load(pathToImage)
            .error(R.drawable.ic_launcher_background)
            .transition(DrawableTransitionOptions.withCrossFade())
            .circleCrop()
            .into(this)
    }
}