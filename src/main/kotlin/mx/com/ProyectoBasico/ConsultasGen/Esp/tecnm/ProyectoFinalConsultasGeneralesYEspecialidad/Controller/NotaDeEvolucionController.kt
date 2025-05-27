package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.NotaDeEvolucionService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeEvolucion
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/notaDeEvolucion")
class NotaDeEvolucionController(
    private val service: NotaDeEvolucionService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllNotaDeEvolucion())
        return "views/NotaDeEvolucionView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", NotaDeEvolucion())
        return "formularies/NotaDeEvolucionForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: NotaDeEvolucion): String {
        service.saveNotaDeEvolucion(entity)
        return "redirect:/notaDeEvolucion/list"
    }
}
