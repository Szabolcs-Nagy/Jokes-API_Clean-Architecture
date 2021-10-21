package com.challenger.jokes_challenger_api_clean_archichecture.ui.home

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.challenger.domain.models.Joke
import com.challenger.jokes_challenger_api_clean_archichecture.R
import kotlinx.android.synthetic.main.jokes_item_adapter.view.*

class JokeItemAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Joke>() {

        override fun areItemsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Joke, newItem: Joke): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return JokeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.jokes_item_adapter,
                parent,
                false
            )

        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is JokeViewHolder -> {
                holder.bind(differ.currentList.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Joke>) {
        differ.submitList(list)
    }

    fun addItems(list: List<Joke>) {

        val newList = mutableListOf<Joke>()
        newList.addAll(differ.currentList)
        newList.addAll(list)
        differ.submitList(newList)
    }

    class JokeViewHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Joke) = with(itemView) {
              joke_textview.text = item.joke
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: Joke)
    }
}
