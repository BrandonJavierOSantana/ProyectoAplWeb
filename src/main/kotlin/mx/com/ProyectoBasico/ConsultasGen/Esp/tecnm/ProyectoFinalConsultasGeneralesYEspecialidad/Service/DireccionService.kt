package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Direccion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.DireccionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DireccionService(
    private val direccionRepository: DireccionRepository
) {

    fun findAllDireccion(): List<Direccion> = direccionRepository.findAll()

    fun findDireccionById(id: UUID): Optional<Direccion> = direccionRepository.findById(id)

    fun saveDireccion(direccion: Direccion): Direccion = direccionRepository.save(direccion)

    fun deleteDireccion(id: UUID) = direccionRepository.deleteById(id)
}