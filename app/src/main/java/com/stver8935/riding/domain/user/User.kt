package com.stver8935.riding.domain.user

import com.google.gson.annotations.SerializedName

/**
 *
 *
 * @packageName    : com.stver8935.riding.domain.user
 * @fileName   : UserEntity
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
data class User(
    @SerializedName("") var id: Long,
    @SerializedName("") var name: String,
    @SerializedName("") var profileImgPath: String,
    @SerializedName("access_token") var accessToken: String,
    @SerializedName("created_at") var createdAt: String,
)
