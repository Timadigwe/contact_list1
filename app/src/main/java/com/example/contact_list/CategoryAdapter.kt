package com.example.contact_list

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact_list.databinding.CategoryListItemBinding

class CategoryAdapter:RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categoryList:MutableList<Category> = mutableListOf()


    fun setUpCategory(categoryList: List<Category>) {
        this.categoryList.addAll(categoryList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bindItem(category)
        holder.itemView.setOnClickListener {
            val model = categoryList[position]
            val catName: String = model.categoryName
            val catImage: Int = model.categoryImageSrc
            val intent = Intent(holder.itemView.context, ContactActivity::class.java)
            intent.putExtra("iCatName", catName)
            intent.putExtra("iCatLogo", catImage)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class CategoryViewHolder(private val binding: CategoryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(category: Category) {
            binding.categoryListItemIv.setImageResource(category.categoryImageSrc)
            binding.categoryListItemTv.text = category.categoryName
        }

    }
}