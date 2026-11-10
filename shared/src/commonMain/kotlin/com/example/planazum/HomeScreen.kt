package com.example.planazum

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen() {
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
        )

    )

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn(//contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {

            items(eventList){ event ->

                GenerateEventCard(event)
            }


        }
    }
}



@Preview(showBackground = true)
@Composable
fun homeScreenPreview(){

    HomeScreen()
}