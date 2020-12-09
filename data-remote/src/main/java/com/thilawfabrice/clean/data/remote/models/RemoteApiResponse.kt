package com.thilawfabrice.clean.data.remote.models

import com.squareup.moshi.Json

data class ItemResponse(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "description") val description: String
)

data class ItemListResponse(@field:Json(name = "data") val data: List<ItemResponse>)