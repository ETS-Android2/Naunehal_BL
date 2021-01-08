package edu.aku.hassannaqvi.naunehal.base.repository

import edu.aku.hassannaqvi.naunehal.database.DatabaseHelper
import edu.aku.hassannaqvi.naunehal.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList

open class GeneralRepository(private val db: DatabaseHelper) : GeneralDataSource {

    override suspend fun getChildList(cluster: String, hhno: String, uuid: String): ArrayList<ChildInformation> = withContext(Dispatchers.IO) {
        db.getFamilyFromDB(cluster, hhno, uuid)
    }

    override suspend fun getLoginInformation(username: String, password: String): Users? = withContext(Dispatchers.IO) {
        db.getLoginUser(username, password)
    }

    override suspend fun getFormsByDate(date: String): ArrayList<Form> = withContext(Dispatchers.IO) {
        db.getFormsByDate(date)
    }

    override suspend fun getUploadStatus(): FormIndicatorsModel = withContext(Dispatchers.IO) {
        db.uploadStatusCount
    }

    override suspend fun getFormStatus(date: String): FormIndicatorsModel = withContext(Dispatchers.IO) {
        db.getFormStatusCount(date)
    }
}