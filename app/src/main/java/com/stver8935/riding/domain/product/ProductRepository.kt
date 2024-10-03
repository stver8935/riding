package com.stver8935.riding.domain.product

/**
 *
 *
 * @packageName    : com.stver8935.riding.domain.product
 * @fileName   : ProductRepository
 * @author     : hangihyeong
 * @since      : 2024. 10. 1.
 */
interface ProductRepository {
    fun create(product: Product)
    fun edit(product: Product)
    fun delete(productId: Long)
    fun addComment()
    fun deleteComment()
    fun editComment()
}