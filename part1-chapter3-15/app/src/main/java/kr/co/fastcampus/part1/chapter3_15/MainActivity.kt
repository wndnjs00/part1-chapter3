package kr.co.fastcampus.part1.chapter3_15

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.fastcampus.part1.chapter3_15.ui.theme.TopAppBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopAppBarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopBarEx("Android")
                }
            }
        }
    }
}

@Composable
fun TopBarEx(name: String) {
    Column {
        // 스텝 1: TopAppBar를 만들어보자
//        TopAppBar(title = {
//            Text("TopAppBar")
//        })

        // 스텝 2
        // 백 icon도 넣어보자
        // navigationIcon 파라미터를 채워보자
//        TopAppBar(
//            title = { Text("TopAppBar")},
//            navigationIcon = {
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "이전 아이콘"
//                    )
//                }
//            }
//        )


        // 스텝 3: actions를 추가해보자
        // Icons.Filled의 여러 아이콘을 이용해보자
        // 스탭 4보다 이 형식을 쓰는게 더 좋음
//        TopAppBar(
//            title = { Text("TopAppBar")},
//            navigationIcon = {
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "이전 아이콘"
//                    )
//                }
//            },
//            actions = {
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.Search,
//                        contentDescription = "검색 아이콘"
//                    )
//                }
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.Settings,
//                        contentDescription = "설정 아이콘"
//                    )
//                }
//                IconButton(onClick = {}) {
//                    Icon(
//                        imageVector = Icons.Filled.AccountBox,
//                        contentDescription = "계정 아이콘"
//                    )
//                }
//            }
//        )



        // 스텝 4
        // title, navigationIcon, actions 라고 쓰지않고, 그냥 순차적으로 쓰는 방법
        TopAppBar{
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "이전 아이콘"
                )
            }
            // Modifier.weight(1f)로 지정해서 나머지 비율을 Text가 다 차지하도록
            Text("TopAppBar", modifier = Modifier.weight(1f))

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "검색 아이콘"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "설정 아이콘"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "계정 아이콘"
                )
            }
        }

        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopAppBarTheme {
        TopBarEx("Android")
    }
}