package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaTipoSanguineo
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonaTipoSanguineoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaTipoSanguineoService(
    private val repository: PersonaTipoSanguineoRepository
) {

    fun findAll(): List<PersonaTipoSanguineo> = repository.findAll()

    fun findById(id: UUID): Optional<PersonaTipoSanguineo> = repository.findById(id)

    fun save(entity: PersonaTipoSanguineo): PersonaTipoSanguineo = repository.save(entity)

    fun delete(id: UUID) = repository.deleteById(id)
}
