package com.mbinfo.network




import com.mbinfo.oumodel.Example
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface API {
    @Headers("Authorization: Bearer X0vjEUN6KRlxbp2DoUkyHeM0VOmxY91rA6BbU5j3Xu6wDodwS0McmilLPBWDUcJ1")
    @GET("1761/icons?count=10")
    suspend fun getPictures(): Response<Example>


}