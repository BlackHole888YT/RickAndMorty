package com.example.rickandmorty.paging3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.retrofit.ApiService
import com.example.rickandmorty.retrofit_model.Results

const val START_INDEX = 1

class CharacterPagingSource (
    private val apiService: ApiService
): PagingSource<Int, Results>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        return try {
            val currentPage = params.key?: START_INDEX
            val response = apiService.getAllCharacters(page = currentPage)

            LoadResult.Page(
                data = response.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if(response.info.next.isNullOrEmpty()) null else currentPage + 1
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val closestPage = state.closestPageToPosition(anchorPosition)
            closestPage?.prevKey?.plus(1)?: closestPage?.nextKey?.minus(1)
        }
    }
}