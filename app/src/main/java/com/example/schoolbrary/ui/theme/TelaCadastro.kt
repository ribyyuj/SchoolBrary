package com.example.schoolbrary.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TelaCadastro(
    voltar: () -> Unit,
    salvar: (Materia) -> Unit
) {
    var nome by rememberSaveable { mutableStateOf("") }
    var descricao by rememberSaveable { mutableStateOf("") }
    var professor by rememberSaveable { mutableStateOf("") }
    var dia by rememberSaveable { mutableStateOf("") }
    var erro by rememberSaveable { mutableStateOf("") }

    Scaffold(
        containerColor = VerdeClaro
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            Text(
                text = "Cadastrar matéria",
                color = Vinho,
                style = androidx.compose.material3.MaterialTheme
                    .typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome da matéria") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Vinho,
                    unfocusedBorderColor = Marrom,
                    focusedLabelColor = Vinho,
                    cursorColor = Rosa
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                label = { Text("Descrição") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Vinho,
                    unfocusedBorderColor = Marrom,
                    focusedLabelColor = Vinho,
                    cursorColor = Rosa
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = professor,
                onValueChange = { professor = it },
                label = { Text("Nome do professor") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Vinho,
                    unfocusedBorderColor = Marrom,
                    focusedLabelColor = Vinho,
                    cursorColor = Rosa
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = dia,
                onValueChange = { dia = it },
                label = { Text("Dia da semana") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Vinho,
                    unfocusedBorderColor = Marrom,
                    focusedLabelColor = Vinho,
                    cursorColor = Rosa
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (erro.isNotEmpty()) {
                Text(
                    text = erro,
                    color = Vinho
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = {
                    if (
                        nome.isBlank() ||
                        descricao.isBlank() ||
                        professor.isBlank() ||
                        dia.isBlank()
                    ) {
                        erro = "Preencha todos os campos."
                    } else if (descricao.trim().length < 5) {
                        erro = "A descrição deve ter pelo menos 5 caracteres."
                    } else {
                        val novaMateria = Materia(
                            id = "",
                            nome = nome.trim(),
                            descricao = descricao.trim(),
                            professor = professor.trim(),
                            dia = dia.trim()
                        )

                        salvar(novaMateria)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Rosa,
                    contentColor = VerdeClaro
                )
            ) {
                Text("Salvar matéria")
            }

            OutlinedButton(
                onClick = voltar,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Vinho
                )
            ) {
                Text("Cancelar")
            }
        }
    }
}