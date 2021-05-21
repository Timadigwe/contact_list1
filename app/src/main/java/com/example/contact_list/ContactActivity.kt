package com.example.contact_list

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contact_list.databinding.ActivityContactBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ContactActivity : AppCompatActivity() {
   private val contactAdapter = ContactAdapter()
    private lateinit var binding: ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData(binding)/**/

    }
    private fun  setUpData(binding:ActivityContactBinding){
        val actionBar:ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        val intent =intent
        val newName = intent.getStringExtra("iCatName")
        actionBar.title=newName


        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog,null)
        builder.setView(view)

        val contactName = view.findViewById<TextInputEditText>(R.id.nameET)
        val contactNumber = view.findViewById<TextInputEditText>(R.id.phone_numET)
         val saveBT = view.findViewById<MaterialButton>(R.id.saveBt)
        contactNumber?.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                contactNumber.isInEditMode
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBT.isEnabled = s?.length == 11
            }

        })

        binding.contactsRV.adapter = contactAdapter
        binding.contactsRV.layoutManager= LinearLayoutManager(this)

       val alertDialog = builder.create()
        saveBT.setOnClickListener {
           val contact = Contact(contactName.text.toString(),contactNumber.text.toString())
            val contacts = mutableListOf(contact)
            contactAdapter.setUpContacts(contacts)
            alertDialog.dismiss()
        }

        binding.fab.setOnClickListener{
            alertDialog.show();
        }
    }
}