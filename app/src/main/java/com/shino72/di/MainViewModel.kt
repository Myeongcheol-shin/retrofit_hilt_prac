package com.shino72.di

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CatRepository): ViewModel(){
    var catData = MutableLiveData<String>("응답 없음")

    fun getData() = catData

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val data = repository.getCat("1")
            when (data.isSuccessful) {
                true -> {
                    if(data.body() != null) catData.postValue(data.body()!![0].url)
                }
                false -> {
                    catData.postValue("응답 없음")
                }
            }
        }
    }
}