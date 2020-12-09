package com.thilawfabrice.clean.data.remote.api

import com.thilawfabrice.clean.data.remote.extensions.enforceHttps
import com.thilawfabrice.clean.data.remote.models.ItemListResponse
import com.thilawfabrice.clean.data.remote.models.ItemResponse
import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.models.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface RemoteApiService {

    @GET
    suspend fun getAllItems(@Url url: String = API_URL.enforceHttps()): ItemListResponse

    @GET("url")
    suspend fun getItemByName(param: String): ItemResponse

    @POST("url")
    suspend fun saveItem(@Body item: Item): Flow<Result>

    @POST("url/{name}")
    suspend fun removeItem(@Path("name") id: String): Result
}

