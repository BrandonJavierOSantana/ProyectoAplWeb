package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services.PersonaService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("/admin")
class AdminController(
    private val personaService: PersonaService
) {

    @GetMapping("/administradores")
    fun administradores(): String = "pages/admin/administradores"

    @GetMapping("/registrar-admin")
    fun showRegistrarForm(model: Model): String {
        model.addAttribute("persona", Persona())
        return "pages/admin/registrar-admin"
    }

    @PostMapping("/registrar-admin")
    fun registrarAdmin(
        @ModelAttribute("persona") persona: Persona,
        bindingResult: BindingResult,
        redirectAttrs: RedirectAttributes
    ): String {
        if (bindingResult.hasErrors()) {
            return "pages/admin/registrar-admin"
        }
        // Establecer rol
        persona.rol = "ADMIN"

        personaService.savePersona(persona)
        redirectAttrs.addFlashAttribute("success", "Administrador registrado con éxito!")
        return "redirect:/admin/administradores"
    }
}