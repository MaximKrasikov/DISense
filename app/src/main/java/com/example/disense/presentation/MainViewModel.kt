package com.example.disense.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.disense.domain.models.UserName
import com.example.disense.domain.usecase.GetUserNameUseCase
import com.example.disense.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase, private val saveUserNameUseCase: SaveUserNameUseCase ) : ViewModel() {

    private val resultLiveMutable= MutableLiveData<String>()
    val resultLive : LiveData<String> =  resultLiveMutable

    init{
        Log.e("AAA", "View model created")
    }

    fun save(text: String ){
        val params = com.example.disense.domain.models.SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(params = params)
        resultLiveMutable.value = "Save result = $resultData"
    }
    fun load(){
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}