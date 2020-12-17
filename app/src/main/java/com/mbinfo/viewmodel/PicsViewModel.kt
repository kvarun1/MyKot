package com.mbinfo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hadi.retrofitmvvm.util.Resource
import com.hadi.retrofitmvvm.util.Utils.hasInternetConnection

import com.mbinfo.app.MyApplication


import com.mbinfo.mykot.R
import com.mbinfo.oumodel.Example
import com.mbinfo.repository.AppRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class PicsViewModel(
    app: Application,
    private val appRepository: AppRepository
) : AndroidViewModel(app) {

    val picsData: MutableLiveData<Resource<Example>> = MutableLiveData()

    init {
        getPictures()
    }

    fun getPictures() = viewModelScope.launch {
        fetchPics()
    }


    private suspend fun fetchPics() {
        picsData.postValue(Resource.Loading())
        try {
            if (hasInternetConnection(getApplication<MyApplication>())) {
                val response = appRepository.getPictures()
                picsData.postValue(handleExample(response))
            } else {
                picsData.postValue(Resource.Error(getApplication<MyApplication>().getString(R.string.no_internet_connection)))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> picsData.postValue(
                    Resource.Error(
                        getApplication<MyApplication>().getString(
                            R.string.network_failure
                        )
                    )
                )
                else -> picsData.postValue(
                    Resource.Error(
                        getApplication<MyApplication>().getString(
                            R.string.conversion_error
                        )
                    )
                )
            }
        }
    }

    private fun handleExample(response: Response<Example>): Resource<Example> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


}