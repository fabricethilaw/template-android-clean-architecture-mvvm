package com.thilawfabrice.clean.usecases

import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.models.Result
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow

typealias InsertItemBaseUseCase = BaseUseCase<Item, Flow<Result>>

class InsertItemUseCase(
    private val planetsRepositoryI: IItemRepository
) : InsertItemBaseUseCase {

    override suspend fun invoke(params: Item) = planetsRepositoryI.insertItem(params)

}