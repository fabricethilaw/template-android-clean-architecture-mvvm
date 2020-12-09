package com.thilawfabrice.clean.domain.repository

import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface IItemRepository {

    suspend fun getAllItems(): Flow<List<Item>>

    suspend fun getItemByName(name: String): Flow<Item?>

    suspend fun deleteItemByName(name: String): Flow<Result>

    suspend fun deleteAllItems(): Flow<Result>

    suspend fun insertItem(item: Item): Flow<Result>
}