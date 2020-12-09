package com.thilawfabrice.clean.usecases

import com.thilawfabrice.clean.domain.models.Item
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow

typealias GetAllItemsBaseUseCase = BaseUseCase<Unit, Flow<List<Item>>>

class GetAllItemsUseCase(
    private val itemRepository: IItemRepository
) : GetAllItemsBaseUseCase {

    override suspend fun invoke(params: Unit) = itemRepository.getAllItems()

}