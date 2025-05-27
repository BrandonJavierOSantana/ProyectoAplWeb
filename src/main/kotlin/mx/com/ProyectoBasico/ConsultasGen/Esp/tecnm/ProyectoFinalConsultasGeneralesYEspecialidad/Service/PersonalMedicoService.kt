package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.dtos.DtoMedico
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedico
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonaRepository
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonalMedicoRepository
import mx.tecnm.cdmadero.api.dtos.DtoMedico
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class PersonalMedicoService(
    private val personalMedicoRepository: PersonalMedicoRepository,
    private val personaRepository: PersonaRepository
) {

    fun findAllPersonalMedico(): List<PersonalMedico> = personalMedicoRepository.findAll()

    fun findPersonalMedicoById(id: UUID): Optional<PersonalMedico> = personalMedicoRepository.findById(id)

    @Transactional
    fun savePersonalMedico(dto: DtoMedico): PersonalMedico {
        val persona = personaRepository.findByCurp(dto.curp)
            ?: throw IllegalArgumentException("Persona con CURP ${dto.curp} no existe")

        val medico = dto.medico.apply { this.persona = persona }
        return personalMedicoRepository.save(medico)
    }

    fun deletePersonalMedico(id: UUID) = personalMedicoRepository.deleteById(id)
}
