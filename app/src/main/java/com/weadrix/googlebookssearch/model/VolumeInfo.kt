package com.weadrix.googlebookssearch.model

data class VolumeInfo(
    val title: String,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishedDate: String?,
    val pageCount: Int?,
    val imageLinks: ImageLinks?
)
