package com.example.planazum


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
    val colorList: List<Color> = listOf(Color(0xFFE58E94), Color(0xFF96C1DD),Color(0xFFA7BE2A), Color(0xFFD7B995))


    val eventList: List<Event> = listOf(
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10.0,
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10.0,
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10.0,
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10.0,
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10.0,
        ),
        Event(
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "La direccion",
            availableTickets = 11,
            price = 10.0,
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

        LazyColumn(
            ) {

            items(uiEventList){ uiEvent ->

                GenerateEventCard(uiEvent.event, color = uiEvent.color)


            }


        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen()
}