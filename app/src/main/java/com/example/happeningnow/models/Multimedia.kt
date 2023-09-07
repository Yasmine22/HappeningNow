package com.example.happeningnow.models

import com.google.gson.annotations.SerializedName




data class Multimedia (
	@SerializedName("url") val url : String,
	@SerializedName("format") val format : String,
	@SerializedName("height") val height : Int,
	@SerializedName("width") val width : Int,
	@SerializedName("type") val type : String,
	@SerializedName("subtype") val subtype : String,
	@SerializedName("caption") val caption : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("approved_for_syndication") val approved_for_syndication : Int,
	@SerializedName("media-metadata") val mediaMetadata : List<MediaMetadata>
)