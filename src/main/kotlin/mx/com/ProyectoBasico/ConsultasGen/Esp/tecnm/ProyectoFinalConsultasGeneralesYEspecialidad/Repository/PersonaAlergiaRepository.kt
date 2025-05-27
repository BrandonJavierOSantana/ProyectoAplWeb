package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaAlergia
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaAlergiaRepository : JpaRepository<PersonaAlergia, UUID> {
}
