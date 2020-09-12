package com.stochanskyi.itunescharts.app.di

import com.stochanskyi.itunescharts.data.database.common.RoomClient

object DataModule: KoinModule({

    single{ RoomClient(get()) }

    single { get<RoomClient>().database.favouritesDao }

})