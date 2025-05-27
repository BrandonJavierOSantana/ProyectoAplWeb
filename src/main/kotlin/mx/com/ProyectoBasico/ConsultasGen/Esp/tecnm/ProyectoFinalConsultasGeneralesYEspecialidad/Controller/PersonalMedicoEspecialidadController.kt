package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonalMedicoEspecialidadService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedicoEspecialidad
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personalMedicoEspecialidad")
class PersonalMedicoEspecialidadController(
    private val service: PersonalMedicoEspecialidadService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllPersonalMedicoEspecialidad())
        return "views/PersonalMedicoEspecialidadView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", PersonalMedicoEspecialidad())
        return "formularies/PersonalMedicoEspecialidadForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: PersonalMedicoEspecialidad): String {
        service.savePersonalMedicoEspecialidad(entity)
        return "redirect:/personalMedicoEspecialidad/list"
    }
}