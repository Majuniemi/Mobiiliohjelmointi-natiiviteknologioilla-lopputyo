package com.example.grade_five.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.grade_five.ui.theme.Grade_fiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Grade_fiveTheme {
                ScaffoldNavigationApp()
            }
        }
    }
}
