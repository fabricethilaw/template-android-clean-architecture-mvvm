package com.thilawfabrice.clean.usecases

import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow

typealias GetItemByNameBaseUseCase = BaseUseCase<String, Flow<Item?>>

class GetItemByNameUseCase(
    private val planetsRepositoryI: IItemRepository
) : GetItemByNameBaseUseCase {

    override suspend fun invoke(params: String) = planetsRepositoryI.getItemByName(params)

}