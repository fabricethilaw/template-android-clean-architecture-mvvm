package com.thilawfabrice.clean.data.local.dao

import androidx.room.*
import com.thilawfabrice.clean.data.local.mappers.toEntity
import com.thilawfabrice.clean.data.local.models.ItemEntity
import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.models.Result

@Dao
interface ItemDao {

    // DELETE operations return the number of rows that have been deleted

    @Query("DELETE FROM items")
    suspend fun deleteAll(): Int

    @Query("DELETE FROM items WHERE name=:name")
    suspend fun deleteByName(name: String): Int

    @Transaction
    @Query("SELECT * FROM items WHERE name=:name")
    suspend fun getByName(name: String): Item

    @Transaction
    @Query("SELECT * FROM items")
    suspend fun getAll(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemEntity: ItemEntity): Long

    @Transaction
    suspend fun insert(item: Item): Result {
        return try {
            insert(item.toEntity())
            Result.SUCCESS
        } catch (e: Exception) {
            Result.FAILURE
        }
    }
}