package edu.aku.hassannaqvi.naunehal.models

import android.database.Cursor
import android.provider.BaseColumns
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by hassan.naqvi on 10/31/2016.
 * @update ali.azaz
 */
class Clusters {
    var clusterCode: String = ""
    var clustername: String = ""
    var distCode: String = ""

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Clusters {
        clusterCode = jsonObject.getString(TableClusters.COLUMN_CLUSTER_CODE)
        clustername = jsonObject.getString(TableClusters.COLUMN_CLUSTER_NAME)
        distCode = jsonObject.getString(TableClusters.COLUMN_DIST_CODE)
        return this
    }

    fun hydrate(cursor: Cursor): Clusters {
        clusterCode = cursor.getString(cursor.getColumnIndex(TableClusters.COLUMN_CLUSTER_CODE))
        clustername = cursor.getString(cursor.getColumnIndex(TableClusters.COLUMN_CLUSTER_NAME))
        distCode = cursor.getString(cursor.getColumnIndex(TableClusters.COLUMN_DIST_CODE))
        return this
    }

    object TableClusters : BaseColumns {
        const val TABLE_NAME = "clusters"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_id"
        const val COLUMN_CLUSTER_CODE = "cluster_no"
        const val COLUMN_CLUSTER_NAME = "geoarea"
        const val COLUMN_DIST_CODE = "dist_id"
    }
}