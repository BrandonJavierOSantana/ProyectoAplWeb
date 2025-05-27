package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaDiscapacidadSubgrupoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaDiscapacidadSubgrupo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personaDiscapacidadSubgrupo")
class PersonaDiscapacidadSubgrupoController(
    private val service: PersonaDiscapacidadSubgrupoService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllPersonaDiscapacidadSubgrupo())
        return "views/PersonaDiscapacidadSubgrupoView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", PersonaDiscapacidadSubgrupo())
        return "formularies/PersonaDiscapacidadSubgrupoForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: PersonaDiscapacidadSubgrupo): String {
        service.savePersonaDiscapacidadSubgrupo(entity)
        return "redirect:/personaDiscapacidadSubgrupo/list"
    }
}
