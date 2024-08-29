package com.example.plantidentifier

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.google.ai.client.generativeai.GenerativeModel

class PlantIdentifierViewModel : ViewModel() {
    var imageUri by mutableStateOf<Uri?>(null)
        private set

    var identificationResult by mutableStateOf<String?>(null)
        private set
    var reponse by mutableStateOf<String?>(null)
        private set
    fun onImageCaptured(uri: Uri) {
        imageUri = uri
        // Clear previous result when new image is captured
        identificationResult = null
    }

    fun identifyPlant() {
        viewModelScope.launch {
            val generativeModel =
                GenerativeModel(
                    // Specify a Gemini model appropriate for your use case
                    modelName = "gemini-1.5-flash",
                    // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                    apiKey = build.key)
            // This is where you'd call the Gemini SDK for plant identification
            // For now, we'll just set a placeholder result
            val prompt = "Write a story about a magic backpack."
             val response = generativeModel.generateContent(prompt)
            identificationResult = response.text
        }
    }
}
