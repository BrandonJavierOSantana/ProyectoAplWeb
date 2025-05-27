package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaDiscapacidadService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaDiscapacidad
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personaDiscapacidad")
class PersonaDiscapacidadController(
    private val service: PersonaDiscapacidadService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllPersonaDiscapacidad())
        return "views/PersonaDiscapacidadView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", PersonaDiscapacidad())
        return "formularies/PersonaDiscapacidadForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: PersonaDiscapacidad): String {
        service.savePersonaDiscapacidad(entity)
        return "redirect:/personaDiscapacidad/list"
    }
}
