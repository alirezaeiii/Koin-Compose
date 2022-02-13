package com.android.sample.app.di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dispatcherModule = module {

    single(named("ioDispatcher")) { Dispatchers.IO }
}

