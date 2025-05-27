package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.SignosVitales
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.SignosVitalesRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SignosVitalesService(
    private val repository: SignosVitalesRepository
) {

    fun findAll(): List<SignosVitales> = repository.findAll()

    fun findById(id: UUID): Optional<SignosVitales> = repository.findById(id)

    fun save(entity: SignosVitales): SignosVitales = repository.save(entity)

    fun delete(id: UUID) = repository.deleteById(id)
}
