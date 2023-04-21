package com.weadrix.googlebookssearch.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object BookHttp {
    private const val API_KEY = "AIzaSyCMbkkCMh_pBJQiWOcLeEda_Dxl2BRwtGo"
    private const val BOOK_JSON_URL = "HTTPS://www.googleapis.com/books/v1/volumes?q=%s&key=$API_KEY"

    private val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun searchBook(book: String): SearchResult? {
        val request = Request.Builder()
            .url(String.format(BOOK_JSON_URL, book))
            .build()

        try {
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            return Gson().fromJson(json,SearchResult::class.java)

        } catch (e : Exception){
            e.printStackTrace()

        }
        return null
    }
}