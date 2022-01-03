package com.example.mobile_app_dev_project.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.mobile_app_dev_project.R
import com.example.mobile_app_dev_project.data.model.Event
import com.example.mobile_app_dev_project.databinding.FragmentEventListBinding
import androidx.lifecycle.Observer


class EventListFragment : Fragment(R.layout.fragment_event_list) {
    private lateinit var binding: FragmentEventListBinding
    private val viewModel: EventListViewModel by viewModels()
    private val eventAdapter = EventAdapter {
        navigateToDetail(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEventListBinding.bind(view)

        binding.eventRecyclerView.adapter = eventAdapter

        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.eventRecyclerView)

        viewModel.eventData.observe(viewLifecycleOwner, Observer {
            eventAdapter.updateData(it)
        })

        viewModel.getData()
    }

    private fun navigateToDetail(event: Event) {
        val direction = EventListFragmentDirections.actionGlobalDetailFragment(event)
        findNavController().navigate(direction)
    }
}