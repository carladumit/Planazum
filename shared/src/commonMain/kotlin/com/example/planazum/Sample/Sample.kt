package com.example.planazum.Sample

import androidx.compose.ui.graphics.Color
import com.example.planazum.Event
import kotlinx.datetime.LocalDateTime

object Sample {
    val eventList: List<Event> = listOf(
        Event(
            id=1,
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            address = "Plaza Mayor, 1",
            availableTickets = 11,
            price = 10.0,
            dateTime = LocalDateTime(2026, 11, 15, 20, 0)
        ),
        Event(
            id = 2,
            user = "Ayuntamiento Castellon",
            name = "Feria del Libro Antiguo",
            address = "Parque Ribalta",
            availableTickets = 50,
            price = 0.0,
            dateTime = LocalDateTime(2026, 12, 22, 10, 30)
        ),
        Event(
            id = 3,
            user = "Club de Tenis Castellón",
            name = "Torneo Open Primavera",
            address = "Avenida de Lledó",
            availableTickets = 4,
            price = 25.50,
            dateTime = LocalDateTime(2026, 12, 2, 9, 0)
        ),
        Event(
            id = 4,
            user = "Asociación Juvenil",
            name = "Concierto Indie Rock",
            address = "Sala Opal",
            availableTickets = 0,
            price = 15.0,
            dateTime = LocalDateTime(2026, 12, 10, 22, 0)
        ),
        Event(
            id = 5,
            user = "Ayuntamiento Castellon",
            name = "Taller de Cerámica",
            address = "Centro Cultural La Beneficencia",
            availableTickets = 8,
            price = 0.0,
            dateTime = LocalDateTime(2027, 1, 14, 17, 30)
        ),
        Event(
            id = 6,
            user = "Teatro Principal",
            name = "Obra de Teatro Clásica",
            address = "Calle de las Comedias",
            availableTickets = 30,
            price = 18.0,
            dateTime = LocalDateTime(2027, 1, 20, 19, 0)
        ),
        Event(
            id = 7,
            user = "Gastronomía Local",
            name = "Ruta de la Tapa",
            address = "Zona Centro",
            availableTickets = 100,
            price = 5.0,
            dateTime = LocalDateTime(2027, 2, 28, 13, 0)
        ))

    val colorList: List<Color> = listOf(Color(0xFFE58E94), Color(0xFF96C1DD),Color(0xFFA7BE2A), Color(0xFFD7B995))

}