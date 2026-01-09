package br.com.fiap.fiapapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.fiapapp.domain.Usuario
import br.com.fiap.fiapapp.ui.theme.FiapAppTheme

@Composable
fun TelaDetalhes(usuario: Usuario) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "FiapApp",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "DETALHES:",
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "- Nome:",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Nome do usuário"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "- E-mail:",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "email@do.usuario"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "- Idade:",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "99"
            )
            HorizontalDivider()
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Tela Inicial")
            }
        }
    }
}

@Preview
@Composable
private fun TelaDetalhesPreview() {
    FiapAppTheme {
        //TelaDetalhes()
    }
}