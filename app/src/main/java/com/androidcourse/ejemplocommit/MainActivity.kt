package com.androidcourse.ejemplocommit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.androidcourse.ejemplocommit.ui.theme.EjemploCommitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploCommitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploCommitTheme {
        LazyRowEjemplo()
    }
}

@Composable
fun LazyColumnEjemplo(){
    LazyColumn { // Una lista colmna larga
        items(5) { index -> // Funcion Lambda, se ejecuta sobre cada elemento
            // Establecemos la separacon de 5 dp para cada elemento
            Text("Ejempl $index", modifier = Modifier.padding(5.dp))
        }
    }
}

@Composable
fun LazyRowEjemplo() {
    // Una lista horizontal, ideal para carruseles o elementos desplazados en horizontal
    // según la cantidad de "items" que elijamos
    LazyRow {
        items(10) { index ->

            Box(
                modifier = Modifier
                    .size(
                        width = 80.dp,
                        height = 40.dp
                    )
                    .background(Color.Blue)
                    .padding(8.dp)
            ) {
                Text(
                    text = "LzRow $index",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }
    }
}


@Composable
fun GridEjemplo(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(15) { index -> // Expresion Lambda
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.DarkGray)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Grid $index", color = Color.White
                )
            }
        }
    }
}

