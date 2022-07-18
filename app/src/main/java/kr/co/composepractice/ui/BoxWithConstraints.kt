package kr.co.composepractice.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class BoxWithConstraints : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Preview(showBackground = true, widthDp = 200 , heightDp = 230)
    @Composable
    fun boxWithConstraints() {
        /** BoxWithConstraints 의 사용 장점중 가장 큰 장점은 */
        /** Flip 이나 Fold 등과 같은 동적인 Layout이 필요할 때 Box의 크기에 따라 다른 화면을 내보내도록 할 수 있다. */
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            if(this.minHeight > 220.dp) {
                Text(modifier = Modifier.align(Alignment.CenterStart), text = "Larger than 220dp")
            }
            Text(modifier = Modifier.align(Alignment.BottomStart) , text= "minHeight : ${this.minHeight}")
        }
    }

}