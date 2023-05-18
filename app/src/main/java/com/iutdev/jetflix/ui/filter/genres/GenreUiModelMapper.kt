package com.iutdev.jetflix.ui.filter.genres

import com.iutdev.jetflix.data.remote.Genre
import com.iutdev.jetflix.util.Mapper
import javax.inject.Inject

class GenreUiModelMapper @Inject constructor() : Mapper<Genre, GenreUiModel> {
    override fun map(input: Genre) = GenreUiModel(input)
}
