package com.iutdev.jetflix.data.service

import com.iutdev.jetflix.ui.settings.Language

interface ConfigurationService {
    suspend fun fetchLanguages(): List<Language>
}
