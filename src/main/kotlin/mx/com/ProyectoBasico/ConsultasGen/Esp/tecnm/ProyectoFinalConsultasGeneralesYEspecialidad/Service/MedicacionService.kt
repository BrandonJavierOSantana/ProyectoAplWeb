package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Medicacion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.MedicacionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MedicacionService(
    private val medicacionRepository: MedicacionRepository
) {

    fun findAllMedicacion(): List<Medicacion> = medicacionRepository.findAll()

    fun findMedicacionById(id: UUID): Optional<Medicacion> = medicacionRepository.findById(id)

    fun saveMedicacion(medicacion: Medicacion): Medicacion = medicacionRepository.save(medicacion)

    fun deleteMedicacion(id: UUID) = medicacionRepository.deleteById(id)
}