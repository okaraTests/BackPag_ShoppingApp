package ok.okara.backpag.ui.features

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ok.okara.backpag.ui.theme.BackPagTheme
import ok.okara.backpag.ui.theme.BackgroundMain

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){

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
    TODO("Not yet implemented")
}