package com.ssz.kotlinroomdemo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Student")
data class Student(
  @PrimaryKey
  var id: String,
  var name: String
) : Parcelable