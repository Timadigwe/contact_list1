package com.example.contact_list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.contact_list.databinding.ActivityCategoryBinding
import java.util.*

class CategoryActivity : AppCompatActivity() {
   private  val categoryAdapter = CategoryAdapter()
   private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.categoryRv.adapter = categoryAdapter


        setupData(binding)
    }

    private fun setupData(binding: ActivityCategoryBinding) {


        val categoryList = mutableListOf<Category>()
            categoryList.add(
                Category(
                    "Family",
                    R.drawable.ic_baseline_contacts1_24
                )
            )
        categoryList.add(
                Category(
                    "Friends",
                    R.drawable.ic_baseline_contacts2_24
                )
        )
        categoryList.add(
                Category(
                    "Colleagues",
                    R.drawable.ic_baseline_contacts3_24
                )
        )
        categoryList.add(
                Category(
                    "Tutors",
                    R.drawable.ic_baseline_contacts4_24
                )
        )
        categoryList.add(
                Category(
                    "Favourites",
                    R.drawable.ic_baseline_contacts_24
                )
        )
        title = "Contacts:Category"

         binding.categoryRv.adapter= categoryAdapter
        binding.categoryRv.layoutManager = GridLayoutManager(this,2)
        categoryAdapter.setUpCategory(categoryList)
        }

    }

