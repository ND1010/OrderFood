package com.dhruv.orderfood.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.dhruv.orderfood.R
import com.dhruv.orderfood.databinding.FragmentScreenSeverBinding
import com.dhruv.orderfood.utils.base.BaseFragment
import com.dhruv.orderfood.utils.base.Utils
import com.dhruv.orderfood.utils.ext.loge
import com.dhruv.orderfood.utils.ext.observe
import com.dhruv.orderfood.viewmodels.CategoryHomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScreenSeverFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var binding: FragmentScreenSeverBinding
    private val viewModel by viewModel<CategoryHomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_screen_sever, container, false
        )
        return binding.root
    }

    override fun onInit() {
        binding.constraintScreenSever.setOnClickListener {
            findNavController().navigate(R.id.action_screenSeverFragment_to_categoryHomeFragment)
        }

        val imagePath  = "${Utils.IMAGE_BASE}/uploads/screenSaver/25850343-d7fe-416d-b9d9-6b2cd033704f_shutterstock_1011899977.png"
        Glide.with(requireActivity())
            .load(imagePath) //.asBitmap()[for older glide versions]
            .placeholder(R.drawable.ic_placeholder)
            .override(1600, 2000) // Can be 2000, 2000
            .into(binding.mBigImage)

        //viewModel.getScreenImage()
        observe(viewModel.screenSaverMaster){
            loge("ImageDat->>>>>>>>> ${it.toString()}")
            if (!it.isNotEmpty()){
                val imagePath  = "${Utils.IMAGE_BASE}/uploads/screenSaver/25850343-d7fe-416d-b9d9-6b2cd033704f_shutterstock_1011899977.png"
                Glide.with(requireActivity())
                    .load(imagePath) //.asBitmap()[for older glide versions]
                    .placeholder(R.drawable.ic_placeholder)
                    .override(1600, 1600) // Can be 2000, 2000
                    .into(binding.mBigImage)

                    /*.into(object : BitmapImageViewTarget(binding.mBigImage) {
                        fun onResourceReady(drawable: Bitmap?, anim: GlideAnimation?) {
                            super.onResourceReady(drawable!!, anim)
                            progressBar.setVisibility(View.GONE)
                        }
                    })*/
            }
        }
    }

    companion object {
        val TAG = "ScreenSeverFragment"
    }
}