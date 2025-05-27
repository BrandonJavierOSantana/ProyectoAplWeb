package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.services

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.InstalacionPersonalMedico
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.repositories.InstalacionPersonalMedicoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class InstalacionPersonalMedicoService(
    private val instalacionPersonalMedicoRepository: InstalacionPersonalMedicoRepository
) {

    fun findAllInstalacionPersonalMedico(): List<InstalacionPersonalMedico> = instalacionPersonalMedicoRepository.findAll()

    fun findInstalacionPersonalMedicoById(id: UUID): Optional<InstalacionPersonalMedico> = instalacionPersonalMedicoRepository.findById(id)

    fun saveInstalacionPersonalMedico(instalacionPersonalMedico: InstalacionPersonalMedico): InstalacionPersonalMedico = instalacionPersonalMedicoRepository.save(instalacionPersonalMedico)

    fun deleteInstalacionPersonalMedico(id: UUID) = instalacionPersonalMedicoRepository.deleteById(id)
}
