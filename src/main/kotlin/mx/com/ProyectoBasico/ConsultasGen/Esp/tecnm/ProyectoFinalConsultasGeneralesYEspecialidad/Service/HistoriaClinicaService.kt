package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.HistoriaClinica
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.HistoriaClinicaRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class HistoriaClinicaService(
    private val historiaClinicaRepository: HistoriaClinicaRepository
) {

    fun findAllHistoriaClinica(): List<HistoriaClinica> = historiaClinicaRepository.findAll()

    fun findHistoriaClinicaById(id: UUID): Optional<HistoriaClinica> = historiaClinicaRepository.findById(id)

    fun saveHistoriaClinica(historiaClinica: HistoriaClinica): HistoriaClinica = historiaClinicaRepository.save(historiaClinica)

    fun deleteHistoriaClinica(id: UUID) = historiaClinicaRepository.deleteById(id)
}