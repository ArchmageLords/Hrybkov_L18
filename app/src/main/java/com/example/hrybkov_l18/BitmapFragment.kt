package com.example.hrybkov_l18

import android.graphics.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import com.example.hrybkov_l18.databinding.BitmapFragmentBinding
import java.io.ByteArrayOutputStream

class BitmapFragment : Fragment() {
    private lateinit var binding: BitmapFragmentBinding

    companion object {
        fun newInstance() = BitmapFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BitmapFragmentBinding.inflate(inflater, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnBitmap.setOnClickListener {
            val bitmap = binding.ivBitmap.drawToBitmap()
            drawLineOnBitmap(Canvas(bitmap))
            setImageFromByteArray(bitmapToByteArray(bitmap))
        }
    }

    private fun drawLineOnBitmap(canvas: Canvas) {
        canvas.apply {
            val paint = Paint()
            paint.color = Color.BLUE
            paint.strokeWidth = 20f
            drawLine(
                0f,
                0f,
                binding.ivBitmap.width.toFloat() / 2,
                binding.ivBitmap.height.toFloat() / 2,
                paint
            )
        }
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val byteArray = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray)
        return byteArray.toByteArray()
    }

    private fun setImageFromByteArray(byteArray: ByteArray) {
        binding.ivBitmap.setImageBitmap(BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size))
    }
}