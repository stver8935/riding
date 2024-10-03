package com.stver8935.riding.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 *
 *
 * @packageName    : com.stver8935.riding.data.model
 * @fileName   : User
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey val id: Long,
    val name: String,
    @ColumnInfo(name = "profile_image_Path") val profileImagePath: String,
    @ColumnInfo(name = "created_at") val createdAt: Date
)
