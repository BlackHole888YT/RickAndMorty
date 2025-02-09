package com.example.rickandmorty.retrofit

import retrofit2.http.POST

interface ApiService {
    @POST
    fun getAllCharacters()
}