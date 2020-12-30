package com.batch.kmm_sample.shared

import com.batch.kmm_sample.shared.cache.Database
import com.batch.kmm_sample.shared.cache.DatabaseDriverFactory
import com.batch.kmm_sample.shared.entity.RocketLaunch
import com.batch.kmm_sample.shared.network.SpaceXApi

class SpaceXSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory = databaseDriverFactory)
    private val api = SpaceXApi()

    @Throws(Exception::class)
    suspend fun getLaunches(forceReload: Boolean): List<RocketLaunch> {
        val cachedLaunches = database.getAllLaunches()
        return if (cachedLaunches.isNotEmpty() && !forceReload) {
            cachedLaunches
        } else {
            api.getAllLaunches().also {
                database.clearDatabase()
                database.createLaunches(it)
            }
        }
    }
}