package com.android.sample.app.viewmodel

import com.android.sample.app.base.BaseRepository
import com.android.sample.app.base.BaseViewModel
import com.android.sample.app.domain.Link
import com.android.sample.app.domain.Section
import com.android.sample.app.util.cleanHref

class SectionViewModel(repository: BaseRepository<Section>, link: Link) :
    BaseViewModel<Section>(repository, link.id, link.href.cleanHref())