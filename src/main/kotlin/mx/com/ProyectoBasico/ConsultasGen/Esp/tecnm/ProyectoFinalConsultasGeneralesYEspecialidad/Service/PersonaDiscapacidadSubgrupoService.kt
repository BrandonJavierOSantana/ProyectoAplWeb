package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonaDiscapacidadSubgrupo
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonaDiscapacidadSubgrupoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaDiscapacidadSubgrupoService(
    private val personaDiscapacidadSubgrupoRepository: PersonaDiscapacidadSubgrupoRepository
) {

    fun findAllPersonaDiscapacidadSubgrupo(): List<PersonaDiscapacidadSubgrupo> = personaDiscapacidadSubgrupoRepository.findAll()

    fun findPersonaDiscapacidadSubgrupoById(id: UUID): Optional<PersonaDiscapacidadSubgrupo> = personaDiscapacidadSubgrupoRepository.findById(id)

    fun savePersonaDiscapacidadSubgrupo(personaDiscapacidadSubgrupo: PersonaDiscapacidadSubgrupo): PersonaDiscapacidadSubgrupo = personaDiscapacidadSubgrupoRepository.save(personaDiscapacidadSubgrupo)

    fun deletePersonaDiscapacidadSubgrupo(id: UUID) = personaDiscapacidadSubgrupoRepository.deleteById(id)
}
