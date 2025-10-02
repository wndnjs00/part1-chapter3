package kr.co.fastcampus.part1.chapter3_16

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.fastcampus.part1.chapter3_16.ui.theme.SlotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlotTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SlotEx()
                }
            }
        }
    }
}

// 스텝 1: `Row`를 `@Composable` 함수로 분리하자. (공통된 부분은 함수로 묶어서 처리하자)
// `checked`의 값, `Text`의 `text`를 인자로 전달하자
//@Composable
//fun CheckboxWithText(checked: MutableState<Boolean>, text: String){
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
//    }
//}


// 스텝 2: `@Composable` 함수에서 `@Composable () -> Unit` 타입으로
// `content`를 받아옵시다. `Row`의 `Text`를 뺴고 `content()`를 넣읍시다.
// `Row`에 `Modifier.clickable`를 넣어 전체를 클릭가능하게 합시다.

//@Composable
//fun CheckboxWithText(checked: MutableState<Boolean>, content: @Composable () -> Unit){
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable{
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}


// 스텝 3: `content`의 타입을 `@Composable RowScope.() -> Unit`로
// 바꿉시다. 이렇게 다른 콤포저블 컨텐트를 넣는 방식을 Slot API라 합니다.
// 저렇게 넣어주면, SlotEx()에 Text옆에 modifier같은 콤포저블 컨텐트 넣기가능
//@Composable
//fun CheckboxWithText(checked: MutableState<Boolean>, content: @Composable RowScope.() -> Unit){
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable{
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        content()
//    }
//}



// 스텝 4: 상태를 바꾸는 람다를 `@Composable` 함수의 인자로 뺍시다.
// 인자에서 MutableState대신 boolean 값으로 변경합시다.
// 상태가 바뀌는것은 외부로 위임하자!  // onCheckedChanged: () -> Unit 를 써서
@Composable
fun CheckboxWithText(
    checked: Boolean,
    onCheckedChanged: () -> Unit,
    content: @Composable RowScope.() -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable{
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
        content()
    }
}



@Composable
fun SlotEx() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
//        CheckboxWithText(checked1, {Text("Text1")})
//        CheckboxWithText(checked1) {
//            Text("Text1")
//        } //위에랑 같은거

//        CheckboxWithText(checked2, {Text("Text2")})
//        CheckboxWithText(checked2) {
//            Text("Text2", modifier = Modifier.weight(1f))
//        } //위에랑 같은거

        CheckboxWithText(
            checked = checked1,
            onCheckedChanged = {checked1 = !checked1}) {
            Text("Text1")
        }

        CheckboxWithText(
            checked = checked2,
            onCheckedChanged = {checked2 = !checked2}) {
            Text("Text2", modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotTheme {
        SlotEx()
    }
}