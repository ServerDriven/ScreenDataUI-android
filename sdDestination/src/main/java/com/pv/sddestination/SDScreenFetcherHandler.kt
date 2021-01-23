package com.pv.sddestination

import com.pv.screendata.screens.SomeScreen
import kotlinx.coroutines.flow.Flow

object SDScreenFetcherStore {

    // should it be lateinit ? it should be initialized
    // before calls to it are made !
    lateinit var screenFetcher: SDScreenFetcher

    // decide how to supply better
    lateinit var blankScreen: SomeScreen
    lateinit var loadingScreen: SomeScreen
}

interface SDScreenFetcher {

    fun fetchScreen(id: String): Flow<SomeScreen>
}
