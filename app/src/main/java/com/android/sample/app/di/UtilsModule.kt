package com.android.sample.app.di

import com.google.gson.Gson
import org.koin.dsl.module

val utilModule = module {
    single { Gson() }
}