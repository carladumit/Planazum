package com.example.planazum.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavHostController
import com.example.planazum.EventUi
import com.example.planazum.components.GenerateEventCard
import com.example.planazum.components.NavBar
import com.example.planazum.mapToUi
import com.example.planazum.theme.PlanazumYellow
import com.example.planazum.util.toSpanishName
import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.planazum_logo

@Composable
fun MyEventsScreen(navController: NavHostController? = null){

    val events = Sample.eventList.mapToUi(Sample.colorList)
    Column (modifier = Modifier.fillMaxSize()
        .padding(top = 20.dp)){

        val groupedEvents: Map<String, List<EventUi>> = remember(events) {
            events.sortedBy { it.event.startTime }
                .groupBy { event -> getSectionTitle(event.event.startTime) }
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = "Tus ",
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )

            Box(modifier = Modifier.height(20.dp).width(100.dp)){
                Image(painter = painterResource(Res.drawable.planazum_logo),
                    contentDescription = "Logo App",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds)
                }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp).weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
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
                .background(PlanazumYellow)
                .padding(horizontal = 48.dp, vertical = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyEventsScreenPreview(){

    MyEventsScreen()
}

