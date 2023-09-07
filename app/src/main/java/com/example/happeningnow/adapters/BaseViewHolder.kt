package com.example.happeningnow.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<N> (itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindItems(item:N)
}