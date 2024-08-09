package com.example.mvvmlearn.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmlearn.models.BookListItem
import com.example.mvvmlearn.viewmodels.DetailViewModel

@Composable
fun DetailScreen(){
    val detailViewModel: DetailViewModel = hiltViewModel()
    val books = detailViewModel.books.collectAsState()
    Log.d("BOSTI1", books.value.size.toString())
    LazyColumn(content =  {
        items(books.value){
            BookListItem(text = it.text)
        }
    })
}

@Composable
fun BookListItem(text: String){
    Box(modifier = Modifier
        .padding(4.dp)
        .size(160.dp)
        .clip(RoundedCornerShape(8.dp))
        .border(1.dp, Color(0xFFEEEEEE)),
        contentAlignment = Alignment.Center
    ){
        Text(text = text,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp, 20.dp),
            style = MaterialTheme.typography.bodySmall)
    }
}