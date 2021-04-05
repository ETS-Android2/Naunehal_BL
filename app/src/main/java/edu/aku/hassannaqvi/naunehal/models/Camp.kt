package edu.aku.hassannaqvi.naunehal.models

import android.database.Cursor
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

class Camp {
    var idCamp: String = StringUtils.EMPTY
    var camp_no: String = StringUtils.EMPTY
    var dist_id: String = StringUtils.EMPTY
    var district: String = StringUtils.EMPTY
    var ucCode: String = StringUtils.EMPTY
    var ucname: String = StringUtils.EMPTY
    var area_name: String = StringUtils.EMPTY

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Camp {
        idCamp = jsonObject.getString(TableCamp.COLUMN_ID_CAMP)
        camp_no = jsonObject.getString(TableCamp.COLUMN_CAMP_NO)
        dist_id = jsonObject.getString(TableCamp.COLUMN_DIST_ID)
        district = jsonObject.getString(TableCamp.COLUMN_DISTRICT)
        ucCode = jsonObject.getString(TableCamp.COLUMN_UC_CODE)
        ucname = jsonObject.getString(TableCamp.COLUMN_UC_NAME)
        area_name = jsonObject.getString(TableCamp.COLUMN_AREA_NAME)
        return this
    }

    fun hydrate(cursor: Cursor): Camp {
        idCamp = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_ID_CAMP))
        camp_no = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_CAMP_NO))
        dist_id = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_DIST_ID))
        district = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_DISTRICT))
        ucCode = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_UC_CODE))
        ucname = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_UC_NAME))
        area_name = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_AREA_NAME))
        return this
    }

    object TableCamp : BaseColumns {
        const val TABLE_NAME = "camps"
        const val COLUMN_NAME_NULLABLE = "nullColumnHack"
        const val COLUMN_ID = "_ID"
        const val COLUMN_ID_CAMP = "idCamp"
        const val COLUMN_CAMP_NO = "camp_no"
        const val COLUMN_DIST_ID = "dist_id"
        const val COLUMN_DISTRICT = "district"
        const val COLUMN_UC_CODE = "ucCode"
        const val COLUMN_UC_NAME = "ucname"
        const val COLUMN_AREA_NAME = "area_name"
    }
}