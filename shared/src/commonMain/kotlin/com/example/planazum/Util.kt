package com.example.planazum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.datetime.Month
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.*

@Composable
fun NavBar(navController: NavHostController){

    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 30.dp),
        containerColor = Color.White,

        actions={
            Row(modifier = Modifier.fillMaxWidth()
                .background(color = Color.White),

                horizontalArrangement = Arrangement.SpaceBetween){
            IconButton(onClick = {
                navController.navigate(Screen.Home.route){
                    popUpTo(Screen.Home.route){inclusive = true}
                }
            }){
                Box(){
                    Image(painter = painterResource(Res.drawable.home),
                        contentDescription = "HomeButton")
                }
            }
            IconButton (onClick = {
                navController.navigate(Screen.MyEvents.route){
                    popUpTo(Screen.MyEvents.route){inclusive = true}}
            }){
                Box(){
                    Image(painter = painterResource(Res.drawable.list),
                        contentDescription = "ViewEvents")
                }
            }
            IconButton (onClick = {}){
                Box(){
                    Image(painter = painterResource(Res.drawable.cross),
                        contentDescription = "ViewEvents")
                }
            }
            IconButton (onClick = {}){
                Box(){
                    Image(painter = painterResource(Res.drawable.profile),
                        contentDescription = "ViewEvents")
                }
            }
        }
        }

    )

}


fun Month.toSpanishName(): String = when (this) {
    Month.JANUARY -> "Enero"
    Month.FEBRUARY -> "Febrero"
    Month.MARCH -> "Marzo"
    Month.APRIL -> "Abril"
    Month.MAY -> "Mayo"
    Month.JUNE -> "Junio"
    Month.JULY -> "Julio"
    Month.AUGUST -> "Agosto"
    Month.SEPTEMBER -> "Septiembre"
    Month.OCTOBER -> "Octubre"
    Month.NOVEMBER -> "Noviembre"
    Month.DECEMBER -> "Diciembre"
}



