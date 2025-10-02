package kr.co.fastcampus.part1.chapter3_13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.fastcampus.part1.chapter3_13.ui.theme.CheckBoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckBoxTheme {
                CheckBoxEx()
            }
        }
    }
}

@Composable
fun CheckBoxEx() {
    // mutableStateOf로 상태를 체크하고, remember를 사용해줘야함
    // composeable은 그리다가 새로 그려지면, 언제든 다시 그려질수있고, 상태가 날아갈수도 있기 때문에, remember를 사용해줘야함
    // mutableStateOf는 value와 property로 구성!
//    var checked by remember { mutableStateOf(false) }

    //스탭 1
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )
//
//        Text(
//            text = "프로그래머입니까?"
//        )
//    }


    //스탭 2
//    var checked by remember { mutableStateOf(false) }
//
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = it
//            }
//        )
//
//        Text(
//            text = "프로그래머입니까?",
//            modifier = Modifier.clickable {
//                checked = !checked
//            }
//        )
//    }

    //스탭 3 : destruction으로 상태받아서 사용하기
    var (checked, setChecked) = remember { mutableStateOf(false) }  // checked는 getter, setChecked는 setter에 해당하는값

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = {
                setChecked(!checked) // setChecked(it) 도 같은결과  //onCheckedChange = setChecked 도 같은결과
            }
        )

        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setChecked(!checked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CheckBoxTheme  {
        CheckBoxEx()
    }
}