package com.example.planazum.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planazum.theme.PlanazumExtras

@Composable
fun PreviewEventCard(
    name: String,
    date: String,
    time: String,
    place: String,
    //description: String,
    modifier: Modifier = Modifier,
) {
    val onCard = PlanazumExtras.colors.onCard

    @Composable
    fun Line(text: String, placeholder: String, size: Int, bold: Boolean = false, maxLines: Int = 1) {
        val empty = text.isBlank()
        Text(
            text = if (empty) placeholder else text,
            fontSize = size.sp,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal,
            color = if (empty) onCard.copy(alpha = 0.5f) else onCard,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
            .border(2.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp))
            .padding(10.dp)
    ) {
        Line(name, "Nombre del plan", 16, bold = true, maxLines = 2)
        Spacer(Modifier.height(6.dp))
        Line(
            text = listOf(date, time).filter { it.isNotBlank() }.joinToString(" · "),
            placeholder = "Fecha · Hora",
            size = 12
        )
        Line(place, "Lugar", 12)
    }
}