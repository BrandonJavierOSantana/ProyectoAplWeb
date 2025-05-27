package mx.tecnm.cdmadero.api.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.EnfermedadesDegenerativa
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EnfermedadesDegenerativaRepository : JpaRepository<EnfermedadesDegenerativa, UUID> {
}