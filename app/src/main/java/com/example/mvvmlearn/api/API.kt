package com.example.mvvmlearn.api

import com.example.mvvmlearn.models.BookListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface API  {
    @GET("/v3/b/66b0cc0ee41b4d34e41c0145?meta=false")
    suspend fun getBooks(@Header("X-JSON-Path") category: String) : Response<List<BookListItem>>;

    @GET("/v3/b/66b0cc0ee41b4d34e41c0145?meta=false")
    @Headers("X-JSON-Path: books..category")
    suspend fun getCategories() : Response<List<String>>;
}