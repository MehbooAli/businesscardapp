package com.example.business_card_app
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme{
                Surface {
                    MyApp()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyApp() {
BusinessCardApp()
}

@Composable
fun BusinessCardApp() {
    Surface(color = Color.LightGray) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                addImage();
//                Spacer(modifier = Modifier.height(4.dp))
                ownerName();
            }
            Column {
                detail();
            }
        }
    }
}

@Composable
fun addImage() {
    val image = painterResource(id = R.drawable.ic_launcher_foreground)
    Image(painter = image, contentDescription = null, modifier = Modifier.size(200.dp))
}

@Composable
fun ownerName() {
    Text(text = "Kamran Ali", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    Text(text = "Android Developer!", fontWeight = FontWeight.Light)
}

@Composable
fun detail() {
    val interactionSource = remember { MutableInteractionSource() }
    Row() {
        Icon(painter = painterResource(id = R.drawable.baseline_123_24), contentDescription = null)
        Text(text = "+2343532423", modifier = Modifier
            .clickable(
                interactionSource,
                indication = null
            ) { }
            .padding(start = 10.dp),)
    }
    Row {
        Icon(painter = painterResource(id = R.drawable.baseline_email_24), contentDescription = null)
        Text(text = "mehboob@gmail.com",modifier = Modifier
            .clickable { }
            .padding(start = 10.dp))
    }

    Row {
        Icon(painter = painterResource(id = R.drawable.baseline_brightness_low_24), contentDescription = null)
        Text(text = "domain.com", modifier = Modifier.clickable {  }.padding(start = 10.dp))
    }
}