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

    val userList: List<User> = listOf(
        User(
            id = 1,
            username = "anagarcia",
            name = "Ana",
            lastName = "García",
            email = "ana@email.com",
            password = "password123"
        ),
        User(
            id = 2,
            username = "carloslopez",
            name = "Carlos",
            lastName = "López",
            email = "carlos@email.com",
            password = "password123"
        ),
        User(
            id = 3,
            username = "pedromartinez",
            name = "Pedro",
            lastName = "Martínez",
            email = "pedro@email.com",
            password = "password123"
        ),
        User(
            id = 4,
            username = "luciaperez",
            name = "Lucía",
            lastName = "Pérez",
            email = "lucia@email.com",
            password = "password123"
        )
    )
    val eventList: List<Event> = listOf(
        Event(
            id = 1,
            user = "AyuntamientoCastellon",
            name = "Festival música",
            place = "Plaza Mayor",
            address = "Plaza Mayor, 1",
            availableTickets = 11,
            price = 10.0,
            startTime = LocalDateTime(2026, 11, 15, 20, 0),
            endTime = LocalDateTime(2026, 11, 15, 23, 30),
            description = "Disfruta de la mejor música en directo en el corazón de la ciudad.",
            assistants = listOf(userList[0], userList[1])
        ),
        Event(
            id = 2,
            user = "AyuntamientoCastellon",
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
            user = "ClubTenisCs",
            name = "Torneo Open Primavera",
            place = "Instalaciones Club de Tenis",
            address = "Avenida de Lledó, 24",
            availableTickets = 4,
            price = 25.50,
            startTime = LocalDateTime(2026, 12, 2, 9, 0),
            endTime = LocalDateTime(2026, 12, 2, 18, 0),
            description = "Torneo abierto de tenis individual masculino y femenino.",
            assistants = listOf(
                userList[2]
            )
        ),
        Event(
            id = 4,
            user = "AsociaciónJuvenil",
            name = "Concierto Indie Rock",
            place = "Sala Opal",
            address = "Calle Viena s/n",
            availableTickets = 0,
            price = 15.0,
            startTime = LocalDateTime(2026, 12, 10, 22, 0),
            endTime = LocalDateTime(2026, 12, 11, 2, 0),
            description = "Noche de música indie rock con las mejores bandas emergentes locales.",
            assistants = listOf(userList[1],userList[3],userList[4])
        ),
        Event(
            id = 5,
            user = "AyuntamientoCastellon",
            name = "Taller de Cerámica",
            place = "Centro Cultural La Beneficencia",
            address = "Av. Valencia, 13",
            availableTickets = 8,
            price = 0.0,
            startTime = LocalDateTime(2027, 1, 14, 17, 30),
            endTime = LocalDateTime(2027, 1, 14, 19, 30),
            description = "Aprende las técnicas básicas de la cerámica tradicional castellonense.",
            assistants = emptyList()
        ),
        Event(
            id = 6,
            user = "TeatroPrincipal",
            name = "Obra de Teatro Clásica",
            place = "Teatro Principal",
            address = "Plaza la Paz, 1",
            availableTickets = 30,
            price = 18.0,
            startTime = LocalDateTime(2027, 1, 20, 19, 0),
            endTime = LocalDateTime(2027, 1, 20, 21, 0),
            description = "Representación de una de las grandes obras maestras del teatro clásico.",
            assistants = listOf(userList[2])
        ),
        Event(
            id = 7,
            user = "GastronomíaLocal",
            name = "Ruta de la Tapa",
            place = "Calles del Centro",
            address = "Plaza Santa Clara",
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