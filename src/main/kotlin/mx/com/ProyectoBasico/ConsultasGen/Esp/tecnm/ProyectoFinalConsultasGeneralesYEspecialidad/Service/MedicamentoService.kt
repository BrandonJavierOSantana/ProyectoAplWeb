package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Medicamento
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.MedicamentoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class MedicamentoService(
    private val medicamentoRepository: MedicamentoRepository
) {

    fun findAllMedicamento(): List<Medicamento> = medicamentoRepository.findAll()

    fun findMedicamentoById(id: UUID): Optional<Medicamento> = medicamentoRepository.findById(id)

    fun saveMedicamento(medicamento: Medicamento): Medicamento = medicamentoRepository.save(medicamento)

    fun deleteMedicamento(id: UUID) = medicamentoRepository.deleteById(id)
}
