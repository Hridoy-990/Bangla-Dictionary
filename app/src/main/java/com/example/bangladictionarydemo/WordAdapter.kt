package com.example.bangladictionarydemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.bangladictionarydemo.Database_Maintain.DictionaryBangla
import kotlinx.android.synthetic.main.word_view.view.*

class WordAdapter : RecyclerView.Adapter<WordAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    private var  wordList = emptyList<DictionaryBangla>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.word_view , parent , false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val currentItem = wordList[position]
        holder.itemView.targetBanglaWord.text =  currentItem.serial.toString()
        holder.itemView.targetWordId.text  = currentItem.word
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
    fun setData(word :List<DictionaryBangla>)
    {
        this.wordList = word
        notifyDataSetChanged()
    }


}