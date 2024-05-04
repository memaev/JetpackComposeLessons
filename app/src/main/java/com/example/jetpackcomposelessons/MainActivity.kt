package com.example.jetpackcomposelessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposelessons.ui.theme.JetpackComposeLessonsTheme

enum class AuthState {
    LOGIN, REGISTER
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeLessonsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent2()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    var loginState by remember { mutableStateOf(AuthState.LOGIN) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.drink_img),
            contentDescription = "login image",
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(15.dp))
                .padding(top = 40.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        if (loginState == AuthState.REGISTER) {
            Text(
                text = "Registration",
                modifier = Modifier
                    .background(Color.Red, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
            )
        } else {
            Text(
                text = "Login",
                modifier = Modifier
                    .background(Color.Green, shape = RoundedCornerShape(5.dp))
                    .padding(10.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            loginState = when (loginState) {
                AuthState.LOGIN -> AuthState.REGISTER
                AuthState.REGISTER -> AuthState.LOGIN
            }
        }) {
            Text(
                text = loginState.name
            )
        }
    }
}

@Composable
fun MainContent2(
    mainViewModel: MainActivityViewModel = viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = mainViewModel.counterState.toString()
            )
            Button(onClick = {
                mainViewModel.incrementCounter()
            }, modifier = Modifier.padding(10.dp)) {
                Text(text = "Increment")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeLessonsTheme {
        MainContent2()
    }
}