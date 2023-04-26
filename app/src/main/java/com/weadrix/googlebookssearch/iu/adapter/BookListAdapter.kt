package com.weadrix.googlebookssearch.iu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weadrix.googlebookssearch.R
import com.weadrix.googlebookssearch.databinding.ItemBookBinding
import com.weadrix.googlebookssearch.model.Volume

class BookListAdapter(
    var items: List<Volume>
) : RecyclerView.Adapter<BookListAdapter.BookHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        return BookHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val volume = items[position]
        holder.binding.txtTitle.text = volume.volumeInfo.title
        holder.binding.txtAuthor.text = volume.volumeInfo.authors?.joinToString() ?: ""
        holder.binding.txtPages.text = volume.volumeInfo.pageCount?.toString() ?: "-"
    }

    fun updateItems(newItems: List<Volume>) {
        items = newItems
        notifyDataSetChanged()
    }

    class BookHolder(val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root)
}