package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.DireccionEstado
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.DireccionEstadoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DireccionEstadoService(
    private val direccionEstadoRepository: DireccionEstadoRepository
) {

    fun findAllDireccionEstado(): List<DireccionEstado> = direccionEstadoRepository.findAll()

    fun findDireccionEstadoById(id: UUID): Optional<DireccionEstado> = direccionEstadoRepository.findById(id)

    fun saveDireccionEstado(direccionEstado: DireccionEstado): DireccionEstado = direccionEstadoRepository.save(direccionEstado)

    fun deleteDireccionEstado(id: UUID) = direccionEstadoRepository.deleteById(id)
}