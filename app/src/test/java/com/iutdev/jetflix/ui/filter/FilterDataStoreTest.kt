package com.iutdev.jetflix.ui.filter

import com.iutdev.jetflix.ui.filter.option.SortBy
import com.iutdev.jetflix.util.CoroutineTestRule
import com.iutdev.jetflix.util.FakeStringDataStore
import com.iutdev.jetflix.util.json
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

@ExperimentalCoroutinesApi
class FilterDataStoreTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private val fakeStringDataStore = FakeStringDataStore()

    @Test
    fun `Should set filterState as default when preference is not exists`() = runTest {
        fakeStringDataStore.set("", "")

        val filterDataStore = createFilterDataStore()

        expectThat(filterDataStore.filterState.first()).isEqualTo(FilterState())
    }

    @Test
    fun `Should set filterState when preference is exists`() = runTest {
        val filterState = FilterState(sortBy = SortBy.VOTE_AVERAGE)
        fakeStringDataStore.set(filterState)

        val filterDataStore = createFilterDataStore()

        expectThat(filterDataStore.filterState.first()).isEqualTo(filterState)
    }

    private fun createFilterDataStore() = FilterDataStore(json, fakeStringDataStore)
}
