package com.example.mobile_app_dev_project.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_app_dev_project.R
import com.example.mobile_app_dev_project.data.model.Event
import com.example.mobile_app_dev_project.databinding.EventItemBinding
import com.example.mobile_app_dev_project.util.loadUrl

class EventAdapter(private val onTap: (event: Event) -> Unit): RecyclerView.Adapter<EventAdapter.EventItem>() {

    private var data: List<Event> = listOf()

    class EventItem(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = EventItemBinding.bind(itemView)

        fun configure(event: Event) {
            binding.titleTv.text = event.name
            // binding.idTv.text = photo.id.toString()
            binding.urlIv.loadUrl(event.image)
        }
    }

    fun updateData(eventData: List<Event>) {
        data = eventData
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventItem {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.event_item, parent, false)
        return EventItem(itemView)
    }

    override fun onBindViewHolder(holder: EventItem, position: Int) {
        val event = data[position]
        holder.configure(event)
        holder.itemView.setOnClickListener {
            onTap(event)
        }
    }
}
