package com.example.rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickandmorty.paging3.CharacterPagingSource
import com.example.rickandmorty.retrofit.ApiService
import com.example.rickandmorty.retrofit.retrofit_model.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val apiService: ApiService
): ViewModel() {
    fun getCharacters():LiveData<PagingData<Results>>{
         val pager = Pager(
            config = PagingConfig(
                20,
                5,
                false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(apiService)
            }
        )
        return pager.liveData
    }
}