package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.DireccionEstado
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DireccionEstadoRepository : JpaRepository<DireccionEstado, UUID> {
}