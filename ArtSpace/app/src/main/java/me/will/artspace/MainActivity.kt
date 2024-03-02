package me.will.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.will.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var artworkIndex by remember { mutableIntStateOf(1) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        when(artworkIndex) {
            1 -> {
                ArtworkWall(R.drawable._01)
                Spacer(modifier = Modifier.height(64.dp))
                ArtworkDescriptor(
                    artworkTitleId = R.string.artwork_01_title,
                    artworkArtistId = R.string.artist_01_desc
                )
            }
            2 -> {
                ArtworkWall(R.drawable._02)
                Spacer(modifier = Modifier.height(64.dp))
                ArtworkDescriptor(
                    artworkTitleId = R.string.artwork_02_title,
                    artworkArtistId = R.string.artist_02_desc
                )
            }
            3 -> {
                ArtworkWall(R.drawable._03)
                Spacer(modifier = Modifier.height(64.dp))
                ArtworkDescriptor(
                    artworkTitleId = R.string.artwork_03_title,
                    artworkArtistId = R.string.artist_03_desc
                )
            }
            4 -> {
                ArtworkWall(R.drawable._04)
                Spacer(modifier = Modifier.height(64.dp))
                ArtworkDescriptor(
                    artworkTitleId = R.string.artwork_04_title,
                    artworkArtistId = R.string.artist_04_desc
                )
            }
        }
        DisplayController(
            actionPrevious = {
                artworkIndex--
                if (artworkIndex == 0)
                    artworkIndex = 4
            },
            actionNext = {
                artworkIndex++
                if (artworkIndex > 4)
                    artworkIndex = 1
            }
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes artworkImgId: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(0.8F)
            .padding(12.dp)
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        color = MaterialTheme.colorScheme.background
    ) {
        Image(
            painter = painterResource(id = artworkImgId),
            contentDescription = null
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes artworkTitleId: Int,
    @StringRes artworkArtistId: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 26.dp)
    ) {
        Text(
            text = stringResource(id = artworkTitleId),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(id = artworkArtistId, "2007"),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun DisplayController(
    actionPrevious: () -> Unit,
    actionNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.padding(end = 8.dp),
            onClick = actionPrevious
        ) {
            Text(text = "Previous")
        }
        Button(
            modifier = Modifier.padding(start = 8.dp),
            onClick = actionNext
        ) {
            Text(text = "Next")
        }
    }
}
