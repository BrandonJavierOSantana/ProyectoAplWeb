package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.dtos

import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.ConsultaGeneral
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.HistoriaClinica
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.ExploracionFisica
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.SignosVitales
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Interrogatorio
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeEvolucion
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Tratamiento
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeReferenciaTraslado
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeInterconsulta

data class DtoConsulta(
    val curpPaciente: String = "",
    val cedulaMedico: String = "",
    val consulta: ConsultaGeneral = ConsultaGeneral().apply {
        idHistoriaClinica = HistoriaClinica().apply {
            idExploracionFisica = ExploracionFisica().apply {
                idSignosVitales = SignosVitales()
            }
            idInterrogatorio = Interrogatorio()
        }
        idNotaDeEvolucion = NotaDeEvolucion().apply {
            idSignosVitales = SignosVitales()
            idTratamiento = Tratamiento()
        }
        idNotaDeTraslado = NotaDeReferenciaTraslado()  // no necesita configuración adicional
        idNotaDeInterconsulta = NotaDeInterconsulta().apply {
            idTratamiento = Tratamiento()
            idSignosVitales = SignosVitales()
            idExploracionFisica = ExploracionFisica()
        }
    }
)
