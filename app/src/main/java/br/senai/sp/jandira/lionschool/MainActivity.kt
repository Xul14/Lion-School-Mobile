package br.senai.sp.jandira.lionschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                WelcomeScreen()
            }
        }
    }
}

@Composable
fun WelcomeScreen() {

    Surface(modifier = Modifier.fillMaxSize()) {
        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                backgroundColor = Color(51, 71, 176),
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.logo_image),
                        contentDescription = "Logo Lion School",
                        modifier = Modifier.size(128.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = stringResource(id = R.string.name_school),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 40.sp
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(id = R.string.welcome),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(229, 182, 87)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = stringResource(id = R.string.welcome_description),
                    modifier = Modifier.width(350.dp),
                    fontSize = 18.sp,
                    color = Color(80, 80, 80, 95),
                    textAlign = TextAlign.Center

                )

                Spacer(modifier = Modifier.height(80.dp))

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(Color(51, 71, 176)),
                    border = BorderStroke(width = 2.dp, Color(229, 182, 87))
                ) {
                    Text(
                        text = stringResource(id = R.string.button_start),
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }

            }

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LionSchoolTheme {
        WelcomeScreen()
    }
}