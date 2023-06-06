package br.senai.sp.jandira.lionschool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import br.senai.sp.jandira.lionschool.model.Students
import br.senai.sp.jandira.lionschool.model.StudentsList
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import br.senai.sp.jandira.lionschool.service.StudentsService
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {

                val siglaCurso = intent.getStringExtra("sigla")
                val nomeCurso = intent.getStringExtra("nome")
                studentsScreen(siglaCurso.toString(), nomeCurso.toString())

            }
        }
    }
}


@Composable
fun studentsScreen(curso: String, nomeCurso: String) {

    var listStudents by remember {
        mutableStateOf(listOf<Students>())
    }

    var context = LocalContext.current

    val call = RetrofitFactory().getStudentsService().getStudentsByCourse(curso)
    call.enqueue(object : Callback<StudentsList> {
        override fun onResponse(
            call: Call<StudentsList>,
            response: Response<StudentsList>
        ) {
            listStudents = response.body()!!.curso
        }

        override fun onFailure(call: Call<StudentsList>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })

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
                    .fillMaxSize()
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = nomeCurso,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(28.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(100.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(Color(229, 182, 87)),
                    ) {
                        Text(
                            text = stringResource(id = R.string.all_students),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(115.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(Color(229, 182, 87)),
                    ) {
                        Text(
                            text = stringResource(id = R.string.studying),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(Color(229, 182, 87)),
                    ) {
                        Text(
                            text = stringResource(id = R.string.finalized),
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                LazyColumn(){
                    items(listStudents){

                        var backgroundCard = Color(0,0,0)

                        if(it.status == "Finalizado"){
                            backgroundCard = Color(229, 182, 87)
                        }else{
                            backgroundCard = Color(26,40,118)
                        }

                        Card(
                            modifier = Modifier
                                .width(300.dp)
                                .height(200.dp)
                                .clickable {
                                    var openStudentInfo =
                                        Intent(context, StudentsActivity::class.java)
                                    openStudentInfo.putExtra("matricula", it.matricula)
                                    context.startActivity(openStudentInfo)
                                },
                            backgroundColor = backgroundCard
                        ){

                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                AsyncImage(
                                    model = it.foto,
                                    contentDescription = "Student photo",
                                    modifier = Modifier.size(150.dp)
                                )

                                Text(
                                    text = it.nome,
                                    modifier = Modifier.padding(top = 8.dp),
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight =  FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }



            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview3() {
//    LionSchoolTheme {
//        studentsScreen(curso: String)
//    }
//}