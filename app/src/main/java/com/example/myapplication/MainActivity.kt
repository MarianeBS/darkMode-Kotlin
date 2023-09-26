package com.example.myapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.components.ButtonIcon
import com.example.myapplication.components.ButtonNormal
import com.example.myapplication.components.ButtonNormal2
import com.example.myapplication.components.ButtonOutline
import com.example.myapplication.components.ButtonSwitch
import com.example.myapplication.components.ButtonText
import com.example.myapplication.components.DarkMode
import com.example.myapplication.components.FloatingAction
import com.example.myapplication.components.Space
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = remember { mutableStateOf(false) }
            MyApplicationTheme(darkTheme = darkMode.value) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  Content(darkMode = darkMode)
                }
            }
        }
    }
}

@Composable
fun Content(darkMode: MutableState<Boolean>) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DarkMode(darkMode = darkMode)
        Space()
        ButtonNormal2()
        Space()
        ButtonNormal()
        Space()
        ButtonOutline()
        Space()
        ButtonText()
        Space()
        ButtonIcon()
        Space()
        ButtonSwitch()
        Space()
        FloatingAction()
        Space()
    }
}

@Composable
fun DarkMode(darkMode: MutableState<Boolean>) {
    Button(onClick = { darkMode.value = !darkMode.value}) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "DarkMode")
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Dark Mode", fontSize = 30.sp)
    }
}