package com.fmohammadi.shoppinglistmvvm.data.repositories

import com.fmohammadi.shoppinglistmvvm.data.db.ShoppingDatabase
import com.fmohammadi.shoppinglistmvvm.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun update(item:ShoppingItem) = db.getShopping().update(item)

    suspend fun delete(item: ShoppingItem) = db.getShopping().delete(item)

    fun getAllShoppingItem() = db.getShopping().getAllShoppingItem()
}