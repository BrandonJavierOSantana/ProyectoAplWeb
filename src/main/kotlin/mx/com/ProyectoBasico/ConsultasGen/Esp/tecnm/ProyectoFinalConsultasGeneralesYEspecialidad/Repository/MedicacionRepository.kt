package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Medicacion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MedicacionRepository : JpaRepository<Medicacion, UUID> {
}