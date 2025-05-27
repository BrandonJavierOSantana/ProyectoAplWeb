package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeInterconsulta
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.NotaDeInterconsultaRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class NotaDeInterconsultaService(
    private val notaDeInterconsultaRepository: NotaDeInterconsultaRepository
) {

    fun findAllNotaDeInterconsulta(): List<NotaDeInterconsulta> = notaDeInterconsultaRepository.findAll()

    fun findNotaDeInterconsultaById(id: UUID): Optional<NotaDeInterconsulta> = notaDeInterconsultaRepository.findById(id)

    fun saveNotaDeInterconsulta(notaDeInterconsulta: NotaDeInterconsulta): NotaDeInterconsulta = notaDeInterconsultaRepository.save(notaDeInterconsulta)

    fun deleteNotaDeInterconsulta(id: UUID) = notaDeInterconsultaRepository.deleteById(id)
}
