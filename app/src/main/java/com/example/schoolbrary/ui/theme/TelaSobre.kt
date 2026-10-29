package com.example.schoolbrary.ui.theme

import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.Toast
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TelaSobre(
    voltar: () -> Unit
) {
    val context = LocalContext.current

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
                text = "Sobre o SchoolBrary",
                style = MaterialTheme.typography.headlineMedium,
                color = Vinho
            )

            Spacer(modifier = Modifier.height(16.dp))

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
                        text = "Objetivo do aplicativo",
                        style = MaterialTheme.typography.titleMedium,
                        color = Vinho,
                        fontWeight = FontWeight.Bold,

                    )

                    Text(
                        text = "O SchoolBrary é uma agenda escolar criada " +
                                "para ajudar os estudantes a organizar suas " +
                                "matérias, registrar informações importantes " +
                                "e facilitar a rotina de estudos.",
                        color = Marrom
                    )

                    Spacer(modifier = Modifier.height(12.dp))


                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Como utilizar",
                        style = MaterialTheme.typography.titleMedium,
                        color = Vinho
                    )

                    Text(
                        text = "1. Na tela inicial, veja as matérias cadastradas.\n" +
                                "2. Clique em Cadastrar matéria para adicionar uma nova.\n" +
                                "3. Preencha todos os campos e clique em Salvar matéria.\n" +
                                "4. Clique em Ver detalhes para consultar as informações.\n" +
                                "5. Use Sobre / Ajuda para consultar estas instruções e conhecer a gente.\n",
                        color = Marrom
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            "Conheça o SchoolBrary! " +
                                    "Uma agenda escolar para organizar " +
                                    "matérias e facilitar os estudos."
                        )
                    }

                    try {
                        context.startActivity(
                            Intent.createChooser(
                                intent,
                                "Compartilhar SchoolBrary"
                            )
                        )
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            context,
                            "Não foi possível compartilhar.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Rosa,
                    contentColor = VerdeClaro
                )
            ) {
                Text("Compartilhar aplicativo")
            }

            OutlinedButton(
                onClick = voltar,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Vinho
                )
            ) {
                Text("Voltar")
            }
        }
    }
}