package br.com.fiap.fiapapp.data.repository

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import br.com.fiap.fiapapp.domain.Usuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UsuarioDataStorePreferences(private val context: Context) {

    companion object {
        val NOME = stringPreferencesKey("nome")
        val EMAIL = stringPreferencesKey("email")
        val IDADE = intPreferencesKey("idade")
        val LEMBRAR = booleanPreferencesKey("lembrar")
    }

    suspend fun salvarUsuario(usuario: Usuario) {
        context.dataStore.edit { prefs ->
            prefs[NOME] = usuario.nome
            prefs[EMAIL] = usuario.email
            prefs[IDADE] = usuario.idade
            prefs[LEMBRAR] = usuario.temaEscuro
        }
    }

    val usuarioFlow: Flow<Usuario> = context.dataStore.data.map { prefs ->
        Usuario(
            nome = prefs[NOME] ?: "",
            email = prefs[EMAIL] ?: "",
            idade = prefs[IDADE] ?: 0,
            temaEscuro = prefs[LEMBRAR] ?: false
        )
    }
}