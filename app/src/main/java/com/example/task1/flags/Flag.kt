package com.example.task1.flags

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Flag (
    @SerializedName("name")
    @Expose
    val name: Name = Name(),

    @SerializedName("population")
    @Expose
    val population: Int = 0,

    @SerializedName("flags")
    @Expose
    val flags: MyImage

)

class Demonyms (
    @SerializedName("flags")
    @Expose
    val flags: MyImage
)

data class MyImage(
    @SerializedName("png")
    @Expose
    val png: String,
    @SerializedName("svg")
    @Expose
    val svg: String
)
data class Name(
    @SerializedName("common")
    @Expose
    val name: String = ""
)