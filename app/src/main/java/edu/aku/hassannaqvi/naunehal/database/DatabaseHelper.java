package edu.aku.hassannaqvi.naunehal.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.naunehal.contracts.ChildContract;
import edu.aku.hassannaqvi.naunehal.contracts.ChildInformationContract;
import edu.aku.hassannaqvi.naunehal.contracts.ChildInformationContract.ChildInfoTable;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.naunehal.contracts.IMContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;
import edu.aku.hassannaqvi.naunehal.models.Child;
import edu.aku.hassannaqvi.naunehal.models.ChildInformation;
import edu.aku.hassannaqvi.naunehal.models.Clusters;
import edu.aku.hassannaqvi.naunehal.models.Clusters.TableClusters;
import edu.aku.hassannaqvi.naunehal.models.Districts;
import edu.aku.hassannaqvi.naunehal.models.Districts.TableDistricts;
import edu.aku.hassannaqvi.naunehal.models.Form;
import edu.aku.hassannaqvi.naunehal.models.FormIndicatorsModel;
import edu.aku.hassannaqvi.naunehal.models.Immunization;
import edu.aku.hassannaqvi.naunehal.models.UCs;
import edu.aku.hassannaqvi.naunehal.models.UCs.TableUCs;
import edu.aku.hassannaqvi.naunehal.models.Users;
import edu.aku.hassannaqvi.naunehal.models.Users.UsersTable;
import edu.aku.hassannaqvi.naunehal.models.VersionApp;
import edu.aku.hassannaqvi.naunehal.models.VersionApp.VersionAppTable;
import edu.aku.hassannaqvi.naunehal.utils.CreateTable;

/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final String TAG = "DatabaseHelper";

    public DatabaseHelper(Context context) {
        super(context, CreateTable.DATABASE_NAME, null, CreateTable.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable.SQL_CREATE_USERS);
        db.execSQL(CreateTable.SQL_CREATE_DISTRICTS);
        db.execSQL(CreateTable.SQL_CREATE_UCS);
        db.execSQL(CreateTable.SQL_CREATE_CLUSTERS);
        db.execSQL(CreateTable.SQL_CREATE_FORMS);
        db.execSQL(CreateTable.SQL_CREATE_CHILD_INFO);
        db.execSQL(CreateTable.SQL_CREATE_CHILD);
        db.execSQL(CreateTable.SQL_CREATE_IMMUNIZATION);
        db.execSQL(CreateTable.SQL_CREATE_VERSIONAPP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
            case 2:
        }
    }


    /*
     * Addition in DB
     * */
    public Long addForm(Form form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(FormsContract.FormsTable.COLUMN_UID, form.getUid());
        values.put(FormsContract.FormsTable.COLUMN_USERNAME, form.getUserName());
        values.put(FormsContract.FormsTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(FormsContract.FormsTable.COLUMN_S01HH, form.getS01HH());
        values.put(FormsContract.FormsTable.COLUMN_S02CB, form.getS02CB());
        values.put(FormsContract.FormsTable.COLUMN_S03CS, form.getS03CS());
        values.put(FormsContract.FormsTable.COLUMN_S04IM, form.getS04IM());
        values.put(FormsContract.FormsTable.COLUMN_S05PD, form.getS05PD());
        values.put(FormsContract.FormsTable.COLUMN_S06BF, form.getS06BF());
        values.put(FormsContract.FormsTable.COLUMN_S07CV, form.getS07CV());
        values.put(FormsContract.FormsTable.COLUMN_S08SE, form.getS08SE());

        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, form.getIStatus());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, form.getIStatus96x());
        values.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, form.getEndTime());
        values.put(FormsContract.FormsTable.COLUMN_GPS, form.getGps());

        values.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(FormsContract.FormsTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(FormsContract.FormsTable.COLUMN_APPVERSION, form.getAppver());
        values.put(FormsContract.FormsTable.COLUMN_CHILD_RESPONDENT, form.getChildrespondent());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsContract.FormsTable.TABLE_NAME,
                FormsContract.FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChild(Child form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ChildContract.ChildTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(ChildContract.ChildTable.COLUMN_UID, form.getUid());
        values.put(ChildContract.ChildTable.COLUMN_UUID, form.getUuid());
        values.put(ChildContract.ChildTable.COLUMN_FMUID, form.getFmuid());
        values.put(ChildContract.ChildTable.COLUMN_USERNAME, form.getUserName());
        values.put(ChildContract.ChildTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(ChildContract.ChildTable.COLUMN_DCODE, form.getDcode());
        values.put(ChildContract.ChildTable.COLUMN_UCODE, form.getUcode());
        values.put(ChildContract.ChildTable.COLUMN_CLUSTER, form.getCluster());
        values.put(ChildContract.ChildTable.COLUMN_HHNO, form.getHhno());
        values.put(ChildContract.ChildTable.COLUMN_SCS, form.s03CStoString());
        values.put(ChildContract.ChildTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(ChildContract.ChildTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(ChildContract.ChildTable.COLUMN_SYNCED, form.getSynced());
        values.put(ChildContract.ChildTable.COLUMN_SYNCED_DATE, form.getSyncDate());
        values.put(ChildContract.ChildTable.COLUMN_APPVERSION, form.getAppver());
        values.put(ChildContract.ChildTable.COLUMN_STATUS, form.getStatus());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ChildContract.ChildTable.TABLE_NAME,
                ChildContract.ChildTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildInformation(ChildInformation form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(ChildInfoTable.COLUMN_UID, form.getUid());
        values.put(ChildInfoTable.COLUMN_UUID, form.getUuid());
        values.put(ChildInfoTable.COLUMN_USERNAME, form.getUserName());
        values.put(ChildInfoTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(ChildInfoTable.COLUMN_DCODE, form.getDcode());
        values.put(ChildInfoTable.COLUMN_UCODE, form.getUcode());
        values.put(ChildInfoTable.COLUMN_CLUSTER, form.getCluster());
        values.put(ChildInfoTable.COLUMN_HHNO, form.getHhno());
        values.put(ChildInfoTable.COLUMN_SCB, form.sCBtoString());
        values.put(ChildInfoTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(ChildInfoTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(ChildInfoTable.COLUMN_SYNCED, form.getSynced());
        values.put(ChildInfoTable.COLUMN_SYNCED_DATE, form.getSyncDate());
        values.put(ChildInfoTable.COLUMN_APPVERSION, form.getAppver());
        values.put(ChildInfoTable.COLUMN_STATUS, form.getStatus());
        values.put(ChildInfoTable.COLUMN_ISSELECTED, form.getIsSelected());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ChildInfoTable.TABLE_NAME,
                ChildInfoTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addIM(Immunization form) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(IMContract.IMTable.COLUMN_PROJECT_NAME, form.getProjectName());
        values.put(IMContract.IMTable.COLUMN_UID, form.getUid());
        values.put(IMContract.IMTable.COLUMN_UUID, form.getUuid());
        values.put(IMContract.IMTable.COLUMN_FMUID, form.getFmuid());
        values.put(IMContract.IMTable.COLUMN_USERNAME, form.getUserName());
        values.put(IMContract.IMTable.COLUMN_SYSDATE, form.getSysDate());
        values.put(IMContract.IMTable.COLUMN_DCODE, form.getDcode());
        values.put(IMContract.IMTable.COLUMN_UCODE, form.getUcode());
        values.put(IMContract.IMTable.COLUMN_CLUSTER, form.getCluster());
        values.put(IMContract.IMTable.COLUMN_HHNO, form.getHhno());
        values.put(IMContract.IMTable.COLUMN_SIM, form.s04IMtoString());
        values.put(IMContract.IMTable.COLUMN_DEVICEID, form.getDeviceId());
        values.put(IMContract.IMTable.COLUMN_DEVICETAGID, form.getDeviceTag());
        values.put(IMContract.IMTable.COLUMN_SYNCED, form.getSynced());
        values.put(IMContract.IMTable.COLUMN_SYNCED_DATE, form.getSyncDate());
        values.put(IMContract.IMTable.COLUMN_APPVERSION, form.getAppver());
        values.put(IMContract.IMTable.COLUMN_STATUS, form.getStatus());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                IMContract.IMTable.TABLE_NAME,
                IMContract.IMTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    /*
     * Functions that dealing with table data
     * */
    public Users getLoginUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UsersTable.COLUMN_ID,
                UsersTable.COLUMN_USERNAME,
                UsersTable.COLUMN_PASSWORD,
                UsersTable.COLUMN_FULLNAME,
        };
        String whereClause = UsersTable.COLUMN_USERNAME + "=? AND " + UsersTable.COLUMN_PASSWORD + "=?";
        String[] whereArgs = {username, password};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users allForms = null;
        try {
            c = db.query(
                    UsersTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allForms = new Users().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public ArrayList<Form> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_SYSDATE,
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS96x,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormsTable.COLUMN_ID + " ASC";
        ArrayList<Form> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form forms = new Form();
                forms.setId(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndex(FormsTable.COLUMN_USERNAME)));
                allForms.add(forms);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public FormIndicatorsModel getFormStatusCount(String sysdate) {
        SQLiteDatabase db = this.getReadableDatabase();
        FormIndicatorsModel count = new FormIndicatorsModel();
        Cursor mCursor = db.rawQuery(
                String.format("select " +
                        "sum(case when %s = 1 then 1 else 0 end) as completed," +
                        "sum(case when %s != 1 OR %s is null then 1 else 0 end) as notCompleted " +
                        "from %s WHERE %s Like ?", FormsTable.COLUMN_ISTATUS, FormsTable.COLUMN_ISTATUS, FormsTable.COLUMN_ISTATUS, FormsTable.TABLE_NAME, FormsTable.COLUMN_SYSDATE),
                new String[]{"%" + sysdate + " %"}, null);
        if (mCursor != null && mCursor.moveToFirst()) {
            count = count.copy(Integer.parseInt(mCursor.getString(0)),
                    Integer.parseInt(mCursor.getString(1)));
            mCursor.close();
        }
        return count;
    }

    public FormIndicatorsModel getUploadStatusCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        FormIndicatorsModel count = new FormIndicatorsModel();
        Cursor mCursor = db.rawQuery(
                String.format("select " +
                        "sum(case when %s = 1 then 1 else 0 end) as completed," +
                        "sum(case when %s is null OR %s = '' then 1 else 0 end) as notCompleted " +
                        "from %s", FormsTable.COLUMN_SYNCED, FormsTable.COLUMN_SYNCED, FormsTable.COLUMN_SYNCED, FormsTable.TABLE_NAME),
                null, null);
        if (mCursor != null && mCursor.moveToFirst()) {
            count = count.copy(Integer.parseInt(mCursor.getString(0)),
                    Integer.parseInt(mCursor.getString(1)));
            mCursor.close();
        }
        return count;
    }

    public ArrayList<ChildInformation> getFamilyFromDB(String cluster, String hhno, String uuid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String whereClause = ChildInfoTable.COLUMN_CLUSTER + " =? AND "
                + ChildInfoTable.COLUMN_HHNO + " =? AND "
                + ChildInfoTable.COLUMN_UUID + " =?";
        String[] whereArgs = {cluster, hhno, uuid};
        String groupBy = null;
        String having = null;
        String orderBy = ChildInfoTable.COLUMN_ID + " ASC";
        ArrayList<ChildInformation> allForms = new ArrayList<>();
        try {
            c = db.query(
                    ChildInfoTable.TABLE_NAME,  // The table to query
                    null,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildInformation childItem = new ChildInformation().Hydrate(c);
                childItem.setMotherAvailable(childItem.cb11.equals("1"));
                childItem.setTotalMonths((Integer.parseInt(childItem.getCb0501()) * 12) + Integer.parseInt(childItem.getCb0502()));
                allForms.add(childItem);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public ArrayList<ChildInformation> getSelectedChildrenFromDB(String cluster, String hhno, String uuid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String whereClause = ChildInfoTable.COLUMN_CLUSTER + " =? AND "
                + ChildInfoTable.COLUMN_HHNO + " =? AND "
                + ChildInfoTable.COLUMN_UUID + " =?";
        String[] whereArgs = {cluster, hhno, uuid};
        String groupBy = null;
        String having = null;
        String orderBy = ChildInfoTable.COLUMN_ID + " ASC";
        ArrayList<ChildInformation> allForms = new ArrayList<>();
        try {
            c = db.query(
                    ChildInfoTable.TABLE_NAME,  // The table to query
                    null,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildInformation info = new ChildInformation().Hydrate(c);
                info.setMotherAvailable(info.cb11.equals("1"));
                int calculateMonth = (Integer.parseInt(info.getCb0501()) * 12) + Integer.parseInt(info.getCb0502());
                if (calculateMonth <= 35) info.setUnder35(true);
                info.setChildTableDataExist(
                        (Child) getFormExist(
                                ChildContract.ChildTable.class,
                                info.getCluster(),
                                info.getHhno(),
                                info.getUuid(),
                                info.getUid()));
                allForms.add(info);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allForms;
    }

    public Object getFormExist(Class<?> tableName, String cluster, String hhno, String uuid, String fmuid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Object count = null;
        String query = "";
        String[] where = null;
        if (tableName.getName().equals(ChildContract.ChildTable.class.getName())) {
            query = String.format("select *from %s where %s=? AND %s=? AND %s=? AND %s=?",
                    ChildContract.ChildTable.TABLE_NAME,
                    ChildContract.ChildTable.COLUMN_CLUSTER,
                    ChildContract.ChildTable.COLUMN_HHNO,
                    ChildContract.ChildTable.COLUMN_UUID,
                    ChildContract.ChildTable.COLUMN_FMUID
            );
            where = new String[]{cluster, hhno, uuid, fmuid};
        } else if (tableName.getName().equals(IMContract.IMTable.class.getName())) {
            query = String.format("select *from %s where %s=? AND %s=? AND %s=? AND %s=?",
                    IMContract.IMTable.TABLE_NAME,
                    IMContract.IMTable.COLUMN_CLUSTER,
                    IMContract.IMTable.COLUMN_HHNO,
                    IMContract.IMTable.COLUMN_UUID,
                    IMContract.IMTable.COLUMN_FMUID
            );
            where = new String[]{cluster, hhno, uuid, fmuid};
        }
        Cursor mCursor = db.rawQuery(query, where, null);
        if (mCursor != null && mCursor.moveToFirst()) {
            if (tableName.getName().equals(ChildContract.ChildTable.class.getName())) {
                count = new Child().Hydrate(mCursor);
            } else if (tableName.getName().equals(IMContract.IMTable.class.getName())) {
                count = new Immunization().Hydrate(mCursor);
            }
            mCursor.close();
        }
        return count;
    }

    public ArrayList<Districts> getAllDistricts() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = TableDistricts._ID + " ASC";
        ArrayList<Districts> all = new ArrayList<>();
        try {
            c = db.query(
                    TableDistricts.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                all.add(new Districts().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return all;
    }

    public ArrayList<UCs> getUCsByDistricts(String dCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause = TableUCs.COLUMN_DISTRICT_CODE + "=?";
        String[] whereArgs = new String[]{dCode};
        String groupBy = null;
        String having = null;

        String orderBy = TableUCs.COLUMN_UC_CODE + " ASC";

        ArrayList<UCs> allDC = new ArrayList<>();
        try {
            c = db.query(
                    TableUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCs dc = new UCs();
                allDC.add(dc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public BLRandom getHHFromBLRandom(String subAreaCode, String hh) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;

        String[] columns = {
                BLRandomContract.BLRandomTable.COLUMN_ID,
                BLRandomContract.BLRandomTable.COLUMN_LUID,
                BLRandomContract.BLRandomTable.COLUMN_STRUCTURE_NO,
                BLRandomContract.BLRandomTable.COLUMN_FAMILY_EXT_CODE,
                BLRandomContract.BLRandomTable.COLUMN_HH,
                BLRandomContract.BLRandomTable.COLUMN_P_CODE,
                BLRandomContract.BLRandomTable.COLUMN_EB_CODE,
                BLRandomContract.BLRandomTable.COLUMN_RANDOMDT,
                BLRandomContract.BLRandomTable.COLUMN_HH_SELECTED_STRUCT,
                BLRandomContract.BLRandomTable.COLUMN_CONTACT,
                BLRandomContract.BLRandomTable.COLUMN_HH_HEAD,
                BLRandomContract.BLRandomTable.COLUMN_SNO_HH
        };

        String whereClause = BLRandomContract.BLRandomTable.COLUMN_P_CODE + "=? AND " + BLRandomContract.BLRandomTable.COLUMN_HH + "=?";
        String[] whereArgs = new String[]{subAreaCode, hh};
        String groupBy = null;
        String having = null;

        String orderBy =
                BLRandomContract.BLRandomTable.COLUMN_ID + " ASC";

        BLRandom allBL = null;
        try {
            c = db.query(
                    BLRandomContract.BLRandomTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allBL = new BLRandom().hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allBL;
    }*/


    /*
     * Update data in tables
     * */
    public int updateSpecificChildInformationColumn(ChildInformation childInformation, String isSelected) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(ChildInfoTable.COLUMN_ISSELECTED, isSelected);

        String selection = ChildInfoTable.COLUMN_CLUSTER + " =? AND "
                + ChildInfoTable.COLUMN_HHNO + " =? AND "
                + ChildInfoTable.COLUMN_UUID + " =? AND "
                + ChildInfoTable.COLUMN_UID + " =? AND "
                + ChildInfoTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {childInformation.getCluster(), childInformation.getHhno(), childInformation.getUuid(), childInformation.getUid(), childInformation.getId()};

        return db.update(ChildInfoTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesChildInformationColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildInfoTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.childInformation.getId())};

        return db.update(ChildInfoTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesChildColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ChildContract.ChildTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.child.getId())};

        return db.update(ChildContract.ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesIMColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = IMContract.IMTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.immunization.getId())};

        return db.update(IMContract.IMTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsContract.FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_SYNCED, true);
        values.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsContract.FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsContract.FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS, MainApp.form.getIStatus());
        values.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, MainApp.form.getIStatus96x());
        values.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, MainApp.form.getEndTime());

        // Which row to update, based on the ID
        String selection = FormsContract.FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.form.getId())};

        return db.update(FormsContract.FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    /*
     * Download data functions
     * */
    public int syncDistricts(JSONArray Districtslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Districts.TableDistricts.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < Districtslist.length(); i++) {
                JSONObject jsonObjectDistrict = Districtslist.getJSONObject(i);
                Districts District = new Districts();
                District.sync(jsonObjectDistrict);
                ContentValues values = new ContentValues();

                values.put(TableDistricts.COLUMN_DISTRICT_CODE, District.getDistrictCode());
                values.put(TableDistricts.COLUMN_DISTRICT_NAME, District.getDistrictName());
                long rowID = db.insert(TableDistricts.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncDistrict(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncCluster(JSONArray clusterList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableClusters.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < clusterList.length(); i++) {
                JSONObject jsonObjectCluster = clusterList.getJSONObject(i);
                Clusters cluster = new Clusters();
                cluster.sync(jsonObjectCluster);
                ContentValues values = new ContentValues();

                values.put(TableClusters.COLUMN_CLUSTER_CODE, cluster.getClusterCode());
                values.put(TableClusters.COLUMN_CLUSTER_NAME, cluster.getClustername());
                values.put(TableClusters.COLUMN_UC_CODE, cluster.getUcCode());

                long rowID = db.insert(TableClusters.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncCluster(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncUCs(JSONArray ucList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableUCs.TABLE_NAME, null, null);
        int insertCount = 0;
        try {

            for (int i = 0; i < ucList.length(); i++) {
                JSONObject jsonObjectUc = ucList.getJSONObject(i);
                UCs uc = new UCs();
                uc.sync(jsonObjectUc);
                ContentValues values = new ContentValues();

                values.put(TableUCs.COLUMN_UC_CODE, uc.getUcCode());
                values.put(TableUCs.COLUMN_UC_NAME, uc.getUcName());
                values.put(TableUCs.COLUMN_DISTRICT_CODE, uc.getDistrictCode());

                long rowID = db.insert(TableUCs.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }
            db.close();

        } catch (Exception e) {
            Log.d(TAG, "syncUc(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }

    public int syncVersionApp(JSONObject VersionList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppTable.TABLE_NAME, null, null);
        long count = 0;
        try {
            JSONObject jsonObjectCC = ((JSONArray) VersionList.get(VersionAppTable.COLUMN_VERSION_PATH)).getJSONObject(0);
            VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionAppTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }

        return (int) count;
    }

    public int syncUser(JSONArray userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        try {
            for (int i = 0; i < userList.length(); i++) {

                JSONObject jsonObjectUser = userList.getJSONObject(i);

                Users user = new Users();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
                values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
                values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
                long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
                if (rowID != -1) insertCount++;
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
            db.close();
        } finally {
            db.close();
        }
        return insertCount;
    }


    /*
     * get UnSyncedTables
     * */
    public Collection<Form> getUnsyncedForms(int formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormsTable.COLUMN_SYNCED + " is null AND " + FormsTable.COLUMN_ISTATUS + "=?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

        Collection<Form> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Form fc = new Form();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<Child> getUnsyncedChild(int formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = ChildContract.ChildTable.COLUMN_SYNCED + " is null AND " + ChildContract.ChildTable.COLUMN_STATUS + "=?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy = ChildContract.ChildTable.COLUMN_ID + " ASC";

        Collection<Child> allFC = new ArrayList<>();
        try {
            c = db.query(
                    ChildContract.ChildTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Child fc = new Child();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<ChildInformation> getUnsyncedChildInfo(int formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = ChildInformationContract.ChildInfoTable.COLUMN_SYNCED + " is null AND " + ChildInformationContract.ChildInfoTable.COLUMN_STATUS + "=?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy = ChildInformationContract.ChildInfoTable.COLUMN_ID + " ASC";

        Collection<ChildInformation> allFC = new ArrayList<>();
        try {
            c = db.query(
                    ChildInformationContract.ChildInfoTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildInformation fc = new ChildInformation();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    public Collection<Immunization> getUnsyncedIM(int formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = IMContract.IMTable.COLUMN_SYNCED + " is null AND " + IMContract.IMTable.COLUMN_STATUS + "=?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy = IMContract.IMTable.COLUMN_ID + " ASC";

        Collection<Immunization> allFC = new ArrayList<>();
        try {
            c = db.query(
                    IMContract.IMTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                Immunization fc = new Immunization();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


}