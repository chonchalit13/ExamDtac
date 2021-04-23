package th.co.toei.examdtac.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import th.co.toei.examdtac.databinding.ItemLayoutBinding
import th.co.toei.examdtac.model.Result

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mItem: MutableList<Result>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(mItem!![position])
    }

    override fun getItemCount(): Int = mItem?.size ?: 0

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding: ItemLayoutBinding = ItemLayoutBinding.bind(view)

        fun bindView(itemContact: Result) {
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE))
                .load(itemContact.picture?.large)
                .into(binding.imgView)

            val name =
                "${itemContact.name.title} ${itemContact.name.first} ${itemContact.name.last}"
            binding.tvName.text = name

            binding.tvAge.text = itemContact.dob.age.toString()

            binding.tvEmail.text = itemContact.email
        }
    }

    fun setListData(data: MutableList<Result>) {
        mItem = data
        notifyDataSetChanged()
    }
}