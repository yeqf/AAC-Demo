package me.yeqf.android.persistence.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import me.yeqf.android.bean.GanHuo
import me.yeqf.common.utils.TimeUtils
import java.util.*

/**
 * Created by Administrator on 2018\2\12 0012.
 */
@Entity(tableName = "GankIoCache")
data class GankIoCache(@PrimaryKey
                       var _id: String = "",
                       var createdAt: Long = 0,
                       var desc: String? = "",
                       var publishedAt: Long = 0,
                       var source: String? = "",
                       var type: String = "",
                       var url: String? = "",
                       var used: Boolean? = false,
                       var who: String? = "",
                       var images: List<String>? = null,
                       var content: String? = null,
                       var updatedAt: Long = 0,
                       var time: String,
                       var insertTime: Long,
                       @Ignore
                       var page: Int) {
    constructor(): this("", 0, "", 0, "", "", "", false, "", null, "", 0, "", 0, 0)
    constructor(o: GanHuo) :
            this(o._id,
                    TimeUtils.getTime(o.createdAt, TimeUtils.FORMAT_YYYYMMDD_T_HHMMSS_SSSZ),
                    o.desc,
                    TimeUtils.getTime(o.publishedAt, TimeUtils.FORMAT_YYYYMMDD_T_HHMMSS_SSSZ),
                    o.source,
                    o.type,
                    o.url,
                    o.used,
                    o.who,
                    o.images,
                    o.content,
                    TimeUtils.getTime(o.updated_at, TimeUtils.FORMAT_YYYYMMDD_T_HHMMSS_SSSZ),
                    "1970-01-01",
                    0,
                    1) {
        if(publishedAt > 0)
            this.time = TimeUtils.getTime(publishedAt, TimeUtils.FORMAT_YYYY_MM_DD)
        insertTime = System.currentTimeMillis()
    }
}