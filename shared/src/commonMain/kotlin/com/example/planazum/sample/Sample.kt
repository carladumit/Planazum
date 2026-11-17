package com.example.planazum.sample

import androidx.compose.ui.graphics.Color
import com.example.planazum.Event
import com.example.planazum.User
import com.example.planazum.theme.PlanazumBlue
import com.example.planazum.theme.PlanazumGreen
import com.example.planazum.theme.PlanazumPink
import com.example.planazum.theme.PlanazumSand
import kotlinx.datetime.LocalDateTime

object Sample {
    val eventList: List<Event> = listOf(
        Event(
            id = 1,
            user = "Ayuntamiento Castellon",
            name = "Festival música",
            place = "Plaza Mayor",
            address = "Plaza Mayor, 1",
            availableTickets = 11,
            price = 10.0,
            startTime = LocalDateTime(2026, 11, 15, 20, 0),
            endTime = LocalDateTime(2026, 11, 15, 23, 30),
            description = "Disfruta de la mejor música en directo en el corazón de la ciudad.",
            assistants = listOf(
                User(1, "Ana García", "ana@email.com", "password123"),
                User(2, "Carlos López", "carlos@email.com", "password123")
            )
        ),
        Event(
            id = 2,
            user = "Ayuntamiento Castellon",
            name = "Feria del Libro Antiguo",
            place = "Parque Ribalta",
            address = "Parque Ribalta",
            availableTickets = 50,
            price = 0.0,
            startTime = LocalDateTime(2026, 12, 22, 10, 30),
            endTime = LocalDateTime(2026, 12, 22, 20, 0),
            description = "Encuentra ejemplares únicos, ediciones descatalogadas y libros de coleccionista.",
            assistants = emptyList()
        ),
        Event(
            id = 3,
            user = "Club de Tenis Castellón",
            name = "Torneo Open Primavera",
            place = "Instalaciones Club de Tenis",
            address = "Avenida de Lledó",
            availableTickets = 4,
            price = 25.50,
            startTime = LocalDateTime(2026, 12, 2, 9, 0),
            endTime = LocalDateTime(2026, 12, 2, 18, 0),
            description = "Torneo abierto de tenis individual masculino y femenino.",
            assistants = listOf(
                User(3, "Pedro Martínez", "pedro@email.com", "password123")
            )
        ),
        Event(
            id = 4,
            user = "Asociación Juvenil",
            name = "Concierto Indie Rock",
            place = "Sala Opal",
            address = "Sala Opal",
            availableTickets = 0,
            price = 15.0,
            startTime = LocalDateTime(2026, 12, 10, 22, 0),
            endTime = LocalDateTime(2026, 12, 11, 2, 0),
            description = "Noche de música indie rock con las mejores bandas emergentes locales.",
            assistants = listOf(
                User(1, "Ana García", "ana@email.com", "password123"),
                User(4, "Lucía Pérez", "lucia@email.com", "password123"),
                User(5, "Marc Vila", "marc@email.com", "password123")
            )
        ),
        Event(
            id = 5,
            user = "Ayuntamiento Castellon",
            name = "Taller de Cerámica",
            place = "Centro Cultural La Beneficencia",
            address = "Centro Cultural La Beneficencia",
            availableTickets = 8,
            price = 0.0,
            startTime = LocalDateTime(2027, 1, 14, 17, 30),
            endTime = LocalDateTime(2027, 1, 14, 19, 30),
            description = "Aprende las técnicas básicas de la cerámica tradicional castellonense.",
            assistants = emptyList()
        ),
        Event(
            id = 6,
            user = "Teatro Principal",
            name = "Obra de Teatro Clásica",
            place = "Teatro Principal",
            address = "Calle de las Comedias",
            availableTickets = 30,
            price = 18.0,
            startTime = LocalDateTime(2027, 1, 20, 19, 0),
            endTime = LocalDateTime(2027, 1, 20, 21, 0),
            description = "Representación de una de las grandes obras maestras del teatro clásico.",
            assistants = listOf(
                User(2, "Carlos López", "carlos@email.com", "password123")
            )
        ),
        Event(
            id = 7,
            user = "Gastronomía Local",
            name = "Ruta de la Tapa",
            place = "Calles del Centro",
            address = "Zona Centro",
            availableTickets = 100,
            price = 5.0,
            startTime = LocalDateTime(2027, 2, 28, 13, 0),
            endTime = LocalDateTime(2027, 2, 28, 17, 0),
            description = "Degustación de las mejores tapas de los establecimientos asociados del centro.",
            assistants = emptyList()
        )
    )

    val colorList: List<Color> = listOf(PlanazumPink, PlanazumBlue, PlanazumGreen, PlanazumSand)

}