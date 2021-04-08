package edu.aku.hassannaqvi.naunehal_mhs.models

import android.database.Cursor
import android.os.Parcel
import android.os.Parcelable
import android.provider.BaseColumns
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

class Camps() : Parcelable {
    var idCamp: String = StringUtils.EMPTY
    var camp_no: String = StringUtils.EMPTY
    var dist_id: String = StringUtils.EMPTY
    var district: String = StringUtils.EMPTY
    var ucCode: String = StringUtils.EMPTY
    var ucName: String = StringUtils.EMPTY
    var area_name: String = StringUtils.EMPTY

    constructor(parcel: Parcel) : this() {
        idCamp = parcel.readString().toString()
        camp_no = parcel.readString().toString()
        dist_id = parcel.readString().toString()
        district = parcel.readString().toString()
        ucCode = parcel.readString().toString()
        ucName = parcel.readString().toString()
        area_name = parcel.readString().toString()
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): Camps {
        idCamp = jsonObject.getString(TableCamp.COLUMN_ID_CAMP)
        camp_no = jsonObject.getString(TableCamp.COLUMN_CAMP_NO)
        dist_id = jsonObject.getString(TableCamp.COLUMN_DIST_ID)
        district = jsonObject.getString(TableCamp.COLUMN_DISTRICT)
        ucCode = jsonObject.getString(TableCamp.COLUMN_UC_CODE)
        ucName = jsonObject.getString(TableCamp.COLUMN_UC_NAME)
        area_name = jsonObject.getString(TableCamp.COLUMN_AREA_NAME)
        return this
    }

    fun hydrate(cursor: Cursor): Camps {
        idCamp = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_ID_CAMP))
        camp_no = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_CAMP_NO))
        dist_id = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_DIST_ID))
        district = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_DISTRICT))
        ucCode = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_UC_CODE))
        ucName = cursor.getString(cursor.getColumnIndex(TableCamp.COLUMN_UC_NAME))
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
        const val COLUMN_UC_NAME = "ucName"
        const val COLUMN_AREA_NAME = "area_name"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idCamp)
        parcel.writeString(camp_no)
        parcel.writeString(dist_id)
        parcel.writeString(district)
        parcel.writeString(ucCode)
        parcel.writeString(ucName)
        parcel.writeString(area_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Camps> {
        override fun createFromParcel(parcel: Parcel): Camps {
            return Camps(parcel)
        }

        override fun newArray(size: Int): Array<Camps?> {
            return arrayOfNulls(size)
        }
    }
}