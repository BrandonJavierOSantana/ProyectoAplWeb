package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeEvolucion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.NotaDeEvolucionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class NotaDeEvolucionService(
    private val notaDeEvolucionRepository: NotaDeEvolucionRepository
) {

    fun findAllNotaDeEvolucion(): List<NotaDeEvolucion> = notaDeEvolucionRepository.findAll()

    fun findNotaDeEvolucionById(id: UUID): Optional<NotaDeEvolucion> = notaDeEvolucionRepository.findById(id)

    fun saveNotaDeEvolucion(notaDeEvolucion: NotaDeEvolucion): NotaDeEvolucion = notaDeEvolucionRepository.save(notaDeEvolucion)

    fun deleteNotaDeEvolucion(id: UUID) = notaDeEvolucionRepository.deleteById(id)
}