package com.android.sample.app.di

import com.android.sample.app.domain.Link
import com.android.sample.app.viewmodel.DashboardViewModel
import com.android.sample.app.viewmodel.SectionViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { DashboardViewModel(get(named("dashboard"))) }

    viewModel { (link : Link) -> SectionViewModel(get(named("section")), link) }
}