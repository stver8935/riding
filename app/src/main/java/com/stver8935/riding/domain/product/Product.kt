package com.stver8935.riding.domain.product

import com.google.gson.annotations.SerializedName
import com.stver8935.riding.domain.BaseModel

/**
 *
 *
 * @packageName    : com.stver8935.riding.domain.product
 * @fileName   : Product
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
data class Product(
    @SerializedName("id") var id: Long
) {

}
