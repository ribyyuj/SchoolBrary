package com.example.schoolbrary.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaDetalhes(
    materia: Materia?,
    voltar: () -> Unit
) {
    Scaffold(
        containerColor = VerdeClaro
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
        ) {

            Text(
                text = "Detalhes da matéria",
                style = MaterialTheme.typography.headlineMedium,
                color = Vinho
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (materia != null) {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Pessego
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = materia.nome,
                            style = MaterialTheme.typography.titleLarge,
                            color = Vinho
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "ID: ${materia.id}",
                            color = Marrom
                        )

                        Text(
                            text = "Descrição: ${materia.descricao}",
                            color = Marrom
                        )

                        Text(
                            text = "Professor: ${materia.professor}",
                            color = Marrom
                        )

                        Text(
                            text = "Dia: ${materia.dia}",
                            color = Marrom
                        )
                    }
                }

            } else {

                Text(
                    text = "Matéria não encontrada.",
                    color = Vinho
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = voltar,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Rosa,
                    contentColor = VerdeClaro
                )
            ) {
                Text("Voltar")
            }
        }
    }
}