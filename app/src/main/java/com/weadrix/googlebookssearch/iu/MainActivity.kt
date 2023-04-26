package com.weadrix.googlebookssearch.iu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.weadrix.googlebookssearch.R
import com.weadrix.googlebookssearch.databinding.ActivityMainBinding
import com.weadrix.googlebookssearch.iu.adapter.BookListAdapter
import com.weadrix.googlebookssearch.model.BookHttp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: BookListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val recyclerViewBook = binding.recyclerView
        recyclerViewBook.layoutManager = LinearLayoutManager(this)
        recyclerViewBook.setHasFixedSize(true)

        adapter = BookListAdapter(emptyList())
        recyclerViewBook.adapter = adapter

        lifecycleScope.launch {
            val result = withContext(Dispatchers.IO){
                BookHttp.searchBook("Dominando o Android")
            }
            result?.items?.let {
                adapter.updateItems(it)
            }
        }
    }
}