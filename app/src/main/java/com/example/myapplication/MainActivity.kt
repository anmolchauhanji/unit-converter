package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    unitconverter(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun unitconverter(modifier: Modifier){

    var inputvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("meter") }
    var outputvalue by remember { mutableStateOf("") }
    var outputunit by remember { mutableStateOf("meter") }
    var coversion by remember { mutableStateOf(0.00) }
    var iexpand by remember { mutableStateOf(false) }
    var oexpand by remember { mutableStateOf(false) }
    val customstyle = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontSize = 36.sp,
        color = Color.Red
    )
    fun coversion(){
var inputvaluedouble = inputvalue.toDoubleOrNull() ?: 0.00
        var result = (inputvaluedouble * coversion * 100.0).roundToInt()/100.0
        outputvalue = result.toString()
    }

    Column (modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("unit converter",style =customstyle)

        Spacer(modifier=Modifier.height(100.dp))
        OutlinedTextField(value = inputvalue, onValueChange = {
            inputvalue=it
        },
            label = { Text("Enter value") })
        Spacer(modifier=Modifier.height(26.dp))
        Row() {
            Box {
                // Input button
                Button(onClick = { iexpand = true }) {
                    Text(text = inputunit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "dropdown menu")
                }
                DropdownMenu(expanded = iexpand, onDismissRequest = { iexpand = false }) {
                    DropdownMenuItem(
                        text = { Text("cm") },
                        onClick = {
                            iexpand = false
                            inputunit = "cm"
                            coversion = 0.01  // cm to meters
                            coversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("m") },
                        onClick = {
                            iexpand = false
                            inputunit = "m"
                            coversion = 1.0  // meters to meters
                            coversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("feet") },
                        onClick = {
                            iexpand = false
                            inputunit = "feet"
                            coversion = 0.3048  // feet to meters
                            coversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("millimeter") },
                        onClick = {
                            iexpand = false
                            inputunit = "millimeter"
                            coversion = 0.001  // millimeters to meters
                            coversion()
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.width(26.dp))

            Box {
                // Output button
                Button(onClick = { oexpand = true }) {
                    Text(text = outputunit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "dropdown menu")
                }
                DropdownMenu(expanded = oexpand, onDismissRequest = { oexpand = false }) {
                    DropdownMenuItem(
                        text = { Text("cm") },
                        onClick = {
                            oexpand = false
                            outputunit = "cm"
                            coversion = 100.0  // meters to cm
                            coversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("m") },
                        onClick = {
                            oexpand = false
                            outputunit = "m"
                            coversion = 1.0  // meters to meters
                            coversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("feet") },
                        onClick = {
                            oexpand = false
                            outputunit = "feet"
                            coversion = 3.28084  // meters to feet
                            coversion()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("millimeter") },
                        onClick = {
                            oexpand = false
                            outputunit = "millimeter"
                            coversion = 1000.0  // meters to millimeters
                            coversion()
                        }
                    )
                }
            }
        }

        Spacer(modifier=Modifier.height(16.dp))
        Text("result: $outputvalue $outputunit",style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun unitconverter() {
        unitconverter(modifier = Modifier)

}