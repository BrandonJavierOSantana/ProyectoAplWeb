package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedicoEspecialidadSubespecialidad
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonalMedicoEspecialidadSubespecialidadRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonalMedicoEspecialidadSubespecialidadService(
    private val repository: PersonalMedicoEspecialidadSubespecialidadRepository
) {

    fun findAll(): List<PersonalMedicoEspecialidadSubespecialidad> = repository.findAll()

    fun findById(id: UUID): Optional<PersonalMedicoEspecialidadSubespecialidad> = repository.findById(id)

    fun save(entity: PersonalMedicoEspecialidadSubespecialidad): PersonalMedicoEspecialidadSubespecialidad = repository.save(entity)

    fun delete(id: UUID) = repository.deleteById(id)
}
