package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.InstitucionService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Institucion
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/institucion")
class InstitucionController(
    private val service: InstitucionService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllInstitucion())
        return "views/InstitucionView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", Institucion())
        return "formularies/InstitucionForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: Institucion): String {
        service.saveInstitucion(entity)
        return "redirect:/institucion/list"
    }
}