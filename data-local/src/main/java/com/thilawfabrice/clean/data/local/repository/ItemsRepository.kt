package com.thilawfabrice.clean.data.local.repository

import com.thilawfabrice.clean.data.local.dao.ItemDao
import com.thilawfabrice.clean.data.local.mappers.toEntity
import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.models.Result
import com.thilawfabrice.clean.domain.models.Result.FAILURE
import com.thilawfabrice.clean.domain.models.Result.SUCCESS
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemsRepository(private val itemDao: ItemDao) : IItemRepository {

    override suspend fun getAllItems(): Flow<List<Item>> = flow {
        val result = itemDao.getAll()
        emit(result)
    }

    override suspend fun getItemByName(name: String): Flow<Item?> = flow {
        val result = itemDao.getByName(name)
        emit(result)
    }

    override suspend fun deleteItemByName(name: String): Flow<Result> = flow {
        val deleteCount: Int = itemDao.deleteByName(name)
        val result = if (deleteCount == 1) SUCCESS else FAILURE
        emit(result)
    }

    override suspend fun deleteAllItems(): Flow<Result> = flow {
        val deleteCount = itemDao.deleteAll()
        val result = if (deleteCount > 0) SUCCESS else FAILURE
        emit(result)
    }

    override suspend fun insertItem(item: Item): Flow<Result> = flow {
        val rawResult = itemDao.insert(item.toEntity())
        val result = if (rawResult > -1) SUCCESS else FAILURE
        emit(result)
    }

}