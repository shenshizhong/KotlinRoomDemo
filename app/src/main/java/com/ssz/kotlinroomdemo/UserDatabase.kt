package com.ssz.kotlinroomdemo

import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

//后续的数据库升级通过这个version来控制，exportSchema是否导出数据库的配置信息
@Database(entities = [Student::class], version = 2, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
  companion object {
    var dataBase: StudentDatabase
    val TAG = StudentDatabase::class.java.simpleName
    init {
      //如果databaseBuilder改为inMemoryDatabaseBuilder则创建一个内存数据库（进程销毁后，数据丢失）
      dataBase = Room.databaseBuilder(MyApplication.getApplicationContext(), StudentDatabase::class.java, "db_user")
        //数据库的操作是否允许在主线程中执行
        .allowMainThreadQueries()
        //数据库创建和打开后的回调，可以重写其中的方法
        .addCallback(object : Callback() {
          override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d(TAG, "onCreate: db_student")
          }
        })
        //数据库升级异常之后的回滚
        .fallbackToDestructiveMigration()
        .build()
    }

  }

  abstract fun getStudentDao(): StudentDao
}