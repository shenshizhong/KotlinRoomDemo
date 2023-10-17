package com.ssz.kotlinroomdemo

import android.app.Application
import android.content.Context

class MyApplication : Application() {
  init {
    instance = this
  }

  companion object {
    private var instance: MyApplication? = null
    fun getApplicationContext() : Context {
      return instance!!.applicationContext
    }
  }

  override fun onCreate() {
    super.onCreate()
  }

}
