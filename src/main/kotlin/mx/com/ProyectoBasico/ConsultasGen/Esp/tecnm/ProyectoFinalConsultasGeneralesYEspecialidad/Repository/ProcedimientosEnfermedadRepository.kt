package mx.tecnm.cdmadero.api.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.ProcedimientosEnfermedad
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProcedimientosEnfermedadRepository : JpaRepository<ProcedimientosEnfermedad, UUID> {
}