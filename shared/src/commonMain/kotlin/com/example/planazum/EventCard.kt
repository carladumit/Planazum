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
import kotlinx.datetime.LocalDateTime
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.placeholder

@Composable
fun GenerateEventCard(eventUi: EventUi,) {
    val time = "${eventUi.event.dateTime.hour.toString().padStart(2, '0')}:${eventUi.event.dateTime.minute.toString().padStart(2, '0')}"
    val date = eventUi.event.dateTime.toSpanishString()

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
                    color = eventUi.color,
                    shape = RoundedCornerShape(size = 9.dp)
                )
                .padding(5.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = eventUi.event.name,
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
                                    text = "@${eventUi.event.user}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = eventUi.event.address,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.Gray
                                )
                                Text(
                                    text = time,
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = date,
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
                                            color = eventUi.color,
                                        )
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = if (eventUi.event.price == 0.0) "ENTRADA GRATUITA" else "ENTRADA ${eventUi.event.price.toInt()}€",
                                        color = Color.White,
                                        style = MaterialTheme.typography.labelMedium
                                    )
                                }
                            }

                                Spacer(modifier = Modifier.height(2.dp))

                                Text(
                                    text = "¡quedan ${eventUi.event.availableTickets} entradas!",
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


private val spanishMonths = listOf(
    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
)

fun LocalDateTime.toSpanishString(): String {
    val mesNombre = spanishMonths[this.month.ordinal]
    return "${this.dayOfMonth} de $mesNombre"
}



@Preview(showBackground = true)
@Composable
fun Preview(){
    GenerateEventCard(
        EventUi(Event(
            user = "AyuntamientoCastellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 0.0,
            dateTime = LocalDateTime(2026, 5, 28, 13, 0)),
         color = Color(0xFFE58E94)))
}