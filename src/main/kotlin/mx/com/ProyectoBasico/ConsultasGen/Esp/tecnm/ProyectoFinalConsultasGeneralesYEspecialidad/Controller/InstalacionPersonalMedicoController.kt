package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.InstalacionPersonalMedicoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.InstalacionPersonalMedico
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/instalacionPersonalMedico")
class InstalacionPersonalMedicoController(
    private val service: InstalacionPersonalMedicoService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllInstalacionPersonalMedico())
        return "views/InstalacionPersonalMedicoView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", InstalacionPersonalMedico())
        return "formularies/InstalacionPersonalMedicoForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: InstalacionPersonalMedico): String {
        service.saveInstalacionPersonalMedico(entity)
        return "redirect:/instalacionPersonalMedico/list"
    }
}