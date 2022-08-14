package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class SnackBar  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // SnackBar 를 사용하기 위해서는 Scaffold를 사용하여 감싸고 내부에서 버튼을 눌렀을 때 text를 참조해서
            // snackBar를 생성하는 방식으로 만든다.
            // Scaffold 란 Material Component 들을 편하게 사용할 수 있도록 하기 위해 미리 디자인된 레이아웃이다.
            kotlinSnackBar(lifecycleScope = lifecycleScope)
        }

    }

    @Composable
    fun kotlinSnackBar(lifecycleScope : CoroutineScope) {

        val scaffoldState = rememberScaffoldState()

        var textState by remember {
            mutableStateOf("")
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                TextField(value = textState, onValueChange = {textValue -> textState = textValue})
                Spacer(modifier = Modifier.size(12.dp))
                Button(onClick = {
                    /** showSnackbar 메서드는 suspend fun 이므로 coroutineScope 내부에서 호출 되야 한다. */
                    lifecycleScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("textState : $textState")
                    }
                }) {
                    Text(text = "Show SnackBar")
                }
            }
        }

    }

}