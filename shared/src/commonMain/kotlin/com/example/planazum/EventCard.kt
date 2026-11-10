package com.example.planazum

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.placeholder

@Composable
fun GenerateEventCard(event: Event) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(374.dp)
                .height(190.dp)
                .background(
                    color = Color(0xFFE58E94),
                    shape = RoundedCornerShape(size = 9.dp)
                )
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = event.name,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(153.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 9.dp,
                            bottomEnd = 9.dp
                        )
                        )
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .width(90.dp)
                                .fillMaxHeight()
                                .background(
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(6.dp)
                                )
                        ) {
                            Image(
                        contentDescription = "imagen",
                        painter = painterResource(Res.drawable.placeholder),
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds)
                        }


                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(vertical = 2.dp),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {
                                Text(
                                    text = "@${event.user}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = event.address,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                                Text(
                                    text = "Lunes 30 Abril",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "08:00PM",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }

                            Spacer(modifier = Modifier.size(25.dp))

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box (modifier = Modifier.background(color = Color(0xFFEBBA36))
                                .offset(x= 3.dp, y = (-3).dp))
                            {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFFE58E94),
                                        )
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "ENTRADA ${event.price.toInt()}€",
                                        color = Color.White,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                }
                            }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "¡quedan ${event.availableTickets} entradas!",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.Black,
                                    modifier = Modifier.align(Alignment.End)
                                )
                            }
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
        Event(
            user = "AyuntamientoCastellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10000000.0,
        ))
}