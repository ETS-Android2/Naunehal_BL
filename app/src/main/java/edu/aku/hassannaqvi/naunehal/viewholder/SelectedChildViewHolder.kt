package edu.aku.hassannaqvi.naunehal.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.aku.hassannaqvi.naunehal.R
import edu.aku.hassannaqvi.naunehal.databinding.ChildViewBinding
import edu.aku.hassannaqvi.naunehal.databinding.SelectedChildViewBinding
import edu.aku.hassannaqvi.naunehal.models.ChildInformation
import edu.aku.hassannaqvi.naunehal.utils.convertStringToUpperCase
import edu.aku.hassannaqvi.naunehal.utils.shortStringLength

/*
* @author Ali Azaz Alam dt. 01.14.21
* */
class SelectedChildViewHolder(private val bi: SelectedChildViewBinding) :
        RecyclerView.ViewHolder(bi.root) {

    fun bind(item: ChildInformation) {
        bi.resName.text = String.format("Respondent: %s", (if (item.cb07 == "") item.cb12 else item.cb07).convertStringToUpperCase().shortStringLength())
        bi.name.text = item.cb02.convertStringToUpperCase().shortStringLength()
        val imageRes: Int = if (item.cb03 == "1") R.drawable.ctr_childboy else R.drawable.ctr_childgirl
        var flagImage = R.drawable.ic_incomplete_star
        when (item.isFlag) {
            true -> {
                flagImage = R.drawable.ic_incomplete_star
            }
            false -> {
                bi.parentLayout.isEnabled = false
                flagImage = R.drawable.ic_complete_star
            }
        }
        Glide.with(this.itemView.context)
                .asBitmap()
                .load(imageRes)
                .into(bi.childImg)
        Glide.with(this.itemView.context)
                .asBitmap()
                .load(flagImage)
                .into(bi.completeFlag)
        bi.executePendingBindings()
    }


    companion object {
        fun create(viewGroup: ViewGroup): SelectedChildViewHolder {
            val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.selected_child_view, viewGroup, false)
            val binding = SelectedChildViewBinding.bind(view)
            return SelectedChildViewHolder(binding)
        }
    }

    class ChildViewDiffUtils(
            private val oldList: ArrayList<ChildInformation>,
            private val newList: ArrayList<ChildInformation>
    ) :
            DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}