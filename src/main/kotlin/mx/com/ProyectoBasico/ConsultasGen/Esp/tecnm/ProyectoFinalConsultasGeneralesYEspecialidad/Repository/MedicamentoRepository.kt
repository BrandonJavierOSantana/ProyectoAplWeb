package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Medicamento
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MedicamentoRepository : JpaRepository<Medicamento, UUID> {
}
