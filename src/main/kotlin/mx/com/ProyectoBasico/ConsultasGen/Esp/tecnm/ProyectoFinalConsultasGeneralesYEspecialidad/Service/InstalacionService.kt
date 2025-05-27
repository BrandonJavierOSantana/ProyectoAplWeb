package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Instalacion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.InstalacionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InstalacionService(
    private val instalacionRepository: InstalacionRepository
) {

    fun findAllInstalacion(): List<Instalacion> = instalacionRepository.findAll()

    fun findInstalacionById(id: UUID): Optional<Instalacion> = instalacionRepository.findById(id)

    fun saveInstalacion(instalacion: Instalacion): Instalacion = instalacionRepository.save(instalacion)

    fun deleteInstalacion(id: UUID) = instalacionRepository.deleteById(id)
}