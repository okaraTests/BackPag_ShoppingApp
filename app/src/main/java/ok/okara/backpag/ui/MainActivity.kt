package ok.okara.backpag.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ok.okara.backpag.ui.features.IntroScreen
import ok.okara.backpag.ui.theme.BackPagTheme
import ok.okara.backpag.ui.theme.BackgroundMain
import ok.okara.backpag.util.KEY_CATEGORY_ARG
import ok.okara.backpag.util.KEY_PRODUCT_ARG
import ok.okara.backpag.util.MyScreens


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackPagTheme {
                Surface(
                    color = BackgroundMain,
                    modifier = Modifier.fillMaxSize()
                ) {
                    BackPagStore()
                }
            }
        }
    }
}

@Composable
fun BackPagStore() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MyScreens.IntroScreen.route
    ) {

        composable(MyScreens.MainScreen.route) {
            MainScreen()
        }

        composable(route = "${MyScreens.ProductScreen.route}/$KEY_PRODUCT_ARG",
            arguments = listOf(navArgument("productId") {
            type = NavType.IntType
        })) {
            ProductScreen(it.arguments!!.getInt("productId", -1))
        }

        composable(
            route = "${MyScreens.CategoryScreen.route}/$KEY_CATEGORY_ARG",
            arguments = listOf(navArgument(MyScreens.CategoryScreen.route) {
                type = NavType.StringType
            })
        ) {
            CategoryScreen(it.arguments!!.getString("categoryName", "null: no Value"))
        }

        composable(MyScreens.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(MyScreens.CartScreen.route) {
            CartScreen()
        }

        composable(MyScreens.SignInScreen.route) {
            SignInScreen()
        }

        composable(MyScreens.IntroScreen.route) {
            IntroScreen()
        }

        composable(MyScreens.NoInternetScreen.route) {
            NoInternetScreen()
        }
    }
}

@Composable
fun NoInternetScreen() {
    TODO("Not yet implemented")
}

@Composable
fun SignInScreen() {
    TODO("Not yet implemented")
}

@Composable
fun CartScreen() {
    TODO("Not yet implemented")
}

@Composable
fun ProfileScreen() {
    TODO("Not yet implemented")
}

@Composable
fun CategoryScreen(categoryName: String) {
    TODO("Not yet implemented")
}

@Composable
fun ProductScreen(productId: Int) {
    TODO("Not yet implemented")
}

@Composable
fun MainScreen() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BackPagStore()
}