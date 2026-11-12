package com.example.planazum

import androidx.compose.ui.graphics.Color
import kotlinx.datetime.LocalDateTime


data class Event (
  var  user: String,
  var name : String,
  var  address: String,
  var  availableTickets: Int,
  var  price: Double,
  var dateTime: LocalDateTime

    )

fun List<Event>.mapToUi(colorList: List<Color>): List<EventUi> {
  if (colorList.isEmpty()) return map { EventUi(event = it, color = Color.Gray) }

  return mapIndexed { index, event ->
    EventUi(
      event = event,
      color = colorList[index % colorList.size]
    )
  }
}