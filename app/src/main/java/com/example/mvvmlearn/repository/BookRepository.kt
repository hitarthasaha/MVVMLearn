package com.example.mvvmlearn.repository

import com.example.mvvmlearn.api.API
import com.example.mvvmlearn.models.BookListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class BookRepository @Inject constructor(private val booksApi : API) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _books = MutableStateFlow<List<BookListItem>>(emptyList())
    val books: StateFlow<List<BookListItem>>
        get() = _books

    suspend fun getCategories() {
        val response = booksApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getBooks(category: String) {
        val response = booksApi.getBooks("books[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _books.emit(response.body()!!)
        }
    }
}
