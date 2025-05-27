package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaReligion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaTipoSanguineo
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Direccion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaReligionService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaTipoSanguineoService
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.DireccionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
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
        val persona = Persona(
            id = null,
            nombre = "",
            apellidoPaterno = "",
            apellidoMaterno = "",
            curp = "",
            tipoSanguineo = PersonaTipoSanguineo(),
            grupoEtnico = "",
            religion = PersonaReligion(),
            nss = "",
            direccion = Direccion(),
            fechaNacimiento = LocalDate.now(),
            institucion = "",
            nivelSocioeconomico = "",
            telefono = "",
            contrasena = "",
            sexo = 'M',
            rol = "USER"
        )
        model.addAttribute("persona", persona)
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAllPersonaTipoSanguineo())
        model.addAttribute("religiones", religionService.findAllPersonaReligion())
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
        val persona = personaService.findPersonaById(id).orElse(Persona(
            id = id, nombre = "", apellidoPaterno = "", apellidoMaterno = "", curp = "",
            tipoSanguineo = PersonaTipoSanguineo(), grupoEtnico = "", religion = PersonaReligion(), nss = "",
            direccion = Direccion(), fechaNacimiento = LocalDate.now(), institucion = "", nivelSocioeconomico = "",
            telefono = "", contrasena = "", sexo = 'M', rol = "USER"
        ))
        model.addAttribute("persona", persona)
        model.addAttribute("tiposSanguineos", tipoSanguineoService.findAllPersonaTipoSanguineo())
        model.addAttribute("religiones", religionService.findAllPersonaReligion())
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
