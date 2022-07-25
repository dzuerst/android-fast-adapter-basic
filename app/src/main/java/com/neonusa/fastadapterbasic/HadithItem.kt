package com.neonusa.fastadapterbasic

import android.view.View
import android.widget.TextView
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

// steps to create Item  Class
/*

    1. extends AbstractItem<HadithItem.ViewHolder>()
    2. Create ViewHolder class inside the item class
    3. extends FastAdapter.ViewHolder to  ViewHolder class
    4. implements the member on the view holder class
    5. implements the member on the item class

    // done the Item Class is ready to use

* */

class HadithItem(val hadith: Hadith): AbstractItem<HadithItem.ViewHolder>() {

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<HadithItem>(itemView) {
        var tvArabic: TextView = itemView.findViewById(R.id.tv_urutan_arab)
        var tvIndo: TextView = itemView.findViewById(R.id.tv_urutan_indo)

        override fun bindView(item: HadithItem, payloads: List<Any>) {
            tvArabic.text = item.hadith.hadits
            tvIndo.text = item.hadith.audio
        }

        override fun unbindView(item: HadithItem) {
            tvArabic.text = null
            tvIndo.text = null
        }
    }

    override val type: Int
        get() = R.id.fast_adapter_hadith_item_id

    override val layoutRes: Int
        get() = R.layout.item_hadith

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }
}