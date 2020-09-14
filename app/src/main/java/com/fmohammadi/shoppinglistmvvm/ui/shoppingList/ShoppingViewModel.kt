package com.fmohammadi.shoppinglistmvvm.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.fmohammadi.shoppinglistmvvm.data.db.entities.ShoppingItem
import com.fmohammadi.shoppinglistmvvm.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun update(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.update(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItem() = repository.getAllShoppingItem()

}