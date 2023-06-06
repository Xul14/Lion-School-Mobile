package br.senai.sp.jandira.lionschool.model

data class StudentInfo(
    val id: Long,
    val nome: String,
    val matricula: String,
    val foto: String,
    val curso: String,
    val status: String
)