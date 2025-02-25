package com.example.rickandmorty.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters_room")
data class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id")
    val id: Int = 0,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("gender")
    val gender: String,

    @ColumnInfo("status")
    val status: String,

    @ColumnInfo("species")
    val species: String,

    @ColumnInfo("image")
    val image: String,

    @ColumnInfo("type")
    val type: String,


)