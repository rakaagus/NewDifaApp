package com.artforyou.difa.utils.mapper

import com.artforyou.difa.data.local.entity.QuotesEntity
import com.artforyou.difa.data.remote.response.base.QuotesItemData
import com.artforyou.difa.domain.model.QuoteModel

object QuoteMapper {
    fun quoteResponseToEntitiesMapper(input: List<QuotesItemData>): List<QuotesEntity>{
        val quotesList = ArrayList<QuotesEntity>()
        input.map {
            val quote = QuotesEntity(
                id = it.id,
                text = it.text,
                source = it.source,
                createAt = it.createdAt
            )
            quotesList.add(quote)
        }
        return quotesList
    }

    fun quoteEntitiesToModelMapper(input: List<QuotesEntity>): List<QuoteModel> =
        input.map {
            QuoteModel(
                id = it.id,
                text = it.text,
                source = it.source,
                createAt = it.createAt
            )
        }

    fun quoteModelToEntitiesMapper(input: QuoteModel) = QuotesEntity(
        id = input.id,
        text = input.text,
        source = input.source,
        createAt = input.createAt
    )
}