package ok.okara.backpag.ui.features.signIn


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import dev.burnoo.cokoin.Koin
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.viewmodel.getViewModel
import ok.okara.backpag.R
import ok.okara.backpag.di.myModules
import ok.okara.backpag.ui.theme.BackPagTheme
import ok.okara.backpag.ui.theme.BackgroundMain
import ok.okara.backpag.ui.theme.Blue
import ok.okara.backpag.util.MyScreens

/*
* setz die Viewmodel Injektion und Ui controller auseinander
* optimiere die PreviewFuntion*/
@Composable
fun SignInScreen() {
    val navController = getNavController()
    Koin(appDeclaration = { modules(myModules) }) {
        val viewModel = getViewModel<SignInViewModel>()
        Box {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.4f)
                    .background(Blue)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconApp()
                MainCardView(viewModel = viewModel, navigation= navController) {
                    viewModel.signInUser()
                }
            }
        }
    }
}

@Composable
fun IconApp() {
    Surface(
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
    ) {
        Image(
            modifier = Modifier.padding(14.dp),
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = "App Icon"
        )
    }
}

@Composable
fun MainCardView(
    viewModel: SignInViewModel,
    navigation: NavController,
    SignUpEvent: () -> Unit) {

    val email = viewModel.email.observeAsState("")
    val password = viewModel.password.observeAsState("")

    Koin(appDeclaration = {modules(myModules)}) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            shape = Shapes().medium
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Sign Up",
                    modifier = Modifier.padding(top = 18.dp, bottom = 18.dp),
                    style = TextStyle(color = Blue, fontSize = 28.sp, fontWeight = FontWeight.Bold)
                )

                MainTextField(
                    edtValue = email.value,
                    icon = R.drawable.email_icon,
                    hint = "Your E-Mail Address",
                    keyboardType = KeyboardType.Email
                ) { viewModel.email.value = it }
                PasswordTextField(
                    edtValue = password.value,
                    icon = R.drawable.password_icon,
                    hint = "set a strong Password"
                ) { viewModel.password.value = it }

                Button(
                    onClick = SignUpEvent,
                    modifier = Modifier.padding(top = 28.dp, bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(Blue),
                    shape = Shapes().small
                ) {
                    Text(
                        text = "Log in",
                        modifier = Modifier.wrapContentSize()
                    )
                }

                Row(
                    modifier = Modifier.padding(bottom = 18.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "Don't have an account?")
                    Spacer(modifier = Modifier.padding(4.dp))
                    TextButton(
                        onClick = { navigation.navigate(MyScreens.SignUpScreen.route){
                            popUpTo(MyScreens.SignInScreen.route){
                                inclusive = true
                            }
                        }
                        }
                    ) {
                        Text(
                            color = Blue,
                            text = "Sign up!"
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    edtValue: String,
    icon: Int,
    hint: String,
    onValueChanges: (String) -> Unit
) {
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = edtValue,
        onValueChange = onValueChanges,
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(top = 8.dp)
            .padding(horizontal = 12.dp),
        label = { Text(hint) },
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "on textField icon",
                modifier = Modifier.size(25.dp)
            )
        },
        singleLine = true,
        shape = Shapes().extraSmall,
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image =
                if (passwordVisible.value) painterResource(id = R.drawable.disabled_eye_icon)
                else painterResource(id = R.drawable.eye_icon)
            Icon(painter = image, contentDescription = "show Password",
                modifier = Modifier.clickable { passwordVisible.value = !passwordVisible.value }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTextField(
    edtValue: String,
    icon: Int,
    hint: String,
    keyboardType: KeyboardType,
    onValueChanges: (String) -> Unit
) {

    OutlinedTextField(
        value = edtValue,
        onValueChange = onValueChanges,
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .padding(top = 8.dp)
            .padding(horizontal = 12.dp),
        label = { Text(hint) },
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "on textField icon",
                modifier = Modifier.size(25.dp)
            )
        },
        singleLine = true,
        shape = Shapes().extraSmall,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {

    BackPagTheme {
        Surface(
            color = BackgroundMain,
            modifier = Modifier.fillMaxSize()
        ) {

        }
    }

}