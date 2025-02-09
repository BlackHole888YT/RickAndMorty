package com.example.rickandmorty

data class Results(
    val id: Int = 0,
    val name: String = "???",
    val status: String = "???",
    val species: String = "???",
    val type: String = "???",
    val gender: String = "???",
    val origin: Location = Location("???"),
    val location: Location = Location("???"),
    val image: String = "",
    val episode: List<String>,
    val created: String = "???"
)

data class Info(
    val count: Int = 0,
    val pages: Int = 0,
    val next: String = "???",
    val prev: Boolean? = null
)

data class Location(
    val name: String = "???",
    val url: String = "???"
)
