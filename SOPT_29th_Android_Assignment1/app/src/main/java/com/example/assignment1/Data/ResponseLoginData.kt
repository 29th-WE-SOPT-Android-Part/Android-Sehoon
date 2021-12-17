package com.example.assignment1.Data

data class ResponseLoginData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
) {
    data class Data (
        val id : Int,
        val name : String,
        val email : String
        )
}

data class ResponseSignUpData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : Data
) {
    data class Data (
        val id : Int,
        val name : String,
        val email : String
    )
}

