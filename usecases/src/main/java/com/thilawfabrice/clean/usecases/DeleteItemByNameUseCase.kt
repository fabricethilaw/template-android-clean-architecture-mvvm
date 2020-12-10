package com.thilawfabrice.clean.usecases

import com.thilawfabrice.clean.domain.models.Result
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow


typealias DeleteItemByNameBaseUseCase = BaseUseCase<String, Flow<Result>>

class DeleteItemByNameUseCase(
    private val itemRepository: IItemRepository
) : DeleteItemByNameBaseUseCase {

    override suspend fun invoke(params: String) = itemRepository.deleteItemByName(params)

}