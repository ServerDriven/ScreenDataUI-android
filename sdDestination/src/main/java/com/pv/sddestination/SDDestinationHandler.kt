package com.pv.sddestination

import com.pv.screendata.objects.Destination
import com.pv.screendata.screens.SomeScreen
import com.pv.screendata.types.DestinationType
import kotlinx.coroutines.flow.Flow

object SDDestinationStore {

    var desinationHandler: SDDestinationHandler? = null
}

interface SDDestinationHandler {

    fun handeDestination(destination: Destination?)

}


class DefaultSDDestinationHandler(
) : SDDestinationHandler {

    override fun handeDestination(destination: Destination?) = when (destination?.type) {
        DestinationType.screen -> {

        }
        DestinationType.url -> {

        }
        DestinationType.deepLink -> {

        }
        null -> {

        }
    }
}
