package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Utils

import org.springframework.stereotype.Component

@Component("Items")
object Items{
    val asideAdmin = listOf(
        mapOf("text" to "Lista Administradores", "href" to "#"),
        mapOf("text" to "Registrar Administrador", "href" to "#"),
    )
    val asideConsultas= listOf(
        mapOf("text" to "Lista Consultas", "href" to "#"),
        mapOf("text" to "Registrar Consultas", "href" to "#"),
    )

    val asideMedicos = listOf(
        mapOf("text" to "Lista Medicos", "href" to "#"),
        mapOf("text" to "Registrar Medico", "href" to "#"),
    )

    val asidePacientes = listOf(
        mapOf("text" to "Lista Pacientes", "href" to "#"),
        mapOf("text" to "Registrar Paciente", "href" to "#"),

        )
}