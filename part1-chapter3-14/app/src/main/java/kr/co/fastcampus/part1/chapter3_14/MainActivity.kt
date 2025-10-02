package kr.co.fastcampus.part1.chapter3_14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.fastcampus.part1.chapter3_14.ui.theme.TextFieldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldTheme {
                Gretting()
            }
        }
    }
}

@Composable
fun Gretting() {
    // 스탭 1
    // TextField를 Text위에 만들어보자
    // 이땐 TextField에 입력이 되지않음
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(value = "Tom", onValueChange = {})
//
//        Text(text = "Hello Android")
//    }

    // 스탭 2
    // Text에 TextField의 입력을 출력시켜보자
//    var name by remember { mutableStateOf("Tom") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(value = name, onValueChange = {name = it})
//
//        Text(text = "Hello $name")
//    }


    // 스탭 3
    // TextField에 lable 추가해보기 (설명느낌)
//    var name by remember { mutableStateOf("Tom") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(value = name,
//            label = {
//                Text("이름")
//            },
//            onValueChange = {name = it}
//        )
//
//        Spacer(modifier = Modifier.size(8.dp))
//
//        Text(text = "Hello $name")
//    }


    // 스탭 4
    // OutlinedTextField 사용해보기
    var name by remember { mutableStateOf("Tom") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(value = name,
            label = {
                Text("이름")
            },
            onValueChange = {name = it}
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(text = "Hello $name")
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextFieldTheme  {
        Gretting()
    }
}