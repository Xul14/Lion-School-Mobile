package br.senai.sp.jandira.lionschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class StudentInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                InfoScreen()
            }
        }
    }
}

@Composable
fun InfoScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(51, 71, 176)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo_image),
                    contentDescription = "Logo Lion School",
                    modifier = Modifier.size(64.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = stringResource(R.string.name_school),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.width(64.dp)
                )

                Spacer(modifier = Modifier.width(14.dp))

                Divider(
                    modifier = Modifier
                        .width(220.dp)
                        .height(2.dp),
                    color = Color(229, 182, 87)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Card(
                    modifier = Modifier
                        .width(350.dp)
                        .height(600.dp),
                    shape = RoundedCornerShape(20.dp)

                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.student),
                            contentDescription = "Student photo",
                            modifier = Modifier.size(130.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "HÉLIDA BENTO DE OLIVEIRA LINS",
                            modifier = Modifier
                                .padding(top = 40.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(51, 71, 176)
                        )
                    }

                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview4() {
    LionSchoolTheme {
        InfoScreen()
    }
}