package com.iutdev.jetflix.ui.filter.genres

import androidx.compose.ui.graphics.Color
import com.iutdev.jetflix.data.remote.Genre
import com.iutdev.jetflix.util.randomColor
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class GenreUiModel(val genre: Genre = Genre(-1, "")) {
    @Transient
    val primaryColor: Color = Color.randomColor()

    @Transient
    val secondaryColor: Color = Color.randomColor()
}
