package com.thilawfabrice.clean.data.remote.repository

import com.thilawfabrice.clean.data.remote.api.RemoteApiService
import com.thilawfabrice.clean.data.remote.mappers.toDomain
import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.models.Result
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemRepository(
    private val apiService: RemoteApiService
) : IItemRepository {


    override suspend fun getAllItems(): Flow<List<Item>> = flow {
        val response = apiService.getAllItems()
        emit(response.toDomain())
    }

    override suspend fun getItemByName(name: String): Flow<Item?> = flow {
        val response = apiService.getItemByName(name)
        emit(response.toDomain())
    }

    override suspend fun deleteItemByName(name: String): Flow<Result> = flow {
        val response = apiService.removeItem(name)
        emit(response)
    }

    override suspend fun deleteAllItems(): Flow<Result> {
        TODO("Not yet implemented")
    }

    override suspend fun insertItem(item: Item): Flow<Result> {
        TODO("Not yet implemented")
    }
}