package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.MedicacionService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Medicacion
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/medicacion")
class MedicacionController(
    private val service: MedicacionService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllMedicacion())
        return "views/MedicacionView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", Medicacion())
        return "formularies/MedicacionForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: Medicacion): String {
        service.saveMedicacion(entity)
        return "redirect:/medicacion/list"
    }
}
