package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedicoEspecialidad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonalMedicoEspecialidadRepository : JpaRepository<PersonalMedicoEspecialidad, UUID> {
}
