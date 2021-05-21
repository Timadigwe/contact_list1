package com.example.contact_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_list.databinding.ContactListItemBinding

open class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private val contacts =  mutableListOf<Contact>()
    inner class ContactViewHolder(private val binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindItem(contact: Contact) {
            binding.contactNameTV.text = contact.name
            binding.contactNumberTV.text = contact.phone_number
        }
    }
    fun setUpContacts(contacts: MutableList<Contact>){
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact:Contact = contacts[position]
        holder.bindItem(contact)
    }
}