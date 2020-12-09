package com.thilawfabrice.clean.data.local.mappers

import com.thilawfabrice.clean.data.local.models.ItemEntity
import com.thilawfabrice.clean.domain.models.Item

internal fun Item.toEntity(): ItemEntity {
    return ItemEntity(name = name, description = description)
}