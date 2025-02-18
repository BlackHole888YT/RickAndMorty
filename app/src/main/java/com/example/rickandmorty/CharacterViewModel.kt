package com.example.rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.retrofit_model.CharacterModel

class CharacterViewModel: ViewModel() {
    private var characterData = MutableLiveData<CharacterModel>()
    val model: LiveData<CharacterModel> = characterData

    fun getData(modelGet: CharacterModel) {
        characterData.postValue(modelGet)
    }

}