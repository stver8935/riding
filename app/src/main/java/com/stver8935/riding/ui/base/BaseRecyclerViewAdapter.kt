package com.stver8935.riding.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerViewAdapter<T,VB: ViewBinding>(
    private var items: MutableList<T>
): RecyclerView.Adapter<BaseRecyclerViewAdapter<T,VB>.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = inflateBinding(LayoutInflater.from(parent.context),parent)
        return CustomViewHolder(binding)
    }

    /***
     * 해당 위치 에서 루프 또는 리스너 초기화 구문을 작성 하지 말것
     */
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        bind(holder.binding,items[position])
    }

    override fun getItemCount(): Int = items.size

    abstract fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup): VB

    abstract fun bind(binding: VB, item: T)

    inner class CustomViewHolder(val binding: VB): RecyclerView.ViewHolder(binding.root)
}