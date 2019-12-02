@file:Suppress("DEPRECATION")

package com.batch.recyclerviewsample

import com.airbnb.epoxy.EpoxyController
import kotlin.Suppress
import kotlin.Unit

inline fun EpoxyController.item(modelInitializer: ItemBindingModelBuilder.() -> Unit) {
    ItemBindingModel_().apply {
        modelInitializer()
    }
    .addTo(this)
}
