package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.PersonaRepository
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.DireccionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
class PersonaService(
    private val personaRepository: PersonaRepository,
    private val direccionRepository: DireccionRepository
) {

    fun findAllPersona(): List<Persona> = personaRepository.findAll()

    fun findPersonaById(id: UUID): Optional<Persona> = personaRepository.findById(id)

    @Transactional
    fun savePersona(persona: Persona): Persona {
        // Validar que exista una dirección asociada
        if (persona.direccion == null) {
            throw IllegalArgumentException("La dirección es obligatoria")
        }

        // Extracción de fecha y sexo desde CURP
        val curp = persona.curp
        val fechaCurp = curp.substring(4, 10) // AAMMDD
        val sexoChar = curp[10]             // H o M

        val anio = fechaCurp.substring(0, 2).toInt()
        val mes = fechaCurp.substring(2, 4).toInt()
        val dia = fechaCurp.substring(4, 6).toInt()
        val siglo = if (curp[16] == '0') 1900 else 2000
        val anioCompleto = siglo + anio
        val fechaNacimiento = LocalDate.of(anioCompleto, mes, dia)

        // Asignar IDs nuevos
        persona.id = UUID.randomUUID()
        persona.direccion.id = UUID.randomUUID()
        direccionRepository.save(persona.direccion)

        persona.fechaNacimiento = fechaNacimiento
        persona.sexo = if (sexoChar == 'H') 'M' else 'F'

        return personaRepository.save(persona)
    }

    fun deletePersona(id: UUID) = personaRepository.deleteById(id)

    fun findByNss(nss: String): Persona = personaRepository.findByNss(nss)
}
