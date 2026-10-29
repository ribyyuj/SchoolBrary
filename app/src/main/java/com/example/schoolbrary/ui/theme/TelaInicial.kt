package com.example.schoolbrary.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import com.example.schoolbrary.R
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.format.TextStyle

@Composable
fun TelaInicial(
    materias: List<Materia>,
    abrirCadastro: () -> Unit,
    abrirSobre: () -> Unit,
    abrirDetalhes: (String) -> Unit
) {
    Scaffold(
        containerColor = VerdeClaro
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.school_library
                ),
                contentDescription = "Logo do SchoolBrary",
                modifier = Modifier
                    .size(250.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "SchoolBrary",
                style = MaterialTheme.typography.headlineLarge,
                color = Vinho,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Sua agenda escolar",
                color = Marrom,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = abrirCadastro,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Rosa,
                    contentColor = VerdeClaro
                )
            ) {
                Text("Cadastrar matéria")
            }

            OutlinedButton(
                onClick = abrirSobre,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Rosa,
                    contentColor = VerdeClaro
                )
            ) {
                Text("Sobre / Ajuda")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Minhas matérias",
                style = MaterialTheme.typography.titleLarge,
                color = Marrom,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = materias,
                    key = { it.id }
                ) { materia ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Pessego
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp)
                        ) {
                            Text(
                                text = materia.nome,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Black
                            )

                            Text(
                                text = "Descrição: ${materia.descricao}",
                                color = Marrom
                            )

                            Text(
                                text = "Dia: ${materia.dia}",
                                color = Marrom
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(
                                onClick = {
                                    abrirDetalhes(materia.id)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Vinho,
                                    contentColor = VerdeClaro
                                )
                            ) {
                                Text("Ver detalhes")
                            }
                        }
                    }
                }
            }
        }
    }
}