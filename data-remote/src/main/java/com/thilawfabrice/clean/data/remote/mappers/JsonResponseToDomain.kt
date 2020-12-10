package com.thilawfabrice.clean.data.remote.mappers

import com.thilawfabrice.clean.data.remote.models.ItemListResponse
import com.thilawfabrice.clean.data.remote.models.ItemResponse
import com.thilawfabrice.clean.domain.models.Item

internal fun ItemResponse.toDomain(): Item {
    return Item(description = this.description, name = this.name)
}

internal fun ItemListResponse.toDomain(): List<Item> =
    data.map { rawItem -> Item(name = rawItem.name, description = rawItem.description) }
