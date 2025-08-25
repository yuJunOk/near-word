package com.nearword.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.nearword.app.ui.MyNavigationBar
import com.nearword.app.ui.theme.DemoChatComposeTheme

class MainActivity : ComponentActivity() {

     var selectedTab by mutableIntStateOf(0)
    // var selectedTab  by remember { mutableIntStateOf(0) }   // ✅ 状态持久

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoChatComposeTheme {
                Column {
                    MyNavigationBar(selectedTab) {
                        selectedTab = it
                    }
                }
            }
        }
    }
}