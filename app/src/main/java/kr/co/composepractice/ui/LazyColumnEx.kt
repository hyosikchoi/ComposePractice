package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LazyColumnEx : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /** RecyclerView 와 같이 사용 가능 */
            LazyColumn {
                /** item(직접 대입),items(List로 대입),itemsIndexed(List로 대입)등의 종류가 있다. */
                itemsIndexed(
                  (1..200).toList() // item 200개 생성
                ) { index , item ->
                    lazyColumnCard(order = item) // 위의 3개의 아이템을 이용하여 컴포저블 생성
                }
            }
        }
    }

    @Composable
    fun lazyColumnCard(order : Int) {
        Card(
            Modifier
                .padding(12.dp)
                .border(width = 4.dp, color = Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "LazyColumn $order")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun preView() {
        LazyColumn {
            itemsIndexed(
                (1..200).toList()
            ) { index , item ->
                lazyColumnCard(order = item)
            }
        }

    }

}