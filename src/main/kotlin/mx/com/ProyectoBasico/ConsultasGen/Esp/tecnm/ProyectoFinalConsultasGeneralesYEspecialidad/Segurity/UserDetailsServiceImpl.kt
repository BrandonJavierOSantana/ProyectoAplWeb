package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Segurity

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Repository.PersonaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val personaRepository: PersonaRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val persona = personaRepository.findByCurp(username)
            ?: throw UsernameNotFoundException("CURP no encontrado")
        return UserDetailsImpl(persona)
    }
}
