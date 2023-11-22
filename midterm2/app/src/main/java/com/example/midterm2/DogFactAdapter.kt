package com.example.midterm2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView Adapter for displaying Dog Facts.
 * @property dogFacts List of Dog Facts to be displayed in the RecyclerView.
 */
class DogFactAdapter(private var dogFacts: List<String>) :
    RecyclerView.Adapter<DogFactAdapter.ViewHolder>() {

    /**
     * Creates a ViewHolder by inflating the item layout.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dog_fact, parent, false)
        return ViewHolder(view)
    }

    /**
     * Binds data to the ViewHolder at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogFacts[position])
    }

    /**
     * Returns the total number of items in the data set.
     */
    override fun getItemCount(): Int {
        return dogFacts.size
    }

    /**
     * Updates the data set and notifies the adapter of the change.
     * @param dogFacts New list of Dog Facts to be displayed.
     */
    fun setData(dogFacts: List<String>) {
        this.dogFacts = dogFacts
        notifyDataSetChanged()
    }

    /**
     * ViewHolder for holding the views of each item in the RecyclerView.
     * @property textViewDogFact TextView for displaying the Dog Fact.
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDogFact: TextView = itemView.findViewById(R.id.textDogFact)

        /**
         * Binds the Dog Fact to the TextView.
         * @param dogFact Dog Fact to be displayed.
         */
        fun bind(dogFact: String) {
            textViewDogFact.text = dogFact
        }
    }
}
