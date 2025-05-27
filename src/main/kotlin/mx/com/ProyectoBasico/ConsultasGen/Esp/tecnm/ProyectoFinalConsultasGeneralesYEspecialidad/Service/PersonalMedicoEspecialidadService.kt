package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedicoEspecialidad
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonalMedicoEspecialidadRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonalMedicoEspecialidadService(
    private val personalMedicoEspecialidadRepository: PersonalMedicoEspecialidadRepository
) {

    fun findAllPersonalMedicoEspecialidad(): List<PersonalMedicoEspecialidad> = personalMedicoEspecialidadRepository.findAll()

    fun findPersonalMedicoEspecialidadById(id: UUID): Optional<PersonalMedicoEspecialidad> = personalMedicoEspecialidadRepository.findById(id)

    fun savePersonalMedicoEspecialidad(personalMedicoEspecialidad: PersonalMedicoEspecialidad): PersonalMedicoEspecialidad = personalMedicoEspecialidadRepository.save(personalMedicoEspecialidad)

    fun deletePersonalMedicoEspecialidad(id: UUID) = personalMedicoEspecialidadRepository.deleteById(id)
}