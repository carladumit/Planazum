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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.*

@Composable
fun NavBar(){
    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 30.dp),
        containerColor = Color.White,

        actions={
            Row(modifier = Modifier.fillMaxWidth()
                .background(color = Color.White),

                horizontalArrangement = Arrangement.SpaceBetween){
            IconButton(onClick = {}){
                Box(){
                    Image(painter = painterResource(Res.drawable.home),
                        contentDescription = "HomeButton")
                }
            }
            IconButton (onClick = {}){
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



@Preview(showBackground = true)
@Composable
fun NavBarPreview(){
    NavBar()
}