package com.example.planazum.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.planazum.Event
import com.example.planazum.User
import com.example.planazum.components.GenerateEventCard
import com.example.planazum.components.NavBar
import com.example.planazum.components.ShadowBox
import com.example.planazum.mapToUi
import com.example.planazum.sample.Sample
import com.example.planazum.theme.PlanazumExtras
import com.example.planazum.theme.PlanazumTheme

@Composable
fun ProfileScreen(
    navController: NavHostController? = null,
    onEditProfile: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
    onAvatarClick: () -> Unit = {}
    //onEventClick: (EventDraft) -> Unit = {}
) {
    val events: List<Event> = Sample.eventList
    val uiEvents = events.mapToUi(Sample.colorList)
    val user: User = Sample.userList[0]
    val pink = MaterialTheme.colorScheme.primary
    val yellow = MaterialTheme.colorScheme.secondary

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(pink)
            .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
            .statusBarsPadding()
    ) {
        Text(
            text = "Perfil",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(12.dp)
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(6.dp)
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                .background(MaterialTheme.colorScheme.background),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = 16.dp,
                vertical = 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            item {
                Column (modifier = Modifier.fillMaxSize().padding(12.dp)) {
                    Row(modifier = Modifier.padding(vertical = 6.dp)) {
                        Avatar(
                            initials = "${user.name.firstOrNull() ?: ""}${user.lastName.firstOrNull() ?: ""}"
                                .uppercase(),
                            onClick = onAvatarClick
                        )
                        Column(
                            modifier = Modifier.padding(start = 14.dp)
                        ) {
                            Text(
                                text = "${user.name} ${user.lastName}",
                                fontSize = 20.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = "@${user.username}",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                            )
                        }
                    }

                    Row(modifier = Modifier.padding(vertical = 6.dp), horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .border(1.dp, yellow, RoundedCornerShape(10.dp))
                                .clickable(onClick = onEditProfile)
                                .padding(horizontal = 24.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Editar",
                                fontSize = 14.sp,
                                color = yellow
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .border(1.dp, pink, RoundedCornerShape(10.dp))
                                .clickable(onClick = onLogoutClick)
                                .padding(horizontal = 24.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Cerrar sesión",
                                fontSize = 14.sp,
                                color = pink
                            )
                        }
                    }
                }
            }

            item {
                ShadowBox {
                    Text(
                        text = "Eventos creados",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                Spacer(Modifier.height(10.dp).fillMaxWidth())
            }

            if (events.isEmpty()) {
                item {
                    Text(
                        text = "Aún no has creado ningún evento",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
            } else {
                items(uiEvents) { event ->
                    GenerateEventCard(event)
                }
            }
        }
        NavBar(navController)
    }
}

@Composable
private fun Avatar(
    initials: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(PlanazumExtras.colors.cards[4])
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initials,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    PlanazumTheme(darkTheme = false) {
        ProfileScreen()
    }
}