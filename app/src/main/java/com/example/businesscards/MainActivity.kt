package com.example.businesscards


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.businesscards.ui.theme.BusinessCardsTheme


import com.example.businesscards.ui.theme.BusinessCardsTheme


data class BusinessCard(
    val name: String,
    val title: String,
    val phone: String,
    val email: String,
    val color: Color,
    val imageRes: Int
)


class MainActivity: ComponentActivity(){


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            BusinessCardsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF6291DB) //light blue background
                ){
                    BusinessCardScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessCardScreen(){
    val cards = listOf(
        BusinessCard("John Smith", "Business man", "905 123 4567", "johnsmith@live.com", Color(
            0xFFAF74E6), R.drawable.wave),
        BusinessCard("Chuck Norris", "Actor", "905 123 4567", "chucknorris@live.com", Color(
            0xFF4164E0
        ), R.drawable.wave),
        BusinessCard(
            name = "Emily Johnson",
            title = "UI/UX Designer",
            phone = "555-8765",
            email = "emily.johnson@example.com",
            Color(0xFF3CAF28),
            R.drawable.wave
        ),
        BusinessCard(
            name = "Ever Who",
            title = "Black Smith",
            phone = "456-1234",
            email = "bs@example.com",
            Color(0xFFbede00),
            R.drawable.wave
        ),


        )


    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize()){
            TopAppBar(
                title = {Text ("Business Cards")},
                colors =  TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
            )
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(cards) {
                        card -> BusinessCardItem(card)
                }


            }
        }


        FloatingActionButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            containerColor = Color.White,
            contentColor = Color.Black
        ){
            Icon(Icons.Default.Add, contentDescription = "Add Card")


        }
    }
}




@Composable
fun BusinessCardItem(card: BusinessCard){


    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = card.color)
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    Text(card.name, fontWeight = FontWeight.Bold, color = Color.Black)
                    Text(card.title, color = Color.Black.copy(alpha = 0.8f))
                }
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color.White
                )


            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(card.phone, color = Color.Black)
            Text(card.email, color = Color.Black)
        }
    }


}


@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview(){
    BusinessCardsTheme{
        BusinessCardScreen()
    }
}
