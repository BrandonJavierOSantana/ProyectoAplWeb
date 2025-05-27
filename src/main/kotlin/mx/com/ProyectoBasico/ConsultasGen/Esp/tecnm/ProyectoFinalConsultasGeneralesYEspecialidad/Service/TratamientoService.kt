package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Tratamiento
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.TratamientoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TratamientoService(
    private val repository: TratamientoRepository
) {

    fun findAll(): List<Tratamiento> = repository.findAll()

    fun findById(id: UUID): Optional<Tratamiento> = repository.findById(id)

    fun save(entity: Tratamiento): Tratamiento = repository.save(entity)

    fun delete(id: UUID) = repository.deleteById(id)
}
