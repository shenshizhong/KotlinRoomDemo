package com.ssz.kotlinroomdemo

import androidx.room.*

@Dao
interface StudentDao {

  //通过@Insert 注解的onConflict 解决冲突，如果有老的数据存在则会进行替换,如果没有就插入
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun putStudent(cacheBean: Student)

  @Query("select * from Student where id =:id")
  suspend fun getStudent(id: String): Student?

  @Query("select * from Student")
  suspend fun getAllStudent(): List<Student>?

  @Delete
  suspend fun delete(student: Student)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  suspend fun update(student: Student)

}