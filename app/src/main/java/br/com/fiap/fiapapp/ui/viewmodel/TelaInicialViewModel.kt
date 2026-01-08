package br.com.fiap.fiapapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.fiapapp.data.repository.UsuarioDataStorePreferences
import br.com.fiap.fiapapp.domain.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TelaInicialViewModel(
    private val usuarioDataStorePreferences: UsuarioDataStorePreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(Usuario())
    val uiState: StateFlow<Usuario> = _uiState.asStateFlow()

    init {
        carregarDados()
    }

    private fun carregarDados() {
        viewModelScope.launch {
            usuarioDataStorePreferences.usuarioFlow.collect {
                _uiState.value = it
            }
        }
    }

    fun atualizarNome(nome: String) {
        _uiState.update { it.copy(nome = nome) }
    }

    fun atualizarEmail(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun atualizarIdade(idade: String) {
        _uiState.update { it.copy(idade = idade.toIntOrNull() ?: 0) }
    }

    fun atualizarLembrar(lembrar: Boolean) {
        _uiState.update { it.copy(lembrar = lembrar) }
    }

    fun gravarDados() {
        viewModelScope.launch {
            usuarioDataStorePreferences.salvarUsuario(_uiState.value)
        }
    }
}