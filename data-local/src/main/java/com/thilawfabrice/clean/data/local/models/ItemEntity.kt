package com.thilawfabrice.clean.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thilawfabrice.clean.domain.models.DataItemNames.COL_DESCRIPTION
import com.thilawfabrice.clean.domain.models.DataItemNames.COL_ID
import com.thilawfabrice.clean.domain.models.DataItemNames.COL_NAME
import com.thilawfabrice.clean.domain.models.DataItemNames.ITEM_TABLE_NAME

@Entity(tableName = ITEM_TABLE_NAME)
data class ItemEntity(
    @ColumnInfo(name = COL_ID)
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = COL_NAME)
    val name: String,
    @ColumnInfo(name = COL_DESCRIPTION) val description: String,
)