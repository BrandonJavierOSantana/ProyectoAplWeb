package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaPersonaAlergia
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.keys.PersonaPersonaAlergiaId
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonaPersonaAlergiaRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaPersonaAlergiaService(
    private val repository: PersonaPersonaAlergiaRepository
) {

    fun findAll(): List<PersonaPersonaAlergia> = repository.findAll()

    fun findById(id: PersonaPersonaAlergiaId): Optional<PersonaPersonaAlergia> = repository.findById(id)

    fun save(entity: PersonaPersonaAlergia): PersonaPersonaAlergia = repository.save(entity)

    fun delete(id: PersonaPersonaAlergiaId) = repository.deleteById(id)
}
