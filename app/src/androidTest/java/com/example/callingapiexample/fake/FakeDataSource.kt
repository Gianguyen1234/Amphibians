package com.example.callingapiexample.fake

import com.example.callingapiexample.model.AmphibiansData

object FakeDataSource {

    val fakeDataList = listOf(
        AmphibiansData("Frog", "A small green frog.", "Amphibian", "frog_image_url"),
        AmphibiansData("Salamander", "A slimy salamander.", "Amphibian", "salamander_image_url"))
}