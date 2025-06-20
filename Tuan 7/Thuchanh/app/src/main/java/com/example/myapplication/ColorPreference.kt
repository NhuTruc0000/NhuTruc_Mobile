package com.example.myapplication

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

private val Context.dataStore by preferencesDataStore(name = "settings")

class ColorPreference(private val context: Context) {
    companion object {
        val COLOR_KEY = intPreferencesKey("background_color")
    }

    val selectedColor: Flow<Int> = context.dataStore.data
        .map { preferences -> preferences[COLOR_KEY] ?: 0xFFFFFFFF.toInt() } // Mặc định màu trắng

    suspend fun saveColor(color: Int) {
        context.dataStore.edit { preferences ->
            preferences[COLOR_KEY] = color
        }
    }
}
