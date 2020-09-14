package com.fmohammadi.shoppinglistmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fmohammadi.shoppinglistmvvm.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllShoppingItem(): LiveData<List<ShoppingItem>>
}
