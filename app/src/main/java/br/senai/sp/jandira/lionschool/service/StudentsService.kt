package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.CourseList
import br.senai.sp.jandira.lionschool.model.StudentsList
import retrofit2.Call
import retrofit2.http.GET

interface StudentsService {
    @GET("alunos")
    fun getStudents(): Call<StudentsList>


}