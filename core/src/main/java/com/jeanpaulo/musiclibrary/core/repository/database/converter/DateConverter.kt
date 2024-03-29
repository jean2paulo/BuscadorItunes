package com.jeanpaulo.musiclibrary.core.repository.database.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(time: Long?): Date? {
        return if (time != null) Date(time) else null
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}