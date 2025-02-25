package com.example.rickandmorty.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase: RoomDatabase() {
    abstract fun dao(): CharacterDao
}