package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Service.ConsultaGeneralService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.dtos.DtoConsulta
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/consultas")
class ConsultaGeneralController(
    private val consultaGeneralService: ConsultaGeneralService
) {

    @GetMapping
    fun getFormConsulta(model: Model): String {
        // Enviar datos al formulario (por ejemplo, listas necesarias para selects)
        model.addAttribute("datos", DtoConsulta())
        return "pages/consultas/registro-consulta"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute dto: DtoConsulta): ResponseEntity<DtoConsulta> {
        consultaGeneralService.save(dto)
        return ResponseEntity.ok(dto)
    }

    @GetMapping("/historial")
    fun getHistorialConsultas(model: Model): String {
        model.addAttribute("consultas", consultaGeneralService.findAll())
        return "pages/consultas/historial-consultas"
    }
}