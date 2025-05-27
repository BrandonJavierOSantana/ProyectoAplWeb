package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.ExploracionFisicaService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.ExploracionFisica
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/exploracionFisica")
class ExploracionFisicaController(
    private val service: ExploracionFisicaService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllExploracionFisica())
        return "views/ExploracionFisicaView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", ExploracionFisica())
        return "formularies/ExploracionFisicaForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: ExploracionFisica): String {
        service.saveExploracionFisica(entity)
        return "redirect:/exploracionFisica/list"
    }
}
