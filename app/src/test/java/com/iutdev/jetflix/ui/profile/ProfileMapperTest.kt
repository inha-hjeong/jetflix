package com.iutdev.jetflix.ui.profile

import com.iutdev.jetflix.data.remote.ProfileResponse
import com.iutdev.jetflix.util.parseJson
import com.iutdev.jetflix.util.toImdbProfileUrl
import com.iutdev.jetflix.util.toOriginalUrl
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ProfileMapperTest {
    private val mapper = ProfileMapper()

    private val profileResponse = parseJson<ProfileResponse>("person.json")

    @Test
    fun map() {
        val profile = mapper.map(profileResponse)

        expectThat(profile.name).isEqualTo(profileResponse.name)
        expectThat(profile.biography).isEqualTo(profileResponse.biography)
        expectThat(profile.birthday).isEqualTo(profileResponse.birthday)
        expectThat(profile.placeOfBirth).isEqualTo(profileResponse.placeOfBirth)
        expectThat(profile.alsoKnownAs).isEqualTo(profileResponse.alsoKnownAs)
        expectThat(profile.imdbProfileUrl).isEqualTo(profileResponse.imdbId?.toImdbProfileUrl())
        expectThat(profile.profilePhotoUrl).isEqualTo(profileResponse.profilePath?.toOriginalUrl())
        expectThat(profile.knownFor).isEqualTo(profileResponse.knownForDepartment)
    }
}
