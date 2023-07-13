package com.example.disense.presentation
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.disense.R
import com.example.disense.data.repository.UserRepositoryImpl
import com.example.disense.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.disense.domain.models.UserName
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint


//https://dagger.dev/hilt/
//https://developer.android.com/training/dependency-injection/hilt-android
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm : MainViewModel by viewModels() // предоставление vieModel через Hilt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acvtivity_main)


        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }
        receiveButton.setOnClickListener {
            vm.load()
        }

    }

}