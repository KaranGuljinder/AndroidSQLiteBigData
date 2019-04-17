package com.developpement.guide.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

    private val DATABASE_VERSION = 1
    private val DATABASE_NAME = "dataDB.db"
    val TABLE_MESSENGER = "messsenger"
    const val COLUMN_ID = "_id"
    const val COLUMN_COL1 = "col1"
    const val COLUMN_COL2 = "col2"
    const val COLUMN_COL3 = "col3"
    const val COLUMN_COUNTER = "counter"

class MyDBHandler(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_MESSENGER + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_COL1
                + " TEXT," +
                COLUMN_COL2
                + " TEXT," +
                COLUMN_COL3
                + " TEXT," + COLUMN_COUNTER + " INTEGER" + ")")
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase, oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSENGER)
        onCreate(db)
    }

    fun addProduct(product: Test) {
        val values = ContentValues()
        values.put(COLUMN_COL1, product.col1)
        values.put(COLUMN_COL2, product.col2)
        values.put(COLUMN_COL3, product.col3)
        values.put(COLUMN_COUNTER, product.counter)

        val db = this.writableDatabase

        db.insert(TABLE_MESSENGER, null, values)
        db.close()
    }
}