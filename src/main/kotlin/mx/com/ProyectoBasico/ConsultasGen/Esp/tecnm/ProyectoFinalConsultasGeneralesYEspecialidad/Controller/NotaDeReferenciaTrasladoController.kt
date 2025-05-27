package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.NotaDeReferenciaTrasladoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeReferenciaTraslado
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/notaDeReferenciaTraslado")
class NotaDeReferenciaTrasladoController(
    private val service: NotaDeReferenciaTrasladoService
) {

    @GetMapping("/list")
    fun getAll(model: Model): String {
        model.addAttribute("entities", service.findAllNotaDeReferenciaTraslado())
        return "views/NotaDeReferenciaTrasladoView"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("entity", NotaDeReferenciaTraslado())
        return "formularies/NotaDeReferenciaTrasladoForm"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute entity: NotaDeReferenciaTraslado): String {
        service.saveNotaDeReferenciaTraslado(entity)
        return "redirect:/notaDeReferenciaTraslado/list"
    }
}
