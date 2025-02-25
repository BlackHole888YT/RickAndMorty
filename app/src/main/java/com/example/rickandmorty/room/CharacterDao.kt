package com.example.rickandmorty.room

import androidx.room.Dao
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("""
    SELECT * FROM characters_room 
    ORDER BY 
        LENGTH(name) ASC, 
        CASE 
            WHEN LENGTH(name) % 2 = 0 THEN name 
            ELSE NULL 
        END ASC, 
        CASE 
            WHEN LENGTH(name) % 2 = 1 THEN name 
            ELSE NULL 
        END DESC
""")
    fun getCharactersSorted(): List<CharacterEntity>
    // сортировка по длине символов в имени по возрастанию,
    // но если кол-во символов в имени чётное,
    // будет сортировка в A-Z, если нет, то Z-A
    // прикольная голубая подсветка (или зелёная)
}