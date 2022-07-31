package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class ColumnList : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState() // ScrollState에 대한 remember
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(scrollState) // Column에 ScrollState 설정
            ) {
                for (i in 0..50) {
                    composeCard(order = i)
                }
            }
        }
        /** 하지만 이런 방식은 RecyclerView 처럼 화면상 보이는 List만 그리는게 아닌 전체를 그린다. */
        /** 그러므로 컴포저블이 100개 혹은 1000개와같이 많아진다면 OOM,ANR 이 발생할 수 있다. */
        /** 간단한 View나 10개 이내 자식 컴포저블을 만들 때 효율적이다. */
    }

    @Composable
    fun composeCard(order : Int) {
        Card(
            Modifier
                .padding(12.dp)
                .border(width = 2.dp, color = Color.Blue)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("Compose $order")
            }
        }
    }

    @Preview(showBackground = true , widthDp = 200 , heightDp = 200)
    @Composable
    fun preView() {
        Column(
            Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            for (i in 0..50) {
                composeCard(order = i)
            }
        }
    }

}