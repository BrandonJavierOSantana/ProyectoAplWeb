package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeEvolucion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NotaDeEvolucionRepository : JpaRepository<NotaDeEvolucion, UUID> {
}
