package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.DireccionEstadoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.DireccionEstado
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/direccionEstado")
class DireccionEstadoController(
    private val service: DireccionEstadoService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllDireccionEstado())
        return "views/DireccionEstadoView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", DireccionEstado())
        return "formularies/DireccionEstadoForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: DireccionEstado): String {
        service.saveDireccionEstado(entity)
        return "redirect:/direccionEstado/list"
    }
}
