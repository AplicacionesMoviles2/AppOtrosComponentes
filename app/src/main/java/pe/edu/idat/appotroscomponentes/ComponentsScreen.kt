package pe.edu.idat.appotroscomponentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EjemploRadioButton(nombre: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            RadioButton(selected = nombre == "Hombre", onClick = { onItemSelected("Hombre") })
            Text(text = "Hombre", Modifier.padding(top = 10.dp))
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            RadioButton(selected = nombre == "Mujer", onClick = { onItemSelected("Mujer") })
            Text(text = "Mujer", Modifier.padding(top = 10.dp))
        }
    }

}


@Composable
fun EjemploDropDown() {
    var item by rememberSaveable {
        mutableStateOf("")
    }
    var expandir by rememberSaveable {
        mutableStateOf(false)
    }
    val paises = listOf("Perú", "Uruguay", "Brasil", "Colombia", "Ecuador")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(value = item, onValueChange = { item = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expandir = true }
                .fillMaxWidth(),
            leadingIcon = { Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Llamar") }
        )
        DropdownMenu(
            expanded = expandir,
            onDismissRequest = { expandir = false },
            Modifier
                .background(Color.White)
                .fillMaxWidth()
        ) {
            paises.forEach { pais ->
                DropdownMenuItem(text = { Text(text = pais) },
                    onClick = {
                        expandir = false
                        item = pais
                    }, Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun EjemploRangeSlider() {
    var rango by remember {
        mutableStateOf(0f..10f)
    }
    Column(Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            value = rango, onValueChange = { rango = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "El valor inferior ${rango.start}")
        Text(text = "El valor superio ${rango.endInclusive}")
    }
}


@Composable
fun EjemploSlider2() {
    Column(
        Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var posicion by rememberSaveable {
            mutableFloatStateOf(0f)
        }
        Slider(
            value = posicion, onValueChange = { posicion = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = posicion.toString())
    }
}


@Composable
fun EjemploSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var posicion by rememberSaveable {
            mutableFloatStateOf(0f)
        }
        Slider(value = posicion, onValueChange = { posicion = it })
        Text(text = posicion.toString())
    }
}


@Composable
fun EjemploCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .size(width = 240.dp, height = 100.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Magenta
        ),
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Column(Modifier.padding(15.dp)) {
            Text(text = "Móviles 2")
            Text(text = "Móviles 2")
            Text(text = "Móviles 2")
            Text(text = "Móviles 2")
        }
    }
}

@Composable
fun EjemploDivider() {
    Divider(
        Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        color = Color.Blue
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemploBadgeBox() {
    BadgedBox(badge = {

        Badge(
            containerColor = Color.Red,
            contentColor = Color.Black
        ) {
            Text(text = "100")
        }

    }, Modifier.padding(30.dp)) {
        Icon(Icons.Filled.Call, contentDescription = "Llamar")
    }
}