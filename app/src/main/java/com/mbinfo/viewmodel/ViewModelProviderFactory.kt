package com.mbinfo.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbinfo.repository.AppRepository


class ViewModelProviderFactory(
    val app: Application,
    val appRepository: AppRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PicsViewModel::class.java)) {
            return PicsViewModel(app, appRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}