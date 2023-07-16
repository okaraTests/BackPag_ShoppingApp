package ok.okara.backpag.di

import ok.okara.backpag.ui.features.signIn.SignInViewModel
import ok.okara.backpag.ui.features.signUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModules = module {
    viewModel {
        SignUpViewModel()
    }
    viewModel {
        SignInViewModel()
    }
}