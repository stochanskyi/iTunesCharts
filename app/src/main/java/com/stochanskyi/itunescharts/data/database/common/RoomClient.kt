package com.stochanskyi.itunescharts.data.database.common

import android.content.Context
import androidx.room.Room

class RoomClient(
    context: Context
) {
    val database =
        Room.databaseBuilder(context, AppDatabase::class.java, "main_database").build()
}