package br.senai.sp.jandira.lionschool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.Course
import br.senai.sp.jandira.lionschool.model.CourseList
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoursesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                CoursesScreen()
            }
        }
    }
}

@Composable
fun CoursesScreen() {

    var listCourses by remember {
        mutableStateOf(listOf<Course>())
    }

    var courseState by remember {
        mutableStateOf(value = "")
    }

    var courseNamestate by remember {
        mutableStateOf(value = "")
    }

    var context = LocalContext.current

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

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

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
                        text = stringResource(id = R.string.course),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Column(modifier = Modifier.padding(top = 32.dp)) {

                    LazyColumn(){

                        val call = RetrofitFactory().getCoursesService().getCourses()

                        call.enqueue(object : Callback<CourseList>{
                            override fun onResponse(
                                call: Call<CourseList>,
                                response: Response<CourseList>
                            ) {
                                listCourses = response.body()!!.cursos
                            }

                            override fun onFailure(call: Call<CourseList>, t: Throwable) {
                                TODO("Not yet implemented")
                            }
                        })

                        items(listCourses){
                            Card(
                                modifier = Modifier
                                    .width(350.dp)
                                    .height(200.dp)
                                    .padding(bottom = 15.dp)
                                    .clickable {
                                        var openStudents = Intent(context, StudentsActivity::class.java)
                                        openStudents.putExtra("sigla",it.sigla)
                                        openStudents.putExtra("nome",it.nome)
                                        context.startActivity(openStudents)

                                    },
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

                                        AsyncImage(
                                            model = it.icone,
                                            contentDescription = "Icon course",
                                            modifier = Modifier.size(48.dp)
                                        )

                                        Spacer(modifier = Modifier.width(10.dp))

                                        Text(
                                            text = it.sigla,
                                            fontSize = 48.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(51, 71, 176)
                                        )
                                    }

                                    Text(
                                        text = it.nome,
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
                                        text = it.descricao ,
                                        modifier = Modifier
                                            .width(300.dp)
                                            .padding(top = 10.dp),
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
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    LionSchoolTheme {
        CoursesScreen()
    }
}