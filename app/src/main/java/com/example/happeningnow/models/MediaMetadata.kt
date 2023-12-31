package com.example.happeningnow.models

import com.google.gson.annotations.SerializedName


data class MediaMetadata (

	@SerializedName("url") val url : String,
	@SerializedName("format") val format : String,
	@SerializedName("height") val height : Int,
	@SerializedName("width") val width : Int
)