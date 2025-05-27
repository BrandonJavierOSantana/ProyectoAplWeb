package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Service

import mx.tecnm.cdmadero.api.dtos.DtoConsulta
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.ConsultaGeneral
import mx.tecnm.cdmadero.api.repositories.*
import mx.tecnm.cdmadero.api.services.ExploracionFisicaService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.Instant
import java.util.*

@Service
@Transactional
class ConsultaGeneralService(
    private val consultaGeneralRepository: ConsultaGeneralRepository,
    private val personaRepository: PersonaRepository,
    private val personalMedicoRepository: PersonalMedicoRepository,
    private val historiaClinicaRepository: HistoriaClinicaRepository,
    private val notaDeEvolucionRepository: NotaDeEvolucionRepository,
    private val notaDeReferenciaTrasladoRepository: NotaDeReferenciaTrasladoRepository,
    private val notaDeInterconsultaRepository: NotaDeInterconsultaRepository,
    private val exploracionFisicaService: ExploracionFisicaService,
    private val signosVitalesRepository: SignosVitalesRepository,
    private val interrogatorioRepository: InterrogatorioRepository,
    private val tratamientoRepository: TratamientoRepository,
) {

    fun findAll(): List<ConsultaGeneral> = consultaGeneralRepository.findAll()

    fun findById(id: UUID): Optional<ConsultaGeneral> =
        consultaGeneralRepository.findById(id)

    @Transactional
    fun save(consultaGeneral: DtoConsulta): ConsultaGeneral{
        val paciente = personaRepository.findByCurp(consultaGeneral.curpPaciente)
        val medico = personalMedicoRepository.findByCedula(consultaGeneral.cedulaMedico)
        //crear verificacion de que un doctor no se automedique

        val consulta = consultaGeneral.consulta
        consulta.apply {
            id = UUID.randomUUID()
            idPersona = paciente
            idPersonalMedico = medico
            fechaHora = Instant.now()
        }

        // guardado de historia clinica
        consulta.idHistoriaClinica!!.id = UUID.randomUUID()
        consulta.idHistoriaClinica!!.idInterrogatorio!!.id = UUID.randomUUID()
        consulta.idHistoriaClinica!!.idExploracionFisica!!.id = UUID.randomUUID()
        consulta.idHistoriaClinica!!.idExploracionFisica!!.idSignosVitales!!.id = UUID.randomUUID()

        consulta.idHistoriaClinica!!.idPersona = paciente

        signosVitalesRepository.save(consulta.idHistoriaClinica!!.idExploracionFisica!!.idSignosVitales!!)
        exploracionFisicaService.saveExploracionFisica(consulta.idHistoriaClinica!!.idExploracionFisica!!)
        interrogatorioRepository.save(consulta.idHistoriaClinica!!.idInterrogatorio!!)
        historiaClinicaRepository.save(consulta.idHistoriaClinica!!)

        // guardado de nota de evoluvion
        consulta.idNotaDeEvolucion!!.id = UUID.randomUUID()
        consulta.idNotaDeEvolucion!!.idSignosVitales!!.id = UUID.randomUUID()
        consulta.idNotaDeEvolucion!!.idTratamiento!!.id = UUID.randomUUID()

        signosVitalesRepository.save(consulta.idNotaDeEvolucion!!.idSignosVitales!!)
        tratamientoRepository.save(consulta.idNotaDeEvolucion!!.idTratamiento!!)
        notaDeEvolucionRepository.save(consulta.idNotaDeEvolucion!!)

        // guardado de interconsulta
        consulta.idNotaDeInterconsulta!!.id = UUID.randomUUID()
        consulta.idNotaDeInterconsulta!!.idTratamiento = consulta.idNotaDeEvolucion!!.idTratamiento!!
        consulta.idNotaDeInterconsulta!!.idSignosVitales = consulta.idNotaDeEvolucion!!.idSignosVitales!!
        consulta.idNotaDeInterconsulta!!.idExploracionFisica = consulta.idHistoriaClinica!!.idExploracionFisica!!

        consulta.idNotaDeInterconsulta!!.fechaHora = Instant.now()

        notaDeInterconsultaRepository.save(consulta.idNotaDeInterconsulta!!)

        // guardado de nota de traslado
        consulta.idNotaDeTraslado!!.id = UUID.randomUUID()

        notaDeReferenciaTrasladoRepository.save(consulta.idNotaDeTraslado!!)

        return consultaGeneralRepository.save(consulta)
    }

    fun delete(id: UUID) =
        consultaGeneralRepository.deleteById(id)
}
