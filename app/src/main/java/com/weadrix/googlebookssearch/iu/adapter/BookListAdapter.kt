package com.weadrix.googlebookssearch.iu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.weadrix.googlebookssearch.R
import com.weadrix.googlebookssearch.model.Volume
import kotlinx.android.synthetic.main.item_book.view.imgCover
import kotlinx.android.synthetic.main.item_book.view.txtAuthor
import kotlinx.android.synthetic.main.item_book.view.txtPages
import kotlinx.android.synthetic.main.item_book.view.txtTitle

class BookListAdapter(
    val items: List<Volume>
) : RecyclerView.Adapter<BookListAdapter.BookHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent,false)
        return BookHolder(layout)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val volume = items(position)
        holder.txtTitle.text = volume.

    }

    class BookHolder(rootView : View): RecyclerView.ViewHolder(rootView){
        val imgCover : ImageView = rootView.imgCover
        val txtTitle : TextView = rootView.txtTitle
        val txtAuthor : TextView = rootView.txtAuthor
        val txtPages : TextView = rootView.txtPages
    }

}