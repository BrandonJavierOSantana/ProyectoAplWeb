package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaPersonaAlergiaService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaPersonaAlergia
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personaPersonaAlergia")
class PersonaPersonaAlergiaController(
    private val service: PersonaPersonaAlergiaService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAll())
        return "views/PersonaPersonaAlergiaView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", PersonaPersonaAlergia())
        return "formularies/PersonaPersonaAlergiaForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: PersonaPersonaAlergia): String {
        service.save(entity)
        return "redirect:/personaPersonaAlergia/list"
    }
}
