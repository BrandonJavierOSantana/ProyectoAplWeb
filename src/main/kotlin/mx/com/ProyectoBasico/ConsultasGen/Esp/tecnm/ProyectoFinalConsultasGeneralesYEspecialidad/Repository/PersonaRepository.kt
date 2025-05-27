package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PersonaRepository : JpaRepository<Persona, UUID> {
    fun findByCurpAndContrasena(curp: String, contrasena: String): Persona?
    fun findByCurp(curp: String): Persona?
    fun findByNss(nss: String): Persona
}
