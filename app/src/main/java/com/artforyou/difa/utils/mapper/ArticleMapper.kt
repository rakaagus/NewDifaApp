package com.artforyou.difa.utils.mapper

import com.artforyou.difa.data.local.entity.ArticleEntity
import com.artforyou.difa.data.remote.response.base.ArticleItemData
import com.artforyou.difa.domain.model.ArticleModel

object ArticleMapper {
    fun articleResponseToEntitiesMapper(input: List<ArticleItemData>) : List<ArticleEntity> {
        val articleList = ArrayList<ArticleEntity>()
        input.map {
            val article = ArticleEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                content = it.content,
                author = it.author,
                url = it.url,
                urlImage = it.urlImage,
                image = it.image,
                publishAt = it.publishedAt,
                createAt = it.createdAt
            )
            articleList.add(article)
        }
        return articleList
    }

    fun articleEntitiesToModelMapper(input: List<ArticleEntity>): List<ArticleModel> =
        input.map {
            ArticleModel(
                id = it.id,
                title = it.title,
                description = it.description,
                content = it.content,
                author = it.author,
                url = it.url,
                urlImage = it.urlImage,
                image = it.image,
                publishAt = it.publishAt,
                createAt = it.createAt
            )
        }

    fun articleModelToEntitiesMapper(input: ArticleModel) = ArticleEntity(
        id = input.id,
        title = input.title,
        description = input.description,
        content = input.content,
        author = input.author,
        url = input.url,
        urlImage = input.urlImage,
        image = input.image,
        publishAt = input.publishAt,
        createAt = input.createAt
    )
}