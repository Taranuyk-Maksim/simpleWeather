package com.taraniuk.seampleweather.data.retrofit.api

import com.taraniuk.seampleweather.data.retrofit.model.CityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenWeatherApi {

    @GET("weather")
    suspend fun getWeatherDataInSetCity(
        @Header("x-rapidapi-host") headerHost: String,
        @Header("x-rapidapi-key") headerKey: String,
        @Query("q") city : String
    ) : CityResponse

  //  img/w/01n.png

//    @GET("img/w/{id}.png")
//    suspend fun getSunImage(
//        @Header("x-rapidapi-host") headerHost: String,
//        @Header("x-rapidapi-key") headerKey: String,
//        @Path("id") imageId : String
//    ) : CityResponse

//    @GET("/user/starred/{owner}/{repo}")
//    fun isStaredRepository(
//        @Header("Authorization") auth: String,
//        @Path("owner") owner: String,
//        @Path("repo") repo: String
//    ): Single<Response<Void>>
}