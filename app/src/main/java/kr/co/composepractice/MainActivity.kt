package kr.co.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import kr.co.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android","Compose")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, compose : String) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        val (textOne, textTwo) = createRefs()

        Text(
            text = name,
            modifier = Modifier.constrainAs(textOne) {
                top.linkTo(
                    parent.top
                )
                bottom.linkTo(
                    parent.bottom
                )
            } // top , bottom 을 parent에 맞춰서 vertical을 중간으로 맞춤.
        )

        Text(
            text = compose,
            modifier = Modifier.constrainAs(textTwo) {
                top.linkTo(
                    textOne.bottom,
                    margin = 10.dp
                ) // 해당 컨텐츠의 top 을 textOne의 bottom으로 그리고 margin 10dp 준다.
            }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Greeting("Android","Compose")
    }
}