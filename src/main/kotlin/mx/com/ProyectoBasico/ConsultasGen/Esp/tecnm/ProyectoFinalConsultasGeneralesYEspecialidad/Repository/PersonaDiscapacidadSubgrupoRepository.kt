package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaDiscapacidadSubgrupo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PersonaDiscapacidadSubgrupoRepository : JpaRepository<PersonaDiscapacidadSubgrupo, UUID> {
}
