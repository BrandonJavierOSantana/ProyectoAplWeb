package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Interrogatorio
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.InterrogatorioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InterrogatorioService(
    private val interrogatorioRepository: InterrogatorioRepository
) {

    fun findAllInterrogatorio(): List<Interrogatorio> = interrogatorioRepository.findAll()

    fun findInterrogatorioById(id: UUID): Optional<Interrogatorio> = interrogatorioRepository.findById(id)

    fun saveInterrogatorio(interrogatorio: Interrogatorio): Interrogatorio = interrogatorioRepository.save(interrogatorio)

    fun deleteInterrogatorio(id: UUID) = interrogatorioRepository.deleteById(id)
}