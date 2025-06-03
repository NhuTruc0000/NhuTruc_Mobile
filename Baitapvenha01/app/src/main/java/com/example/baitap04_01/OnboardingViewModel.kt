package com.example.baitap04_01

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel

class OnboardingViewModel : ViewModel() {
    var currentPage by mutableStateOf(0)
        private set

    fun nextPage() {
        if (currentPage < OnboardingData.pages.lastIndex) {
            currentPage = currentPage + 1
        }
    }

    fun previousPage() {
        if (currentPage > 0) {
            currentPage = currentPage - 1
        }
    }


    fun skip() {
        currentPage = OnboardingData.pages.lastIndex
    }
}
