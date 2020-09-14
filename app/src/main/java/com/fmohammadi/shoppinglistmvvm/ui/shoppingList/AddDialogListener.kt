package com.fmohammadi.shoppinglistmvvm.ui.shoppingList

import com.fmohammadi.shoppinglistmvvm.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}