package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaReligion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonaReligionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaReligionService(
    private val repository: PersonaReligionRepository
) {

    fun findAll(): List<PersonaReligion> = repository.findAll()

    fun findById(id: UUID): Optional<PersonaReligion> = repository.findById(id)

    fun save(entity: PersonaReligion): PersonaReligion = repository.save(entity)

    fun delete(id: UUID) = repository.deleteById(id)
}
