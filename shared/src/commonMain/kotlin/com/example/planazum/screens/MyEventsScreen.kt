package com.example.planazum.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planazum.sample.Sample
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import androidx.compose.foundation.lazy.items
import androidx.navigation.NavHostController
import com.example.planazum.EventUi
import com.example.planazum.components.GenerateEventCard
import com.example.planazum.components.NavBar
import com.example.planazum.mapToUi
import com.example.planazum.util.toSpanishName

@Composable
fun MyEventsScreen(navController: NavHostController? = null){

    val events = Sample.eventList.mapToUi(Sample.colorList)
    Column (modifier = Modifier.fillMaxSize()){

        val groupedEvents: Map<String, List<EventUi>> = remember(events) {
            events.sortedBy { it.event.dateTime }
                .groupBy { event -> getSectionTitle(event.event.dateTime) }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp).weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            item {
                Text(
                    text = "Tus Planazums",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            groupedEvents.forEach { (sectionTitle, sectionEvents) ->
                item(key = sectionTitle) {
                    SectionBanner(title = sectionTitle)
                }

                items(
                    items = sectionEvents,
                    key = { it.event.id }
                ) { eventUI ->
                    GenerateEventCard(eventUi = eventUI)
                }
            }
        }

        Column(verticalArrangement = Arrangement.Bottom){
            NavBar(navController)
        }
    }


}


fun getSectionTitle(eventDate: LocalDateTime): String{
    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    val targetDate = eventDate.date

    val daysDifference = today.daysUntil(targetDate)
    return if (daysDifference in 0..7){
        "Próximos 7 días"
    } else {
        targetDate.month.toSpanishName()
    }
}


@Composable
fun SectionBanner(title:String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .background(Color(0xFFE5B822))
                .padding(horizontal = 48.dp, vertical = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyEventsScreenPreview(){

    MyEventsScreen()
}

