package com.android.sample.app.di

import com.android.sample.app.base.BaseRepository
import com.android.sample.app.domain.Dashboard
import com.android.sample.app.domain.Section
import com.android.sample.app.repository.DashboardRepository
import com.android.sample.app.repository.SectionRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    single<BaseRepository<Dashboard>>(named("dashboard")) {
        DashboardRepository(get(), get(), get(), get(named("ioDispatcher")))
    }

    single<BaseRepository<Section>>(named("section")) {
        SectionRepository(get(), get(), get(), get(named("ioDispatcher")))
    }
}