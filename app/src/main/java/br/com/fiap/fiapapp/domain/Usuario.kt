package br.com.fiap.fiapapp.domain

data class Usuario(
    val nome: String = "",
    val email: String = "",
    val idade: Int = 0,
    val lembrar: Boolean = false
)