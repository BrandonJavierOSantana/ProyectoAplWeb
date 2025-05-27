package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.InstalacionPersonalMedico
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface InstalacionPersonalMedicoRepository : JpaRepository<InstalacionPersonalMedico, UUID> {
}
