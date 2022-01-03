package com.example.mobile_app_dev_project.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mobile_app_dev_project.R
import com.example.mobile_app_dev_project.databinding.FragmentDetailBinding
import com.example.mobile_app_dev_project.util.loadUrl

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var binding: FragmentDetailBinding
   private val args: DetailFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)


        with(binding) {
            titleTv.text = args.event.name
            eventIv.loadUrl(args.event.image)
            theMomentOfTruth.setOnClickListener {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Alert!")
                builder.setMessage("Board Games Are The Best!")
                builder.setIcon(R.drawable.ic_launcher_foreground)
            }
        }

    }

}