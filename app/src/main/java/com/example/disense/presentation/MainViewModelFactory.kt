package com.example.disense.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.disense.domain.usecase.GetUserNameUseCase
import com.example.disense.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject


class MainViewModelFactory @Inject constructor(val getUserNameUseCase: GetUserNameUseCase, val saveUserNameUseCase: SaveUserNameUseCase)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase=getUserNameUseCase,saveUserNameUseCase=saveUserNameUseCase) as T
    }
}