package com.example.planazum


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.planazum.Sample.Sample

import org.jetbrains.compose.resources.painterResource
import planazum.shared.generated.resources.Res
import planazum.shared.generated.resources.filterIcon
import planazum.shared.generated.resources.glass



@Composable
fun HomeScreen() {
    val eventList = Sample.eventList

    val uiEventList = eventList.mapToUi(Sample.colorList)

    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        SearchBar(searchText,
            onValueChange = {newText ->
                searchText = newText
            })
        Row(modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically){
            FilterButton("Musica")
            FilterButton("Deportes")
            FilterButton("Arte & Cultura")
            Box () {
                Image(
                    painter = painterResource(Res.drawable.filterIcon),
                    contentDescription = "Filter Icon",
                )
            }
        }

        LazyColumn(modifier = Modifier.weight(1f)
            ) {
            items(uiEventList){ uiEvent ->
                GenerateEventCard(uiEvent)
            }


        }
        Column(verticalArrangement = Arrangement.Bottom){
            NavBar()
        }
    }

}

@Composable
fun FilterButton(filter: String){
    Button(onClick = {},
        modifier = Modifier
            .heightIn(min=20.dp),
       shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        border = BorderStroke(1.5.dp, Color(0xFFE58E94)),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 3.dp)){

        Text(text = filter,
            style = MaterialTheme.typography.bodyMedium)
    }

}

@Composable
fun SearchBar(value: String,
              onValueChange:(String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {Image(painter = painterResource(Res.drawable.glass), contentDescription = null)},
        singleLine = true,
        shape = RoundedCornerShape(9.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(28.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color(0xFFE7B2AD),
            unfocusedBorderColor = Color(0xFFE7B2AD),
            cursorColor = Color(0xFFE7B2AD)
        )

    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen()
}