package com.example.schoolbrary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.schoolbrary.ui.theme.Materia
import com.example.schoolbrary.ui.theme.TelaCadastro
import com.example.schoolbrary.ui.theme.TelaDetalhes
import com.example.schoolbrary.ui.theme.TelaInicial
import com.example.schoolbrary.ui.theme.TelaSobre
import java.util.UUID


object Rotas {
    const val INICIO = "inicio"
    const val CADASTRO = "cadastro"
    const val DETALHES = "detalhes/{materiaId}"
    const val SOBRE = "sobre"

    fun detalhes(id: String): String {
        return "detalhes/$id"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()


    val materias = remember {
        mutableStateListOf(
            Materia(
                "1",
                "Matemática",
                "Estudar equações e funções",
                "Professor João",
                "Segunda-feira"
            ),
            Materia(
                "2",
                "Português",
                "Revisar interpretação de texto",
                "Professora Ana",
                "Terça-feira"
            ),
            Materia(
                "3",
                "Informática",
                "Estudar programação Kotlin",
                "Professor Carlos",
                "Quarta-feira"
            )
        )
    }

    NavHost(
        navController = navController,
        startDestination = Rotas.INICIO
    ) {
        // TELA INICIAL
        composable(Rotas.INICIO) {
            TelaInicial(
                materias = materias,
                abrirCadastro = {
                    navController.navigate(Rotas.CADASTRO)
                },
                abrirSobre = {
                    navController.navigate(Rotas.SOBRE)
                },
                abrirDetalhes = { id ->
                    navController.navigate(Rotas.detalhes(id))
                }
            )
        }

        // TELA DE CADASTRO
        composable(Rotas.CADASTRO) {
            TelaCadastro(
                voltar = {
                    navController.popBackStack()
                },
                salvar = { materia ->
                    val novaMateria = materia.copy(
                        id = UUID.randomUUID().toString()
                    )

                    materias.add(novaMateria)
                    navController.popBackStack()
                }
            )
        }

        // TELA DE DETALHES
        composable(
            route = Rotas.DETALHES,
            arguments = listOf(
                navArgument("materiaId") {
                    type = NavType.StringType
                }
            )
        ) { entrada ->
            val id = entrada.arguments?.getString("materiaId")
            val materia = materias.find { it.id == id }

            TelaDetalhes(
                materia = materia,
                voltar = {
                    navController.popBackStack()
                }
            )
        }

        // TELA SOBRE / AJUDA
        composable(Rotas.SOBRE) {
            TelaSobre(
                voltar = {
                    navController.popBackStack()
                }
            )
        }
    }
}