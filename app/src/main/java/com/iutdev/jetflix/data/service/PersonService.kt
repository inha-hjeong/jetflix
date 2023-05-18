package com.iutdev.jetflix.data.service

import com.iutdev.jetflix.data.remote.ProfileResponse

interface PersonService {
    suspend fun profile(id: Int): ProfileResponse
}
