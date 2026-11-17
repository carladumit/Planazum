package com.example.planazum.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.planazum.util.Screen
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.*

@Composable
fun NavBar(navController: NavHostController? = null){

    BottomAppBar(
        modifier = Modifier.fillMaxWidth().height(60.dp),
        containerColor = MaterialTheme.colorScheme.background,

        actions = {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        navController?.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    }
                ) {
                    Box {
                        Image(
                            painter = painterResource(Res.drawable.home),
                            contentDescription = "HomeButton"
                        )
                    }
                }
                IconButton(
                    onClick = {
                        navController?.navigate(Screen.MyEvents.route) {
                            popUpTo(Screen.MyEvents.route) { inclusive = true }
                        }
                    }
                ) {
                    Box {
                        Image(
                            painter = painterResource(Res.drawable.list),
                            contentDescription = "ViewEvents"
                        )
                    }
                }
                IconButton(
                    onClick = {
                        navController?.navigate(Screen.CreateEvent.route) {
                            popUpTo(Screen.CreateEvent.route) { inclusive = true }
                        }
                    }
                ) {
                    Box {
                        Image(
                            painter = painterResource(Res.drawable.cross),
                            contentDescription = "ViewEvents"
                        )
                    }
                }
                    IconButton(
                        onClick = {
                            navController?.navigate(Screen.Profile.route) {
                                popUpTo(Screen.Profile.route) { inclusive = true }
                            }
                        }
                    ) {
                        Box {
                            Image(
                                painter = painterResource(Res.drawable.profile),
                                contentDescription = "ViewEvents"
                            )
                        }
                    }
                }

        }
    )
}

@Preview
@Composable
fun NavBarPreview(){
    NavBar()
}
