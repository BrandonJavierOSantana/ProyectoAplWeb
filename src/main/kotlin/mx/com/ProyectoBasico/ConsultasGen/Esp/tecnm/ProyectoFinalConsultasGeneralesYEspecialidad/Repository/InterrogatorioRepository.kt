package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Interrogatorio
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface InterrogatorioRepository : JpaRepository<Interrogatorio, UUID> {
}
