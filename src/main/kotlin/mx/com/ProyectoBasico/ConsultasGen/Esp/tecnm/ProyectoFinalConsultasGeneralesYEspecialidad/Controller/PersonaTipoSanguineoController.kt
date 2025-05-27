package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaTipoSanguineoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaTipoSanguineo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personaTipoSanguineo")
class PersonaTipoSanguineoController(
    private val service: PersonaTipoSanguineoService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAll())
        return "views/PersonaTipoSanguineoView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", PersonaTipoSanguineo())
        return "formularies/PersonaTipoSanguineoForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: PersonaTipoSanguineo): String {
        service.save(entity)
        return "redirect:/personaTipoSanguineo/list"
    }
}
