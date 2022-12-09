package com.student.mvvm.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.student.mvvm.database.NoteEntity
import com.student.mvvm.databinding.ItemRowLayoutBinding

class RvNoteAdapter : RecyclerView.Adapter<RvNoteAdapter.ViewHolder>() {
    private val list: MutableList<NoteEntity> = mutableListOf()
    private var onItemClickListener: OnItemClickListener? = null

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<NoteEntity>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteEntity) {
            with(binding) {
                noteTitle.text = note.noteTitle
                noteText.text = note.noteText
                root.setOnClickListener {
                    onItemClickListener?.onClick(note.id!!)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRowLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setOnClickListener(onClick: OnItemClickListener) {
        onItemClickListener = onClick
    }

    override fun getItemCount(): Int {
        return list.size
    }


    interface OnItemClickListener {
        fun onClick(id: Int)
    }
}