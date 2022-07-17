package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Column : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ColumnCompose()
                }
        }
    }

    @Composable
    fun ColumnCompose() {
        // 더 다양한 속성은 https://kotlinworld.com/178?category=973270#verticalArrangement 에서 참고
        Column(
            modifier = Modifier.fillMaxWidth().height(120.dp) ,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Hi")
            Text(text = "Hi")
            Text(text = "Hi")
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreView() {
        ColumnCompose()
    }

}