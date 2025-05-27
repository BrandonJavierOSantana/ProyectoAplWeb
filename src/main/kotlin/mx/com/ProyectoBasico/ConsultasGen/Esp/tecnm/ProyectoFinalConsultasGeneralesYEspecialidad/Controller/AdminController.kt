package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminController {

    @GetMapping("/administradores")
    fun administradores(): String =
        "pages/admin/administradores"

    @GetMapping("/consultas")
    fun historialConsultas(): String =
        "pages/admin/historial-consultas"

    @GetMapping("/medicos")
    fun medicos(): String =
        "pages/admin/lista-medicos"

    @GetMapping("/pacientes")
    fun pacientes(): String =
        "pages/admin/lista-pacientes"
}
