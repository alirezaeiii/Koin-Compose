package com.android.sample.app.viewmodel

import com.android.sample.app.base.BaseRepository
import com.android.sample.app.base.BaseViewModel
import com.android.sample.app.domain.Dashboard

class DashboardViewModel(repository: BaseRepository<Dashboard>) :
    BaseViewModel<Dashboard>(repository)