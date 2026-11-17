package com.example.planazum

import androidx.compose.ui.graphics.Color
import kotlinx.datetime.LocalDateTime


data class Event (
  var id: Long,
  var  user: String,
  var name : String,
  var place: String,
  var  address: String,
  var  availableTickets: Int,
  var  price: Double,
  var startTime: LocalDateTime,
  var endTime: LocalDateTime,
  var description: String,
  var assistants: List<User>
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