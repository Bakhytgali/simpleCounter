package com.example.justtesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.justtesting.ui.theme.JustTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Text(
            text = "The value is: $count",
            color = Color.White,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Buttons(
            addButton = {
                count++
            },
            reduceButton = {
                count--
            }
        )
    }
}

@Composable
fun Buttons(addButton: () -> Unit, reduceButton: () -> Unit) {
    Row (
        modifier = Modifier.padding(top = 15.dp)
            .width(200.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text (
            text = "Add",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Black)
                .padding(10.dp)
                .clickable {
                    addButton()
                }
        )
        Text (
            text = "Reduce",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.background(Color.Red)
                .padding(10.dp)
                .clickable {
                    reduceButton()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JustTestingTheme {
        Counter()
    }
}