package com.thilawfabrice.clean.usecases

import com.thilawfabrice.clean.domain.models.Result
import com.thilawfabrice.clean.domain.repository.IItemRepository
import kotlinx.coroutines.flow.Flow

typealias DeleteAllItemsBaseUseCase = BaseUseCase<Unit, Flow<Result>>

class DeleteAllItemsUseCase(
    private val IItemRepository: IItemRepository
) : DeleteAllItemsBaseUseCase {

    override suspend fun invoke(params: Unit) = IItemRepository.deleteAllItems()

}