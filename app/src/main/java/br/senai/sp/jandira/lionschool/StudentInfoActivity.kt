package br.senai.sp.jandira.lionschool

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.StudentInfo
import br.senai.sp.jandira.lionschool.model.StudentInfoList
import br.senai.sp.jandira.lionschool.model.Students
import br.senai.sp.jandira.lionschool.model.StudentsList
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import coil.compose.AsyncImage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                val matriculaAluno = intent.getStringExtra("matricula")
                InfoScreen(matriculaAluno.toString())
            }
        }
    }
}

@Composable
fun InfoScreen(matricula: String) {

    var infoStudent by remember {
        mutableStateOf(listOf<StudentInfo>())
    }

    val call = RetrofitFactory().getMatriculaStudent().getMatriculaStudent(matricula)
    call.enqueue(object : Callback<StudentInfoList> {
        override fun onResponse(
            call: Call<StudentInfoList>,
            response: Response<StudentInfoList>
        ) {
            infoStudent = response.body()!!.alunos
        }

        override fun onFailure(call: Call<StudentInfoList>, t: Throwable) {
            Log.i("DS2T", "onFailure: ${t.message}")
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

            Spacer(modifier = Modifier.height(20.dp))

            Column( modifier = Modifier.fillMaxSize()) {
                LazyColumn() {
                    items(infoStudent) {


                        Card(
                            modifier = Modifier
                                .width(350.dp)
                                .height(600.dp),
                            shape = RoundedCornerShape(20.dp)

                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(3.dp)
                            ) {
                                AsyncImage(
                                    model = it.foto,
                                    contentDescription = "Student photo",
                                    modifier = Modifier.size(130.dp)
                                )

                                Spacer(modifier = Modifier.width(2.dp))

                                Text(
                                    text = it.nome,
                                    modifier = Modifier
                                        .padding(top = 40.dp),
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(51, 71, 176),
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Column(
                                    modifier = Modifier
                                        .width(240.dp)
                                        .height(40.dp)
                                ) {
                                    Text(
                                        text = "Sistemas Operacionais",
                                        fontWeight = FontWeight(700),
                                        fontSize = 14.sp,
                                        color = Color.Blue,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Box(
                                        modifier = Modifier
                                            .height(17.5.dp)
                                            .width(240.dp)
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(
                                                Color.White
                                            )
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(
                                                    Color.Blue
                                                )
                                                .width(130.dp)
                                                .padding(0.dp, 0.dp, 5.dp, 0.dp),
                                            contentAlignment = Alignment.CenterEnd
                                        ) {
                                            Text(
                                                text = "90%",
                                                fontWeight = FontWeight(700),
                                                fontSize = 12.sp,
                                                color = Color.White
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(15.dp))
                            }
                        }
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
        InfoScreen("")
    }
}