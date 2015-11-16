package com.newboston.test3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by boss on 16.11.2015.
 */
public class HotOrNot {

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_HOT = "persons_hot";

    public static final String DB_NAME = "HotOrNotDB";
    public static final String DB_TABLE = "people_table";
    public static final int DB_VERSION = 1;

    private DBHelper dbHelper;
    private final Context context;
    private SQLiteDatabase sqLiteDatabase;

    public HotOrNot(Context context) {
        this.context = context;
    }

    public String getData() {
        String[] columns = new String[]{KEY_ID, KEY_NAME, KEY_HOT};
        Cursor c = sqLiteDatabase.query(DB_TABLE, columns, null, null, null, null, null);
        int iRow = c.getColumnIndex(KEY_ID);
        int iName = c.getColumnIndex(KEY_NAME);
        int iHot = c.getColumnIndex(KEY_HOT);
        String result = new String();
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result += c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iHot) + "\n";

        }
        return result;
    }

    private static class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE " + DB_TABLE +
                            "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NAME +
                            " TEXT NOT NULL, " + KEY_HOT + " TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST " + DB_TABLE);
            onCreate(db);
        }
    }

    public HotOrNot open() throws SQLException {
        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long createEntry(String name, String hot) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_HOT, hot);
        return sqLiteDatabase.insert(DB_TABLE, null, cv);
    }

}
