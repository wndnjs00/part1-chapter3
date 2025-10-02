package kr.co.fastcampus.part1.chapter3_12

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.co.fastcampus.part1.chapter3_12.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        CardEx(cardData)
                        CardEx(cardData)
                        CardEx(cardData)
                    }
                }
            }
        }
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)

    Card(
        elevation = 8.dp,
        modifier = Modifier.padding(4.dp),
    ) {
        // 단계 1: 아래의 Row 레이아웃을 ConstraintLayout로 바꾸어 봅시다.
        // ConstraintLayout을 이렇게 설정하면, 실제 앱 화면처럼 크게 보임
        // 근데, 이걸 작성하면, 전체사이즈를 다 차지해버려서 의도한대로 카드뷰가 3개가 나오지 않음
//        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
//        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                contentScale = ContentScale.Crop, //이걸 작성하지 않으면,이미지가 잘릴수있음
                placeholder = ColorPainter(color = placeHolderColor),
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(text = cardData.author)
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = cardData.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardTheme {
        CardEx(cardData)
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)

val cardData = CardData(
    imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part1-chapter3/main/part1-chapter3-10/app/src/main/res/drawable-xhdpi/wall.jpg",
    imageDescription = "엔텔로프 캐년",
    author = "Dalinaum",
    description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
)