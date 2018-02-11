package me.yeqf.android.persistence.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Administrator on 2018\2\11 0011.
 */
@Entity(tableName = "DailyCache")
data class DailyData(@field:PrimaryKey(autoGenerate = true)
                     var id: Int,
                     var count: Int = 0,
                     @Embedded
                     var category: List<String>? = null,
                     var error: Boolean = false,
                     @Embedded
                     var results: List<Category>? = null,
                     var time: String = "")