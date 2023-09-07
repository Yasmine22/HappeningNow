package com.example.happeningnow.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject

abstract class BaseRecyclerAdapter<T : BaseViewHolder<N>, N:Any> : RecyclerView.Adapter<T>() {
    protected val clickSubject = PublishSubject.create<N>()
    var clickEvent: Observable<N> = clickSubject
    val items = ArrayList<N>()
    abstract fun getLayoutResource():Int
    abstract fun getViewHolder(view:View):T
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(getLayoutResource(), parent, false)
        return getViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindItems(items[position])
        Log.e("TAG","${position}")
    }

    override fun getItemCount() = items.size

    fun addData(addedItems: List<N>) {
        items.clear()
        items.addAll(addedItems)
        notifyDataSetChanged()
    }



}