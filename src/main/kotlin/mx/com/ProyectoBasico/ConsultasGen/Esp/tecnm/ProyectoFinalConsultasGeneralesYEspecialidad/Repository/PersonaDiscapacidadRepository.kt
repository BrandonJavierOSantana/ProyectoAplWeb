package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaDiscapacidad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaDiscapacidadRepository : JpaRepository<PersonaDiscapacidad, UUID> {
}
