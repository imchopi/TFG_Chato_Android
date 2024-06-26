package com.example.parking.data.db.users

data class User(
    val uuid: String,
    val username: String,
    val name: String,
    val picture: String,
    val surname: String,
    val email: String,
    val password: String,
    val role: String,
)
