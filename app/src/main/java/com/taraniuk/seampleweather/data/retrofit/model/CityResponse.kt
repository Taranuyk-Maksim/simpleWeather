package com.taraniuk.seampleweather.data.retrofit.model

data class CityResponse(
	val rain: Rain,
	val visibility: Int,
	val timezone: Int,
	val main: Main,
	val clouds: Clouds,
	val sys: Sys,
	val dt: Int,
	val coord: Coord,
	val weather: List<WeatherItem>,
	val name: String,
	val cod: Int,
	val id: Int,
	val base: String,
	val wind: Wind
)

data class Coord(
	val lon: Double,
	val lat: Double
)

data class Wind(
	val deg: Int,
	val speed: Int
)

data class Clouds(
	val all: Int
)

data class Main(
	val temp: Double,
	val tempMin: Double,
	val humidity: Int,
	val pressure: Int,
	val feelsLike: Double,
	val tempMax: Double
)

data class WeatherItem(
	val icon: String,
	val description: String,
	val main: String,
	val id: Int
)

data class Sys(
	val country: String,
	val sunrise: Int,
	val sunset: Int,
	val id: Int,
	val type: Int
)

data class Rain(
	val jsonMember1h: Double
)

