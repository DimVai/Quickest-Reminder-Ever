package com.example.quickestreminderever

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val reminderManager = ReminderManager(application)

    var reminderText by mutableStateOf("Υπενθύμιση")
    var showSuccess by mutableStateOf(false)
    var shouldExit by mutableStateOf(false)

    fun onDurationSelected(millis: Long) {
        reminderManager.scheduleReminder(reminderText, millis)
        
        viewModelScope.launch {
            showSuccess = true
            delay(300)
            shouldExit = true
        }
    }
}
