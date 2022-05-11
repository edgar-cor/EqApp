package com.example.earthquaken

data class Earthquake(val id: String, val place: String, val magnitude: Double, val time: Long,
                 val logitude: Double, val latitude: Double)