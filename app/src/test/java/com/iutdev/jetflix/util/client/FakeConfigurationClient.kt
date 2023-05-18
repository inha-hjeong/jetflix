package com.iutdev.jetflix.util.client

import com.iutdev.jetflix.data.service.ConfigurationService
import com.iutdev.jetflix.ui.settings.Language

class FakeConfigurationClient : ConfigurationService {
    var fetchLanguagesException: Exception? = null
    var languages = listOf<Language>()

    override suspend fun fetchLanguages(): List<Language> {
        return if (fetchLanguagesException == null) {
            languages
        } else {
            throw fetchLanguagesException!!.also { fetchLanguagesException = null }
        }
    }
}
