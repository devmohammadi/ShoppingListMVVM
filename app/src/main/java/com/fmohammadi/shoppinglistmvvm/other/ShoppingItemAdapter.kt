package com.fmohammadi.shoppinglistmvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fmohammadi.shoppinglistmvvm.R
import com.fmohammadi.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.fmohammadi.shoppinglistmvvm.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items:List<ShoppingItem>,
    private var viewModel:ShoppingViewModel
):RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.shopping_item , parent , false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.update(curShoppingItem)
        }

        holder.itemView.ivMinis.setOnClickListener {
            if(curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.update(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    inner class ShoppingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

}