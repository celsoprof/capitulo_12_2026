package br.com.fiap.fiapapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.fiap.fiapapp.data.repository.UsuarioDataStorePreferences
import br.com.fiap.fiapapp.ui.screens.TelaInicial
import br.com.fiap.fiapapp.ui.theme.FiapAppTheme
import br.com.fiap.fiapapp.ui.viewmodel.TelaInicialViewModel
import br.com.fiap.fiapapp.ui.viewmodel.factory.TelaInicialViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: TelaInicialViewModel by viewModels {
        TelaInicialViewModelFactory(UsuarioDataStorePreferences(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state by viewModel.uiState.collectAsState()
            FiapAppTheme(
                darkTheme = state.temaEscuro
            ) {
                TelaInicial(this, viewModel)
            }
        }
    }
}
