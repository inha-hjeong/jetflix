package com.iutdev.jetflix.ui.moviedetail

import com.iutdev.jetflix.data.remote.MovieDetailResponse
import com.iutdev.jetflix.util.Mapper
import com.iutdev.jetflix.util.toBackdropUrl
import com.iutdev.jetflix.util.toPosterUrl
import javax.inject.Inject

class MovieDetailMapper @Inject constructor() : Mapper<MovieDetailResponse, MovieDetail> {
    override fun map(input: MovieDetailResponse): MovieDetail {
        val productionCompanies = input.productionCompanies.map {
            ProductionCompany(it.name, it.logoPath.orEmpty().toPosterUrl())
        }
        return MovieDetail(
            id = input.id,
            title = input.title,
            originalTitle = input.originalTitle,
            overview = input.overview,
            tagline = input.tagline.dropLastWhile { it == '.' },
            backdropUrl = input.backdropPath.orEmpty().toBackdropUrl(),
            posterUrl = input.posterPath.toPosterUrl(),
            genres = input.genres,
            releaseDate = input.releaseDate.orEmpty(),
            voteAverage = input.voteAverage,
            voteCount = input.voteCount,
            duration = input.runtime ?: -1,
            productionCompanies = productionCompanies,
            homepage = input.homepage,
        )
    }
}
