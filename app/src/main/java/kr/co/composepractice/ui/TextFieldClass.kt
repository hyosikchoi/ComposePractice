package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class TextFieldClass : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            textField()
        }

    }

    @Composable
    fun textField() {
        val textState = remember {
            mutableStateOf("")
        }

        val anotherTextState = remember {
            mutableStateOf("")
        }

        BoxWithConstraints(
            modifier = Modifier.fillMaxSize(),
        ) {
            TextField(modifier = Modifier.align(Alignment.Center), value = textState.value, onValueChange = { textValue -> textState.value = textValue} )
            TextField(modifier = Modifier.align(Alignment.BottomStart), value = anotherTextState.value, onValueChange = { textValue -> anotherTextState.value = textValue} )
        }

    }

}