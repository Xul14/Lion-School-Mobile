package br.senai.sp.jandira.lionschool.service

import br.senai.sp.jandira.lionschool.model.StudentInfoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StudentInfoService {
    @GET("alunos/{matricula}")
    fun getMatriculaStudent(@Path("matricula") matricula: String): Call<StudentInfoList>
}