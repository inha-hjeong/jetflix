package com.iutdev.jetflix.ui.profile

import com.iutdev.jetflix.data.remote.ProfileResponse
import com.iutdev.jetflix.util.Mapper
import com.iutdev.jetflix.util.toImdbProfileUrl
import com.iutdev.jetflix.util.toOriginalUrl
import javax.inject.Inject

class ProfileMapper @Inject constructor() : Mapper<ProfileResponse, Profile> {
    override fun map(input: ProfileResponse) = Profile(
        name = input.name,
        biography = input.biography,
        birthday = input.birthday.orEmpty(),
        placeOfBirth = input.placeOfBirth.orEmpty(),
        alsoKnownAs = input.alsoKnownAs,
        imdbProfileUrl = input.imdbId?.toImdbProfileUrl(),
        profilePhotoUrl = input.profilePath?.toOriginalUrl().orEmpty(),
        knownFor = input.knownForDepartment,
    )
}
