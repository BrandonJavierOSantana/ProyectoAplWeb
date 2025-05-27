package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.NotaDeInterconsultaService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeInterconsulta
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/notaDeInterconsulta")
class NotaDeInterconsultaController(
    private val service: NotaDeInterconsultaService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllNotaDeInterconsulta())
        return "views/NotaDeInterconsultaView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", NotaDeInterconsulta())
        return "formularies/NotaDeInterconsultaForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: NotaDeInterconsulta): String {
        service.saveNotaDeInterconsulta(entity)
        return "redirect:/notaDeInterconsulta/list"
    }
}
