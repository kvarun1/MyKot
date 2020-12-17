package com.mbinfo.repository


import com.mbinfo.network.RetrofitInstance

class AppRepository {

    suspend fun getPictures() = RetrofitInstance.picsumApi.getPictures()

   // suspend fun loginUser(body: RequestBodies.LoginBody) = RetrofitInstance.loginApi.loginUser(body)
}