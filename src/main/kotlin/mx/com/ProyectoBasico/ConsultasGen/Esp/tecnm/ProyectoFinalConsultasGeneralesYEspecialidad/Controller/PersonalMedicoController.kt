package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonalMedicoEspecialidadService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonalMedicoService
import mx.tecnm.cdmadero.api.dtos.DtoMedico
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/personalMedico")
class PersonalMedicoController(
    private val service: PersonalMedicoService,
    private val especialidadService: PersonalMedicoEspecialidadService
) {

    @GetMapping("/lista-medicos")
    fun getAllMedicosView(model: Model): String {
        model.addAttribute("listaMedicos", service.findAllPersonalMedico())
        return "pages/medicos/historial-medicos"
    }

    @GetMapping("/form")
    fun getForm(model: Model): String {
        model.addAttribute("dtoMedico", DtoMedico())
        model.addAttribute("especialidades", especialidadService.findAllPersonalMedicoEspecialidad())
        return "pages/registerMedico"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute dto: DtoMedico): String {
        service.savePersonalMedico(dto)
        return "redirect:/personalMedico/lista-medicos"
    }
}
