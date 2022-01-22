package com.android.sample.app.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.android.sample.app.repository.DashboardRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class RefreshDashboardWork(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params), KoinComponent {

    companion object {
        const val WORK_NAME = "RefreshDashboardWork"
    }

    /**
     * A coroutine-friendly method to do your work.
     */
    override suspend fun doWork(): Result {
        val repository: DashboardRepository by inject()
        return try {
            repository.refresh(null)
            Result.success()
        } catch (err: Exception) {
            Result.failure()
        }
    }
}