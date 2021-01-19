package edu.aku.hassannaqvi.naunehal.models

import android.database.Cursor
import android.provider.BaseColumns
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class BLRandom {
    var id: String = ""
    var lUID: String = ""
    var distCode: String = ""
    var clusterCode: String = ""
    var structure: String = ""
    var extension: String = ""
    var hh: String = ""
    var hhhead: String = ""
    var randomDT: String = ""
    var contact: String = ""
    var updateDT: String = ""
    var sno: String = ""
    var tabno: String = ""

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): BLRandom {
        lUID = jsonObject.getString(TableRandom.COLUMN_LUID)
        clusterCode = jsonObject.getString(TableRandom.COLUMN_CLUSTER_CODE)
        distCode = jsonObject.getString(TableRandom.COLUMN_DIST_CODE)
        structure = jsonObject.getString(TableRandom.COLUMN_STRUCTURE_NO)
        structure = String.format("%04d", Integer.valueOf(structure), Locale.ENGLISH)
        extension = jsonObject.getString(TableRandom.COLUMN_FAMILY_EXT_CODE)
        extension = String.format("%03d", Integer.valueOf(extension), Locale.ENGLISH)
        tabno = jsonObject.getString(TableRandom.COLUMN_TAB_NO)
        hh = "$tabno-$structure-$extension"
        randomDT = jsonObject.getString(TableRandom.COLUMN_RANDOMDT)
        hhhead = jsonObject.getString(TableRandom.COLUMN_HH_HEAD)
        contact = jsonObject.getString(TableRandom.COLUMN_CONTACT)
        updateDT = jsonObject.getString(TableRandom.COLUMN_UPDATEDT)
        sno = jsonObject.getString(TableRandom.COLUMN_SNO_HH)
        return this
    }

    fun hydrate(cursor: Cursor): BLRandom {
        id = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_ID))
        lUID = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_LUID))
        clusterCode = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_CLUSTER_CODE))
        distCode = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_DIST_CODE))
        structure = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_STRUCTURE_NO))
        extension = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_FAMILY_EXT_CODE))
        hh = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_HH))
        randomDT = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_RANDOMDT))
        hhhead = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_HH_HEAD))
        contact = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_CONTACT))
        updateDT = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_UPDATEDT))
        sno = cursor.getString(cursor.getColumnIndex(TableRandom.COLUMN_SNO_HH))
        return this
    }

    object TableRandom : BaseColumns {
        const val TABLE_NAME = "bl_randomised"
        const val COLUMN_ID = "_id"
        const val COLUMN_RANDOMDT = "randDT"
        const val COLUMN_LUID = "UID"
        const val COLUMN_SNO_HH = "sno"
        const val COLUMN_CLUSTER_CODE = "hh02"
        const val COLUMN_STRUCTURE_NO = "hh03"
        const val COLUMN_FAMILY_EXT_CODE = "hh07"
        const val COLUMN_HH = "hh"
        const val COLUMN_HH_HEAD = "hh08"
        const val COLUMN_CONTACT = "hh09"
        const val COLUMN_DIST_CODE = "dist_id"
        const val COLUMN_UPDATEDT = "updDt"
        const val COLUMN_TAB_NO = "tabNo"
    }

}