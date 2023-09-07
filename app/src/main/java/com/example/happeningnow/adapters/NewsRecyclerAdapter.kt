package com.example.happeningnow.adapters

import android.net.Uri
import android.util.Log
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide
import com.example.happeningnow.R
import com.example.happeningnow.databinding.ListItemNewsBinding
import com.example.happeningnow.models.NewsModel
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback
import javax.inject.Inject


class NewsRecyclerAdapter @Inject constructor() :
    BaseRecyclerAdapter<NewsRecyclerAdapter.ViewHolder, NewsModel>() {


    override fun getLayoutResource(): Int = R.layout.list_item_news

    override fun getViewHolder(view: View): ViewHolder = ViewHolder(view)

    class ViewHolder(itemView: View) : BaseViewHolder<NewsModel>(itemView) {
        val binding = ListItemNewsBinding.bind(itemView)
        override fun bindItems(item: NewsModel) {

            binding.tvTitle.text = item.title
            if (item.multimedia.isNotEmpty() && item.multimedia[0].url != null) {
                Glide.with(itemView).load(item.multimedia[0].url).into(binding.ivNews);
                Log.e("TAG", item.multimedia.toString())

            }else if (item.multimedia.isNotEmpty())
                Glide.with(itemView).load(item.multimedia[0].mediaMetadata[0].url).into(binding.ivNews);

            binding.tvAuthor.text = item.byline
            binding.tvAbstract.text = item.abstract
            itemView.setOnClickListener {
                val customTabsIntent = CustomTabsIntent.Builder()
                    .setShowTitle(true)
                    .build()
                CustomTabsHelper.addKeepAliveExtra(itemView.context, customTabsIntent.intent)
                CustomTabsHelper.openCustomTab(
                    itemView.context, customTabsIntent,
                    Uri.parse(item.url),
                    WebViewFallback()
                )

            }

        }

    }
}