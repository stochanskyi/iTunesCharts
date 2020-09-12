package com.stochanskyi.itunescharts.data.database.common

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stochanskyi.itunescharts.data.database.favourites.FavouritesDao

@Database(entities = [FavouritesDao::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract val favouritesDao: FavouritesDao

}