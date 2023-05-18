package com.iutdev.jetflix.ui.movies.movie

import com.iutdev.jetflix.data.remote.MovieResponse
import com.iutdev.jetflix.util.Mapper
import com.iutdev.jetflix.util.toPosterUrl
import javax.inject.Inject

class MovieMapper @Inject constructor() : Mapper<MovieResponse, Movie> {
    override fun map(input: MovieResponse) = Movie(
        id = input.id,
        name = input.name,
        releaseDate = input.firstAirDate.orEmpty(),
        posterPath = input.posterPath.orEmpty().toPosterUrl(),
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
    )
}
