package ok.okara.backpag

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ok.okara.backpag.ui.theme.BackPagTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackPagTheme {
                BackPagStore()
            }
        }
    }
}

@Composable
fun BackPagStore(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = ""){

        composable("mainScreen"){
            MainScreen()
        }

        composable(route ="productScreen",
            arguments = listOf(navArgument("productId"){
                type = NavType.IntType
            })){
            ProductScreen(it.arguments!!.getInt("productId", -1))
        }

        composable(
            route = "categoryScreen",
            arguments = listOf(navArgument("categoryName"){
                type = NavType.StringType
            })
            ){
            CategoryScreen(it.arguments!!.getString("categoryName", "null"))
        }

        composable("profileScreen"){
            ProfileScreen()
        }

        composable("cartScreen"){
            CartScreen()
        }

        composable("signInScreen"){
            SignInScreen()
        }

        composable("introScreen"){
            IntroScreen()
        }

        composable("noInternetScreen"){
            NoInternetScreen()
        }
    }
}

@Composable
fun NoInternetScreen() {
    TODO("Not yet implemented")
}

@Composable
fun IntroScreen() {
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