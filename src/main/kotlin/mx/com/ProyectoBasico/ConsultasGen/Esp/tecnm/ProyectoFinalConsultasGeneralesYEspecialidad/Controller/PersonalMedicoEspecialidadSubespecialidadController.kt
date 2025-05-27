package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonalMedicoEspecialidadSubespecialidadService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedicoEspecialidadSubespecialidad
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personalMedicoEspecialidadSubespecialidad")
class PersonalMedicoEspecialidadSubespecialidadController(
    private val service: PersonalMedicoEspecialidadSubespecialidadService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAll())
        return "views/PersonalMedicoEspecialidadSubespecialidadView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", PersonalMedicoEspecialidadSubespecialidad())
        return "formularies/PersonalMedicoEspecialidadSubespecialidadForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: PersonalMedicoEspecialidadSubespecialidad): String {
        service.save(entity)
        return "redirect:/personalMedicoEspecialidadSubespecialidad/list"
    }
}
