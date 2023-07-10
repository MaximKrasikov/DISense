package com.example.disense.presentation

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.disense.R
import com.example.disense.data.repository.UserRepositoryImpl
import com.example.disense.domain.models.SaveUserNameParam
import com.example.disense.domain.models.UserName
import com.example.disense.domain.usecase.GetUserNameUseCase
import com.example.disense.domain.usecase.SaveUserNameUseCase

class MainActivity : Activity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) { UserRepositoryImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acvtivity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataTextView.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(params = params)
            dataTextView.text = "Save result = $result"
        }
        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

    }

}