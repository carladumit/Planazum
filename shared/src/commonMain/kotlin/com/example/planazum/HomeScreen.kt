package com.example.planazum


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.datetime.LocalDateTime
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.filterIcon


@Composable
fun HomeScreen() {
    val colorList: List<Color> = listOf(Color(0xFFE58E94), Color(0xFF96C1DD),Color(0xFFA7BE2A), Color(0xFFD7B995))


    val eventList: List<Event> = listOf(
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "Plaza Mayor, 1",
            availableTickets = 11,
            price = 10.0,
            dateTime = LocalDateTime(2026, 4, 15, 20, 0)
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Feria del Libro Antiguo",
            address = "Parque Ribalta",
            availableTickets = 50,
            price = 0.0,
            dateTime = LocalDateTime(2026, 4, 22, 10, 30)
        ),
        Event(
            user = "Club de Tenis Castellón",
            name = "Torneo Open Primavera",
            address = "Avenida de Lledó",
            availableTickets = 4,
            price = 25.50,
            dateTime = LocalDateTime(2026, 5, 2, 9, 0)
        ),
        Event(
            user = "Asociación Juvenil",
            name = "Concierto Indie Rock",
            address = "Sala Opal",
            availableTickets = 0, // Entradas agotadas
            price = 15.0,
            dateTime = LocalDateTime(2026, 5, 10, 22, 0)
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Taller de Cerámica",
            address = "Centro Cultural La Beneficencia",
            availableTickets = 8,
            price = 0.0, // Se mostrará como GRATUITA
            dateTime = LocalDateTime(2026, 5, 14, 17, 30)
        ),
        Event(
            user = "Teatro Principal",
            name = "Obra de Teatro Clásica",
            address = "Calle de las Comedias",
            availableTickets = 30,
            price = 18.0,
            dateTime = LocalDateTime(2026, 5, 20, 19, 0)
        ),
        Event(
            user = "Gastronomía Local",
            name = "Ruta de la Tapa",
            address = "Zona Centro",
            availableTickets = 100,
            price = 5.0,
            dateTime = LocalDateTime(2026, 5, 28, 13, 0)
        )

    )

    val uiEventList = eventList.mapIndexed { index, event ->
        EventUi(
            event = event,
            color = colorList[index % colorList.size]
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically){
            filterButton("Musica")
            filterButton("Deportes")
            filterButton("Arte & Cultura")
            Box () {
                Image(
                    painter = painterResource(Res.drawable.filterIcon),
                    contentDescription = "Filter Icon",

                )
            }
        }

        LazyColumn(
            ) {

            items(uiEventList){ uiEvent ->

                GenerateEventCard(uiEvent.event, color = uiEvent.color)


            }


        }
    }
}

@Composable
fun filterButton(filter: String){
    Button(onClick = {},
        modifier = Modifier
            .heightIn(min=20.dp),
       shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        border = BorderStroke(1.5.dp, Color(0xFFE58E94)),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 3.dp)){

        Text(text = filter,
            style = MaterialTheme.typography.bodyMedium)
    }

}

@Composable
fun searchBar(){
 // WIP
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen()
}