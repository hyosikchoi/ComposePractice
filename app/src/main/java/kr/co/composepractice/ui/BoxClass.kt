package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class BoxClass : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Preview(showBackground = true , widthDp = 120, heightDp = 200)
    @Composable
    fun boxPreView() {
          Box(
            // 내부 자식 위젯들의 Modifier에 align이 적용됬다면 여기서의 Alignment는 무시된다.
            contentAlignment = Alignment.BottomEnd

          ) {
             Text(modifier = Modifier.align(Alignment.TopStart), text = "Android")
             Text(modifier = Modifier.align(Alignment.Center), text = "JetPack")
             Text(modifier = Modifier.align(Alignment.BottomEnd), text = "Compose")
          }
    }

}