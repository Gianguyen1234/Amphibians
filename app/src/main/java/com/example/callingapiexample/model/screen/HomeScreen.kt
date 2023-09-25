package com.example.callingapiexample.model.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.callingapiexample.R
import com.example.callingapiexample.model.AmphibiansData
import com.example.callingapiexample.ui.theme.CallingApiExampleTheme

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
) {
    when(amphibiansUiState){

        is AmphibiansUiState.Loading -> {
            LoadingScreen(modifier = modifier)
        }
        is AmphibiansUiState.Success -> {
            /*for (amphibian in amphibiansUiState.photo) {
                AmphibiansCard(amphibian, modifier)
            }*/
            ListAmphibiansCard(amphibians = amphibiansUiState.amphibians, modifier = modifier)

        }

        else  -> {
            ErrorScreen(modifier = modifier)
        }
    }
   
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading),
        contentDescription = "Loading"
    )
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.broken),
            contentDescription = "",
            contentScale = ContentScale.Fit
        )
        Text(text = "Error now", modifier = Modifier.padding(16.dp))

    }
}

@Composable
fun AmphibianCard(amphibian: AmphibiansData, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            // Display name and type together
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = amphibian.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = " (${amphibian.type})",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                        fontSize = 16.sp
                    )
                )
            }
            // Load and display the image
            AsyncImage(
                model = ImageRequest
                    .Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.broken),
                placeholder = painterResource(id = R.drawable.loading),
                contentDescription = stringResource(id = R.string.amphibian_photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            // Display description
            Text(
                text = amphibian.description,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
@Composable
private fun ListAmphibiansCard(amphibians: List<AmphibiansData>, modifier: Modifier = Modifier){
    
    LazyColumn {
        items(amphibians) { amphibian ->
            AmphibianCard(
                amphibian = amphibian,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = modifier.padding(horizontal = 16.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListAmphibiansCardPreview(){
    CallingApiExampleTheme {

        val mockData = List(10){AmphibiansData("$it", "", "","")}
        ListAmphibiansCard(mockData)

    }
}






