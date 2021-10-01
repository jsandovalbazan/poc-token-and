package pro.jsandoval.poctoken.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import pro.jsandoval.poctoken.R
import pro.jsandoval.poctoken.presentation.theme.Green
import pro.jsandoval.poctoken.presentation.theme.PoCTokenTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PoCTokenTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        backgroundColor = Color.White
    ) {

        val viewModel = hiltViewModel<MainViewModel>()
        val viewState by remember(viewModel) { viewModel.getAccessToken() }.collectAsState(initial = MainViewState.Idle)

        MainScaffold(viewState = viewState)
    }
}

@Composable
fun MainScaffold(viewState: MainViewState) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(painter = painterResource(id = R.drawable.ic_login_image), contentDescription = "Main Image")
        Spacer(modifier = Modifier.padding(20.dp))
        when (viewState) {
            is MainViewState.Loading -> LoadingIndicator()
            is MainViewState.Loaded -> TokenObtainedText(viewState.accessToken)
            is MainViewState.Error -> TokenErrorText(viewState.message)
        }

    }
}

@Composable
fun TokenObtainedText(accessToken: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Token obtained successfully", color = Green)
        Text(text = accessToken, color = Color.Blue)
    }
}

@Composable
fun TokenErrorText(message: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Error obtained token: ", color = Color.Red)
        Text(text = message)
    }
}

@Composable
fun LoadingIndicator() {
    CircularProgressIndicator()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PoCTokenTheme {
        MainScreen()
    }
}