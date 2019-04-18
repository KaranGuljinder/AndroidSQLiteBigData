package com.developpement.guide.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

    private val DATABASE_VERSION = 1
    private val DATABASE_NAME = "db.sqlite"
    val TABLE_MESSENGER = "a"
    const val COLUMN_COL1 = "col1"
    const val COLUMN_COL2 = "col2"
    const val COLUMN_COL3 = "col3"
    const val COLUMN_COUNTER = "COUNTER"

class MyDBHandler(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_MESSENGER_TABLE = ("CREATE TABLE " +
                TABLE_MESSENGER + "("
                + COLUMN_COL1
                + " TEXT," +
                COLUMN_COL2
                + " TEXT," +
                COLUMN_COL3
                + " TEXT," + COLUMN_COUNTER + " INTEGER" + ")")
        db.execSQL(CREATE_MESSENGER_TABLE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase, oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSENGER)
        onCreate(db)
    }

    fun findOneGram(word: String) : String ?  {

        val query =
            "SELECT $COLUMN_COL2 FROM  $TABLE_MESSENGER  WHERE $COLUMN_COL1  = \"$word\" ORDER BY $COLUMN_COUNTER desc LIMIT 3"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var data: Test? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            val string = cursor.getString(0)
            cursor.close()
        }
        db.close()
        return data?.col2
    }
}