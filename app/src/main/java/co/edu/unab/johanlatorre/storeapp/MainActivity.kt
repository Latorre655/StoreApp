package co.edu.unab.johanlatorre.storeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.unab.johanlatorre.storeapp.ui.theme.StoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoreAppTheme {

                val myNavController = rememberNavController()
                val myStartDestination: String = "login"

                NavHost(
                    navController = myNavController,
                    startDestination = myStartDestination,
                ) {
                    composable("login") {
                        LoginScreen(onClickRegister = {
                            myNavController.navigate("register")
                        }, onSuccessfulLogin = {
                            myNavController.navigate("home"){
                                popUpTo("login"){inclusive = true}
                            }
                        })
                    }
                    composable("register") {
                        RegisterScreen(onClickBack = {
                            myNavController.popBackStack()
                        })
                    }
                    composable("home") {
                        HomeScreen()
                    }
                }
            }
        }
    }
}


