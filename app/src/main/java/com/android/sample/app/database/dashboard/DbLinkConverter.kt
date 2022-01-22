package com.android.sample.app.database.dashboard

import androidx.room.TypeConverter
import com.google.gson.Gson
import org.koin.core.KoinComponent
import org.koin.core.inject

class DbLinkConverter : KoinComponent {

    private val gson: Gson by inject()

    @TypeConverter
    fun jsonToList(value: String): List<DbLink> =
        gson.fromJson(value, Array<DbLink>::class.java).toList()

    @TypeConverter
    fun listToJson(value: List<DbLink?>) = gson.toJson(value.filterNotNull())
}