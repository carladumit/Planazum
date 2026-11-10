package com.example.planazum

import kotlinx.datetime.LocalDateTime


data class Event (
  var  user: String,
  var name : String,
  var  address: String,
  var  availableTickets: Int,
  var  price: Double,
  var dateTime: LocalDateTime

    ){
}