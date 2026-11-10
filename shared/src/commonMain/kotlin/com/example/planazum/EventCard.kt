package com.example.planazum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.placeholder

@Composable
fun GenerateEventCard(eventName:String) {

    Box(
        modifier = Modifier
            .width(374.dp)
            .height(190.dp)
            .background(
                color = Color(0xFFE58E94),
                shape = RoundedCornerShape(size = 9.dp)
            ),
        contentAlignment = Alignment.BottomCenter
    ) {

        (Text(
            text = eventName,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 10.dp, y = 10.dp),
            color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(150.dp)
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 9.dp,
                            bottomEnd = 9.dp
                        )
                    )
            ) {

            Column {
                Row() {
                    Image(
                        contentDescription = "imagen",
                        painter = painterResource(Res.drawable.placeholder),
                        modifier = Modifier
                            .height(146.dp)
                            .width(103.dp)
                            .padding(8.dp),
                        contentScale = ContentScale.FillBounds
                    )

                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = "@Ayuntamiento Castellón")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Palacio de la musica")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Lunes 30 Abril")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "08:00PM")
                        Spacer(modifier = Modifier.height(4.dp))

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,

                        ) {

                            Spacer(modifier = Modifier.height(8.dp))

                            Box (modifier = Modifier.background(color = Color(0xFFEBBA36))
                                .offset(x= 5.dp, y = (-5).dp))
                            {
                                Box(
                                    modifier = Modifier
                                        .background(color = Color(0xFFE58E94))
                                        .padding(horizontal = 10.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                        text = "ENTRADA 10000€",
                                        color = Color.White,
                                    )
                                }
                            }

                            Text(
                                text = "¡quedan 4 entradas!",
                                color = Color.Black,
                                modifier = Modifier.offset(x= 56.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    GenerateEventCard(
        eventName = "Festival musical")
}