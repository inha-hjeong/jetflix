package com.iutdev.jetflix.util.client

import com.iutdev.jetflix.data.remote.ProfileResponse
import com.iutdev.jetflix.data.service.PersonService
import com.iutdev.jetflix.util.parseJson

class FakePersonClient : PersonService {
    var fetchProfileException: Exception? = null
    val profileResponse = parseJson<ProfileResponse>("person.json")

    override suspend fun profile(id: Int): ProfileResponse {
        return if (fetchProfileException == null) {
            profileResponse
        } else {
            throw fetchProfileException!!.also { fetchProfileException = null }
        }
    }
}
