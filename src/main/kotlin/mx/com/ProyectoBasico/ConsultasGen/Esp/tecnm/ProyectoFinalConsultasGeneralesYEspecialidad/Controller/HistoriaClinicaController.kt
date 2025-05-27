package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.HistoriaClinicaService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.HistoriaClinica
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/historiaClinica")
class HistoriaClinicaController(
    private val service: HistoriaClinicaService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllHistoriaClinica())
        return "views/HistoriaClinicaView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", HistoriaClinica())
        return "formularies/HistoriaClinicaForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: HistoriaClinica): String {
        service.saveHistoriaClinica(entity)
        return "redirect:/historiaClinica/list"
    }
}