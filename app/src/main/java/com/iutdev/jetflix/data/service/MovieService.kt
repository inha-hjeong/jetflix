package com.iutdev.jetflix.data.service

import com.iutdev.jetflix.data.remote.CreditsResponse
import com.iutdev.jetflix.data.remote.GenresResponse
import com.iutdev.jetflix.data.remote.ImagesResponse
import com.iutdev.jetflix.data.remote.MovieDetailResponse
import com.iutdev.jetflix.data.remote.MoviesResponse

interface MovieService {
    suspend fun fetchMovies(pageNumber: Int, options: Map<String, String>): MoviesResponse

    suspend fun search(pageNumber: Int, searchQuery: String, includeAdult: Boolean = true): MoviesResponse

    suspend fun fetchGenres(): GenresResponse

    suspend fun fetchMovieDetail(movieId: Int): MovieDetailResponse

    suspend fun fetchMovieCredits(movieId: Int): CreditsResponse

    suspend fun fetchMovieImages(movieId: Int): ImagesResponse
}
