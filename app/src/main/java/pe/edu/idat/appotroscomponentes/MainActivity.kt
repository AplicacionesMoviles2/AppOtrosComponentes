package pe.edu.idat.appotroscomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.appotroscomponentes.ui.theme.AppOtrosComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppOtrosComponentesTheme {
                Column(
                    Modifier
                        .padding(top = 28.dp)
                        .fillMaxSize()) {
                    var nombre by rememberSaveable {
                        mutableStateOf("")
                    }
                    EjemploBadgeBox()
                    EjemploDivider()
                    EjemploCard()
                    EjemploDivider()
                    EjemploSlider()
                    EjemploDivider()
                    EjemploSlider2()
                    EjemploDivider()
                    EjemploRangeSlider()
                    EjemploDivider()
                    EjemploDropDown()
                    EjemploDivider()
                    EjemploRadioButton(nombre) { nombre = it }

                }

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppOtrosComponentesTheme {
    }
}