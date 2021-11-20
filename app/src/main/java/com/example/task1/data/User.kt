package com.example.task1.data

data class User (
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
) {
    constructor(email: String, password: String): this ("", "", email, password)
}