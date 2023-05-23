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
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                Homescreen()
            }
        }
    }
}

@Composable
fun Homescreen() {

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
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .height(80.dp)
                        .width(350.dp)
                        .padding(horizontal = 48.dp, vertical = 24.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color(217, 217, 217),
                        focusedBorderColor = Color(217, 217, 217)
                    ),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search_icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = Color(217, 217, 217)
                        )
                    }
                )

                Row(
                    modifier = Modifier.padding(top = 24.dp),
                    horizontalArrangement = Arrangement.Start

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_list),
                        contentDescription = "List Icon",
                        modifier = Modifier
                            .size(32.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Courses",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Column(modifier = Modifier.padding(top = 32.dp)) {

                    Card(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.vector_ds),
                                    contentDescription = "Icon course",
                                    modifier = Modifier
                                        .size(48.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Text(
                                    text = "DS",
                                    fontSize = 48.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(51, 71, 176)
                                )
                            }

                            Text(
                                text = "Desenvolvimento de Sistemas",
                                modifier = Modifier.padding(bottom = 5.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                            )

                            Divider(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(4.dp),
                                color = Color(229, 182, 87)
                            )

                            Text(
                                text = "Learn to develop web and mobile applications",
                                modifier = Modifier.width(300.dp).padding(top = 10.dp),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal,
                                color = Color(114,114,114)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Card(
                        modifier = Modifier
                            .width(350.dp)
                            .height(200.dp),
                        backgroundColor = Color.White,
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(id = R.drawable.vector_ds),
                                    contentDescription = "Icon course",
                                    modifier = Modifier
                                        .size(48.dp)
                                )

                                Spacer(modifier = Modifier.width(10.dp))

                                Text(
                                    text = "DS",
                                    fontSize = 48.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(51, 71, 176)
                                )
                            }

                            Text(
                                text = "Desenvolvimento de Sistemas",
                                modifier = Modifier.padding(bottom = 5.dp),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Medium,
                            )

                            Divider(
                                modifier = Modifier
                                    .width(300.dp)
                                    .height(4.dp),
                                color = Color(229, 182, 87)
                            )

                            Text(
                                text = "Learn to develop web and mobile applications",
                                modifier = Modifier.width(300.dp).padding(top = 10.dp),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal,
                                color = Color(114,114,114)
                            )
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LionSchoolTheme {
        Homescreen()
    }
}