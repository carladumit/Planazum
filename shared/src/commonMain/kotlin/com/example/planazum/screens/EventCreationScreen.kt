package com.example.planazum.screens

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.planazum.components.InputField
import com.example.planazum.components.NavBar
import com.example.planazum.components.ShadowBox
import com.example.planazum.theme.PlanazumTheme


data class EventDraft(
    val name: String,
    val date: String,
    val time: String,
    val address: String,
    val place: String,
    val description: String
)

@Composable
fun EventCreationScreen(
    navController: NavHostController? = null,
    onCreateClick: (EventDraft) -> Unit = {},
) {
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var startTime by remember { mutableStateOf("") }
    var endTime by remember { mutableStateOf("") }
    var place by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var capacity by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val pink = MaterialTheme.colorScheme.primary
    val yellow = MaterialTheme.colorScheme.secondary

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(32.dp)
            .statusBarsPadding()
    ) {
        Text(
            text = "Crea un evento",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = yellow,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // PREVIEW DE LA CARD
            // GenerateEventCard()
            Row(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                Box(
                    modifier = Modifier
                        .width(110.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(8.dp))
                        .background(pink),
                    //.clickable(onClick = onPickPhoto),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Foto evento", fontSize = 14.sp, color = Color.White)
                }
            }

            Spacer(Modifier.height(20.dp))

            InputField(
                value = name, onValueChange = { name = it },
                label = "nombre de tu plan", placeholder = "Nombre",
                accent = yellow
            )
            Spacer(Modifier.height(16.dp))
            InputField(
                value = date, onValueChange = { date = it },
                label = "fecha", placeholder = "dd/mm/aaaa",
                keyboardType = KeyboardType.Number, accent = yellow
            )
            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                InputField(
                    value = startTime, onValueChange = {},
                    label = "hora inicio", placeholder = "hh:mm",
                    //accent = yellow, onClick = { showStartPicker = true },
                    keyboardType = KeyboardType.Number, accent = yellow,
                    modifier = Modifier.weight(1f)
                )
                InputField(
                    value = endTime, onValueChange = {},
                    label = "hora fin", placeholder = "hh:mm",
                    //accent = yellow, onClick = { showEndPicker = true },
                    keyboardType = KeyboardType.Number, accent = yellow,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(Modifier.height(16.dp))
            InputField(
                value = place, onValueChange = { place = it },
                label = "lugar", placeholder = "Ej: Plaza Mayor",
                accent = yellow
            )
            Spacer(Modifier.height(16.dp))
            InputField(
                value = address, onValueChange = { address = it },
                label = "dirección", placeholder = "Calle y número",
                accent = yellow
            )
            Spacer(Modifier.height(16.dp))
            InputField(
                value = capacity, onValueChange = { capacity = it },
                label = "plazas disponibles", placeholder = "número máximo de asistentes",
                accent = yellow
            )
            Spacer(Modifier.height(16.dp))
            InputField(
                value = description, onValueChange = { description = it },
                label = "descripción", placeholder = "Cuéntanos de qué va el plan",
                accent = yellow, multiline = true
            )

            Spacer(Modifier.height(28.dp))

            ShadowBox(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        if (name.isBlank() || date.isBlank() || startTime.isBlank() || place.isBlank()) {
                            message = "Indica al menos nombre, fecha, hora de inicio y lugar."
                        } else {
                            message = ""
                            onCreateClick(EventDraft(name, date, startTime, address, place, description))
                        }
                    }
            ) {
                Text(
                    text = "Crear evento",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 12.dp)
                )
            }

            if (message.isNotEmpty()) {
                Spacer(Modifier.height(12.dp))
                Text(
                    text = message,
                    fontSize = 14.sp,
                    color = pink,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Spacer(Modifier.height(24.dp))
        }
        NavBar(navController)
    }
}


@Preview(showBackground = true)
@Composable
fun EventCreationScreenPreview() {
    PlanazumTheme(darkTheme = false) { EventCreationScreen() }
}
