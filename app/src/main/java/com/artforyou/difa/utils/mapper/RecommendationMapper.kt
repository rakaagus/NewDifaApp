package com.artforyou.difa.utils.mapper

import com.artforyou.difa.data.local.entity.RecommendationEntity
import com.artforyou.difa.data.remote.response.base.RecommendationItemData
import com.artforyou.difa.domain.model.RecommendationModel

object RecommendationMapper {
    fun recommendationResponseToEntitiesMapper(input: List<RecommendationItemData>): List<RecommendationEntity> {
        val recommendationList = ArrayList<RecommendationEntity>()
        input.map {
            val recommendation = RecommendationEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                urlImage = it.urlImage,
                link = it.link,
                createAt = it.createdAt
            )
            recommendationList.add(recommendation)
        }
        return recommendationList
    }

    fun recommendationEntitiesToModelMapper(input: List<RecommendationEntity>): List<RecommendationModel> =
        input.map {
            RecommendationModel(
                id = it.id,
                title = it.title,
                description = it.description,
                urlImage = it.urlImage,
                link = it.link,
                createAt = it.createAt
            )
        }

    fun recommendationModelToEntitiesMapper(input: RecommendationModel) = RecommendationEntity(
        id = input.id,
        title = input.title,
        description = input.description,
        urlImage = input.urlImage,
        link = input.link,
        createAt = input.createAt
    )
}