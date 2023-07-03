package ok.okara.backpag.util

sealed class MyScreens(val route: String){
    object MainScreen: MyScreens("mainScreen")
    object ProductScreen: MyScreens("productScreen")
    object SearchScreen: MyScreens("SearchScreen")
    object CategoryScreen: MyScreens("categoryScreen")
    object ProfileScreen: MyScreens("profileScreen")
    object CartScreen: MyScreens("cartScreen")
    object SignUpScreen: MyScreens("signupScreen")
    object SignInScreen: MyScreens("signInScreen")
    object IntroScreen: MyScreens("introScreen")
    object NoInternetScreen: MyScreens("noInternetScreen")
}
