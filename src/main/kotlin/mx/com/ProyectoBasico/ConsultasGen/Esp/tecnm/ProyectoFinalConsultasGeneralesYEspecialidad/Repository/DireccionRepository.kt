package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Direccion
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DireccionRepository : JpaRepository<Direccion, UUID> {
}
