package com.example.planazum.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planazum.EventUi
import com.example.planazum.components.ShadowBox
import com.example.planazum.components.toSpanishString
import com.example.planazum.sample.Sample
import com.example.planazum.theme.*
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.placeholder

@Composable
fun EventDetailScreen(
    onBackClick: () -> Unit = {},
    onJoinClick: () -> Unit = {},
    onBuyClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    val eventUi = EventUi(Sample.eventList[2], color = PlanazumBlue)
    val event = eventUi.event
    val eventColor = eventUi.color
    val isLoggedIn = false

    val startTime = "${event.startTime.hour.toString().padStart(2, '0')}:" +
            event.startTime.minute.toString().padStart(2, '0')
    val endTime = "${event.endTime.hour.toString().padStart(2, '0')}:" +
            event.endTime.minute.toString().padStart(2, '0')
    val date = event.startTime.toSpanishString()
    val place = event.place
    val address = event.address
    val description = event.description
    val isFree = event.price == 0.0
    val soldOut = event.availableTickets <= 0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(eventColor)
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "←",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.clickable(onClick = onBackClick)
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = "Detalle del evento",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(6.dp)
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.placeholder),
                contentDescription = "Cartel del evento",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = event.name,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Organizado por @${event.user}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(Modifier.height(24.dp))

            Column {
                InfoRow(text = date, icon = { Text("📅", fontSize = 16.sp) })
                InfoRow(text = "${startTime} - ${endTime}", icon = { Text("🕑", fontSize = 16.sp) })
                InfoRow(
                    text = "${place} | ${address}",
                    icon = { Text("📍", fontSize = 16.sp) }
                )
                InfoRow(
                    text = description,
                    icon = { }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .border(1.dp, eventColor, RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    text = "Inscripción",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(eventColor)
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Column(
                    modifier = Modifier.padding(16.dp),
                ) {
                    Text(
                        text = if (isFree) "Entrada gratuita" else "Entrada ${event.price.toInt()}€",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = if (soldOut) "Entradas agotadas" else "¡Quedan ${event.availableTickets} entradas!",
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(Modifier.height(20.dp))

                    when {
                        !isLoggedIn -> {
                            Text(
                                text = "Inicia sesión para unirte al evento.",
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(Modifier.height(16.dp))
                            ActionButton("Iniciar sesión", eventColor, onLoginClick)
                        }

                        soldOut -> ActionButton("Agotado", Color.Gray, onClick = null)

                        isFree -> ActionButton("Inscribirme", eventColor, onJoinClick)

                        else -> ActionButton("Comprar entrada", eventColor, onBuyClick)
                    }
                }
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
private fun InfoRow(
    text: String,
    icon: @Composable () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(20.dp), contentAlignment = Alignment.Center) {
                icon()
            }
            Spacer(Modifier.width(12.dp))
            Text(
                text = text,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.12f))
        )
    }
}


@Composable
private fun ActionButton(
    text: String,
    color: Color,
    onClick: (() -> Unit)?
) {
    ShadowBox(
        color = color,
        shadowColor = if (onClick != null) MaterialTheme.colorScheme.secondary else Color.LightGray,
        modifier = if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailLoggedInPreview() {
    PlanazumTheme(darkTheme = false) {
        EventDetailScreen()
    }
}
