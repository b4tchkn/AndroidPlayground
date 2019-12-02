package com.batch

data class Otenki(
    val copyright: Copyright,
    val description: Description,
    val forecasts: List<Forecast>,
    val link: String,
    val location: Location,
    val pinpointLocations: List<PinpointLocation>,
    val publicTime: String,
    val title: String
) {
    data class Copyright(
        val image: Image,
        val link: String,
        val provider: List<Provider>,
        val title: String
    ) {
        data class Image(
            val height: Int,
            val link: String,
            val title: String,
            val url: String,
            val width: Int
        )

        data class Provider(
            val link: String,
            val name: String
        )
    }

    data class Description(
        val publicTime: String,
        val text: String
    )

    data class Forecast(
        val date: String,
        val dateLabel: String,
        val image: Image,
        val telop: String,
        val temperature: Temperature
    ) {
        data class Image(
            val height: Int,
            val title: String,
            val url: String,
            val width: Int
        )

        data class Temperature(
            val max: Any,
            val min: Any
        )
    }

    data class Location(
        val area: String,
        val city: String,
        val prefecture: String
    )

    data class PinpointLocation(
        val link: String,
        val name: String
    )
}