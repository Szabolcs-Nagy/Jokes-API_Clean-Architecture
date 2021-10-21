package com.challenger.data.models

import com.google.gson.annotations.SerializedName

data class ResponseJokesEntity(val type:String, val  value: List<JokeEntity>) {
}