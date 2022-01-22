package com.android.sample.app.di

import androidx.room.Room
import com.android.sample.app.R
import com.android.sample.app.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java,
                androidApplication().getString(R.string.database))
                .build()
    }

    single { get<AppDatabase>().dashboardDao() }

    single { get<AppDatabase>().sectionDao() }
}