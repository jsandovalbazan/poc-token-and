package pro.jsandoval.poctoken.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.jsandoval.poctoken.R
import pro.jsandoval.poctoken.presentation.theme.PoCTokenTheme

@Composable
fun MaintenanceScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Image(painter = painterResource(id = R.drawable.ic_login_image), contentDescription = "Main Image")
        Spacer(modifier = Modifier.padding(20.dp))

        Text(
            text = stringResource(id = R.string.app_in_maintenance),
            fontSize = 22.sp,
            color = Color.Red,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MaintenanceScreenPreview() {
    PoCTokenTheme {
        MaintenanceScreen()
    }
}