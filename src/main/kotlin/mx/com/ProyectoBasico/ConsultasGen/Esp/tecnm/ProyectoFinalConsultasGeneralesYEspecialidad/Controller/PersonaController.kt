package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaReligionService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaTipoSanguineoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.DireccionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@Controller
@RequestMapping("/persona")
class PersonaController(
    private val personaService: PersonaService,
    private val tipoSanguineoService: PersonaTipoSanguineoService,
    private val religionService: PersonaReligionService,
    private val direccionService: DireccionService
) {

    @GetMapping("/list")
    fun listAll(model: Model): String {
        model.addAttribute("listaPersonas", personaService.findAllPersona())
        return "pages/persona/list"
    }

    @GetMapping("/form")
    fun showForm(model: Model): String {
        model.addAttribute("persona", Persona())
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAll())
        model.addAttribute("religiones", religionService.findAll())
        model.addAttribute("direcciones", direccionService.findAllDireccion())
        return "pages/persona/form"
    }

    @PostMapping("/new")
    fun create(@ModelAttribute persona: Persona): String {
        persona.id = UUID.randomUUID()
        personaService.savePersona(persona)
        return "redirect:/persona/list"
    }

    @GetMapping("/edit/{id}")
    fun editForm(@PathVariable id: UUID, model: Model): String {
        val persona = personaService.findPersonaById(id).orElse(Persona())
        model.addAttribute("persona", persona)
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAll())
        model.addAttribute("religiones", religionService.findAll())
        model.addAttribute("direcciones", direccionService.findAllDireccion())
        return "pages/persona/form"
    }

    @PostMapping("/update")
    fun update(@ModelAttribute persona: Persona): String {
        personaService.savePersona(persona)
        return "redirect:/persona/list"
    }

    @GetMapping("/details/{id}")
    fun details(@PathVariable id: UUID, model: Model): String {
        model.addAttribute("persona", personaService.findPersonaById(id).orElse(null))
        return "pages/persona/details"
    }

    @PostMapping("/delete/{id}")
    fun delete(@PathVariable id: UUID): String {
        personaService.deletePersona(id)
        return "redirect:/persona/list"
    }
}
