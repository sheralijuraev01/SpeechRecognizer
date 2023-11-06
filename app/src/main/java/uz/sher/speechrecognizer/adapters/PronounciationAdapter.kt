package uz.sher.speechrecognizer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.sher.speechrecognizer.databinding.PronunciationItemBinding
import uz.sher.speechrecognizer.model.Pronunciation

class PronounciationAdapter(private val list: MutableList<Pronunciation>) :
    RecyclerView.Adapter<PronounciationAdapter.ViewHolder>() {

    var listener:OnClickAdapterItemListener?=null

    inner class ViewHolder(private val binding: PronunciationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(pronunciation: Pronunciation) {
            binding.titlePosition.text = pronunciation.position
            binding.textTitle.text = pronunciation.title

            binding.root.setOnClickListener{
                listener?.onClickItem(adapterPosition)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            PronunciationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }


    fun setOnclikcListener(listener: OnClickAdapterItemListener){
        this.listener=listener
    }


    interface OnClickAdapterItemListener{
        fun onClickItem(position: Int)
    }



}