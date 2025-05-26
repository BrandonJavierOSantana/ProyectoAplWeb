package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Controller

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/login")
    fun login(): String {
        return "pages/login"
    }

    @GetMapping("/home")
    fun home(auth: Authentication): String {
        return if (auth.authorities.any { it.authority == "ROLE_ADMIN" }) {
            "pages/admin/home"
        } else {
            "pages/user/home"
        }
    }
    @GetMapping("/admin/home")
    fun adminHome(): String = "pages/admin/home"

    @GetMapping("/user/home")
    fun userHome(): String = "pages/user/home"
}
