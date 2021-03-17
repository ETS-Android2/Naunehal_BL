package edu.aku.hassannaqvi.naunehal.database

import edu.aku.hassannaqvi.naunehal.contracts.ChildContract
import edu.aku.hassannaqvi.naunehal.contracts.ChildInformationContract
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract
import edu.aku.hassannaqvi.naunehal.contracts.IMContract
import edu.aku.hassannaqvi.naunehal.models.*

object CreateTable {
    const val PROJECT_NAME = "NAUNEHAL2021"
    const val DATABASE_NAME = "$PROJECT_NAME.db"
    const val DATABASE_COPY = "${PROJECT_NAME}_copy.db"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_FORMS = ("CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS96x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_G5FLAG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HHFLAG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DCODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UCODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_CLUSTER + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HHNO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S01HH + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S05PD + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S06BF + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S07CV + " TEXT,"
            + FormsContract.FormsTable.COLUMN_S08SE + " TEXT"
            + " );")

    const val SQL_CREATE_CHILD_INFO = ("CREATE TABLE "
            + ChildInformationContract.ChildInfoTable.TABLE_NAME + "("
            + ChildInformationContract.ChildInfoTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_UID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_UUID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_USERNAME + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SYSDATE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_STATUS + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_ISSELECTED + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_DEVICEID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SYNCED + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_APPVERSION + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_DCODE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_UCODE + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_CLUSTER + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_HHNO + " TEXT,"
            + ChildInformationContract.ChildInfoTable.COLUMN_SCB + " TEXT"
            + " );")

    const val SQL_CREATE_CHILD = ("CREATE TABLE "
            + ChildContract.ChildTable.TABLE_NAME + "("
            + ChildContract.ChildTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildContract.ChildTable.COLUMN_PROJECT_NAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_UID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_UUID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_FMUID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_USERNAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYSDATE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_STATUS + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DEVICEID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DEVICETAGID + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYNCED + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SYNCED_DATE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_APPVERSION + " TEXT,"
            + ChildContract.ChildTable.COLUMN_DCODE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_UCODE + " TEXT,"
            + ChildContract.ChildTable.COLUMN_CLUSTER + " TEXT,"
            + ChildContract.ChildTable.COLUMN_HHNO + " TEXT,"
            + ChildContract.ChildTable.COLUMN_MOTHER_NAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_CHILD_NAME + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SERIAL + " TEXT,"
            + ChildContract.ChildTable.COLUMN_SCS + " TEXT"
            + " );")

    const val SQL_CREATE_IMMUNIZATION = ("CREATE TABLE "
            + IMContract.IMTable.TABLE_NAME + "("
            + IMContract.IMTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + IMContract.IMTable.COLUMN_PROJECT_NAME + " TEXT,"
            + IMContract.IMTable.COLUMN_UID + " TEXT,"
            + IMContract.IMTable.COLUMN_UUID + " TEXT,"
            + IMContract.IMTable.COLUMN_FMUID + " TEXT,"
            + IMContract.IMTable.COLUMN_USERNAME + " TEXT,"
            + IMContract.IMTable.COLUMN_SYSDATE + " TEXT,"
            + IMContract.IMTable.COLUMN_STATUS + " TEXT,"
            + IMContract.IMTable.COLUMN_DEVICEID + " TEXT,"
            + IMContract.IMTable.COLUMN_DEVICETAGID + " TEXT,"
            + IMContract.IMTable.COLUMN_SYNCED + " TEXT,"
            + IMContract.IMTable.COLUMN_SYNCED_DATE + " TEXT,"
            + IMContract.IMTable.COLUMN_APPVERSION + " TEXT,"
            + IMContract.IMTable.COLUMN_DCODE + " TEXT,"
            + IMContract.IMTable.COLUMN_UCODE + " TEXT,"
            + IMContract.IMTable.COLUMN_CLUSTER + " TEXT,"
            + IMContract.IMTable.COLUMN_HHNO + " TEXT,"
            + IMContract.IMTable.COLUMN_MOTHER_NAME + " TEXT,"
            + IMContract.IMTable.COLUMN_CHILD_NAME + " TEXT,"
            + IMContract.IMTable.COLUMN_SERIAL + " TEXT,"
            + IMContract.IMTable.COLUMN_SIM + " TEXT"
            + " );")

    const val SQL_CREATE_USERS = ("CREATE TABLE " + Users.UsersTable.TABLE_NAME + "("
            + Users.UsersTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Users.UsersTable.COLUMN_USERNAME + " TEXT,"
            + Users.UsersTable.COLUMN_PASSWORD + " TEXT,"
            + Users.UsersTable.COLUMN_FULLNAME + " TEXT,"
            + Users.UsersTable.COLUMN_DIST_ID + " TEXT"
            + " );")

    const val SQL_CREATE_DISTRICTS = ("CREATE TABLE " + Districts.TableDistricts.TABLE_NAME + "("
            + Districts.TableDistricts.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Districts.TableDistricts.COLUMN_DISTRICT_NAME + " TEXT,"
            + Districts.TableDistricts.COLUMN_DISTRICT_CODE + " TEXT"
            + " );")

    const val SQL_CREATE_UCS = ("CREATE TABLE " + UCs.TableUCs.TABLE_NAME + "("
            + UCs.TableUCs.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCs.TableUCs.COLUMN_UC_NAME + " TEXT,"
            + UCs.TableUCs.COLUMN_UC_CODE + " TEXT,"
            + UCs.TableUCs.COLUMN_DISTRICT_CODE + " TEXT"
            + " );")

    const val SQL_CREATE_CLUSTERS = ("CREATE TABLE " + Clusters.TableClusters.TABLE_NAME + "("
            + Clusters.TableClusters.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Clusters.TableClusters.COLUMN_DIST_CODE + " TEXT,"
            + Clusters.TableClusters.COLUMN_CLUSTER_NAME + " TEXT,"
            + Clusters.TableClusters.COLUMN_CLUSTER_CODE + " TEXT"
            + " );")

    const val SQL_CREATE_BL_RANDOM = ("CREATE TABLE " + BLRandom.TableRandom.TABLE_NAME + "("
            + BLRandom.TableRandom.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + BLRandom.TableRandom.COLUMN_CLUSTER_CODE + " TEXT,"
            + BLRandom.TableRandom.COLUMN_DIST_CODE + " TEXT,"
            + BLRandom.TableRandom.COLUMN_LUID + " TEXT,"
            + BLRandom.TableRandom.COLUMN_HH + " TEXT,"
            + BLRandom.TableRandom.COLUMN_STRUCTURE_NO + " TEXT,"
            + BLRandom.TableRandom.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + BLRandom.TableRandom.COLUMN_HH_HEAD + " TEXT,"
            + BLRandom.TableRandom.COLUMN_CONTACT + " TEXT,"
            + BLRandom.TableRandom.COLUMN_UPDATEDT + " TEXT,"
            + BLRandom.TableRandom.COLUMN_RANDOMDT + " TEXT,"
            + BLRandom.TableRandom.COLUMN_SNO_HH + " TEXT );")

    const val SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionApp.VersionAppTable.TABLE_NAME + " (" +
            VersionApp.VersionAppTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionApp.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionApp.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionApp.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");"
}