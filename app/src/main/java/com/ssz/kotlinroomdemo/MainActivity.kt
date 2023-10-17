package com.ssz.kotlinroomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
  private val TAG = this.javaClass.simpleName
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    btn_add.setOnClickListener {
      lifecycleScope.launch {
        val studentDao = StudentDatabase.dataBase.getStudentDao()
        studentDao.putStudent(Student("101","小李"));
        studentDao.putStudent(Student("102","小王"))
      }
    }

    btn_query.setOnClickListener {
      lifecycleScope.launch {
        val studentDao = StudentDatabase.dataBase.getStudentDao()
        val students = studentDao.getAllStudent()
        Log.d(TAG, "students: $students")
      }
    }

    btn_update.setOnClickListener {
      lifecycleScope.launch {
        val studentDao = StudentDatabase.dataBase.getStudentDao()
        val student = studentDao.update(Student("101","小陈"))
        Log.d(TAG,student.toString());
      }
    }
    btn_delete.setOnClickListener {
      lifecycleScope.launch {
        val studentDao = StudentDatabase.dataBase.getStudentDao()
        val student = studentDao.delete(Student("101","小陈"))
        Log.d(TAG,student.toString());

        val students = studentDao.getAllStudent()
        Log.d(TAG, "students: $students")
      }
    }




//    //lifecycleScope默认是在主线程执行的
//    lifecycleScope.launch {
//      val students = studentDao.getAllStudent()
//      Log.e(TAG, "students: $students")
//      val student = studentDao.getStudent("101")
//      Log.e(TAG, "student: $student")
//      Log.e(TAG, "testCache: 协程执行完毕")
//    }

  }

}