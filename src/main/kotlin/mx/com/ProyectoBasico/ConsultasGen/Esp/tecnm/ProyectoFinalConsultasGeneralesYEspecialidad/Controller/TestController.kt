package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("test")
class TestController {

    @GetMapping("/administradores")
    fun administradores(): String {
        return "pages/admin/administradores"
    }

    @GetMapping("/consultas")
    fun historialConsultas(): String {
        return "pages/admin/historial-consultas"
    }
}
