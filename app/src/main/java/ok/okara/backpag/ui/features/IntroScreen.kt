package ok.okara.backpag.ui.features

import android.graphics.LightingColorFilter
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.navArgument
import dev.burnoo.cokoin.navigation.getNavController
import ok.okara.backpag.R
import ok.okara.backpag.ui.theme.BackPagTheme
import ok.okara.backpag.ui.theme.BackgroundMain
import ok.okara.backpag.ui.theme.Blue
import ok.okara.backpag.ui.theme.CardViewBackground
import ok.okara.backpag.ui.theme.OnPictureBlur
import ok.okara.backpag.util.MyScreens

@Preview(showBackground = true)
@Composable
fun DefaultPreviewIntro() {

    BackPagTheme {
        Surface(
            color = BackgroundMain,
            modifier = Modifier.fillMaxSize()
        ) {

            IntroScreen()
        }
    }

}

@Composable
fun IntroScreen() {
    val navigation = getNavController()

    Image(
        colorFilter = ColorFilter.tint(OnPictureBlur, BlendMode.Darken ),
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.start_bild),
        contentDescription = MyScreens.IntroScreen.route,
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.9f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        Button(
            modifier = Modifier.fillMaxWidth(.7f),
            onClick = {

                navigation.navigate(MyScreens.SignInScreen.route)

            }
        ) {
            Text(text = "Sign in")
        }

        Button(
            modifier = Modifier.fillMaxWidth(.7f),
            colors = ButtonDefaults.buttonColors(CardViewBackground),
            onClick = { navigation.navigate(route = MyScreens.SignUpScreen.route) }
        ) {
            Text(text = "Sign on", color = Blue)

        }
    }
}