package me.will.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.will.lemonadeapp.ui.theme.LemonadeAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Lemonade()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeAppTheme {
        Lemonade(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        TitleBar()
        MainPane()
    }
}

@Composable
fun TitleBar(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.home_title),
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFFFB74D))
            .padding(18.dp)
    )
}

@Composable
fun MainPane(modifier: Modifier = Modifier) {
    var maxClickOfSqueeze by remember {
        mutableIntStateOf(0)
    }
    val lemonTreeCard = LemonadeCardContent(R.drawable.lemon_tree, R.string.lemon_tree, R.string.select_a_lemon) {
        maxClickOfSqueeze = Random(System.currentTimeMillis()).nextInt(1, 5)
        2
    }
    val lemonSqueezeCard = LemonadeCardContent(R.drawable.lemon_squeeze, R.string.lemon, R.string.squeeze_lemon) {
        maxClickOfSqueeze--
        if (maxClickOfSqueeze > 0) {
            2
        } else {
            3
        }
    }
    val lemonDrinkCard = LemonadeCardContent(R.drawable.lemon_drink, R.string.glass_of_lemonade, R.string.drink_lemon) { 4 }
    val lemonRestartCard = LemonadeCardContent(R.drawable.lemon_restart, R.string.empty_glass, R.string.start_again) { 1 }
    var cardIndex by remember {
        mutableIntStateOf(1)
    }
    val cardContent = when (cardIndex) {
        1 -> lemonTreeCard
        2 -> lemonSqueezeCard
        3 -> lemonDrinkCard
        else -> lemonRestartCard
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Button(
            onClick = { cardIndex = cardContent.next() },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFCDD2)),
            shape = ShapeDefaults.ExtraLarge
        ) {
            Image(
                painter = painterResource(id = cardContent.imgId),
                contentDescription = stringResource(id = cardContent.imgDescId)
            )
        }
        Text(
            text = stringResource(id = cardContent.promptTextId),
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 20.dp)
        )
    }
}

class LemonadeCardContent(
    val imgId: Int,
    val imgDescId: Int,
    val promptTextId: Int,
    val next: () -> Int
)
