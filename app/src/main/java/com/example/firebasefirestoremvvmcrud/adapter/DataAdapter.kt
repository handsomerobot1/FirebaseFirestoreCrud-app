package com.example.firebasefirestoremvvmcrud.adapter

import android.content.ClipData.Item
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasefirestoremvvmcrud.R
import com.example.firebasefirestoremvvmcrud.model.Data

class DataAdapter(private var data:List<Data>,
    private var itemClickListener: ItemClickListener):
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
    interface  ItemClickListener {
        fun onEdit (data: Data)
        fun onDeleteItemClick (data: Data)
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val studentid = itemView.findViewById<TextView>(R.id.idtxt)
        val name = itemView.findViewById<TextView>(R.id.nametxt)
        val email = itemView.findViewById<TextView>(R.id.emailtxt)
        val subject = itemView.findViewById<TextView>(R.id.subjecttxt)
        val birthdate = itemView.findViewById<TextView>(R.id.dobtxt)

        val edit = itemView.findViewById<TextView>(R.id.editbtn)
        val delete = itemView.findViewById<TextView>(R.id.deletebtn)


    }
    fun updateData(newData: List<Data>){
        this.data = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.studentid.text = item.id
        holder.name.text = item.name
        holder.email.text = item.email
        holder.subject.text = item.subject
        holder.birthdate.text = item.dob

        holder.edit.setOnClickListener {
            itemClickListener.onDeleteItemClick(item)
        }
        holder.delete.setOnClickListener {
            itemClickListener.onDeleteItemClick(item)
        }

    }
}