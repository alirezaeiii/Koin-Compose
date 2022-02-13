package com.android.sample.app.repository

import android.content.Context
import com.android.sample.app.base.BaseRepository
import com.android.sample.app.database.section.SectionDao
import com.android.sample.app.database.section.asDomainModel
import com.android.sample.app.domain.Section
import com.android.sample.app.domain.asDatabaseModel
import com.android.sample.app.network.ApiService
import kotlinx.coroutines.CoroutineDispatcher

class SectionRepository(
    private val dao: SectionDao,
    private val api: ApiService,
    context: Context,
    ioDispatcher: CoroutineDispatcher
) : BaseRepository<Section>(context, ioDispatcher) {

    override suspend fun query(id: String?): Section? =
        dao.getSection(id!!)?.asDomainModel()

    override suspend fun fetch(url: String?): Section = api.getSection(url!!)

    override suspend fun saveFetchResult(t: Section) {
        dao.insert(t.asDatabaseModel())
    }
}