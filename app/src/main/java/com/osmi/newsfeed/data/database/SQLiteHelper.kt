package com.osmi.newsfeed.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context, version: Int, name: String?) : SQLiteOpenHelper(context, name, null, version) {

    companion object {
        const val DATA_BASE_NAME = "News.db"
        const val DATA_BASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}