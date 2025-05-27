package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeInterconsulta
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NotaDeInterconsultaRepository : JpaRepository<NotaDeInterconsulta, UUID> {
}