package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.Instant
import java.util.*

@Entity
@Table(name = "Consulta_General")
open class ConsultaGeneral {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personal_medico", nullable = false)
    open var idPersonalMedico: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.PersonalMedico? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_historia_clinica", nullable = false)
    open var idHistoriaClinica: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.HistoriaClinica? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nota_de_evolucion", nullable = false)
    open var idNotaDeEvolucion: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeEvolucion? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nota_de_interconsulta", nullable = false)
    open var idNotaDeInterconsulta: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeInterconsulta? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_nota_de_traslado", nullable = false)
    open var idNotaDeTraslado: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.NotaDeReferenciaTraslado? = null

    @Column(name = "fecha_hora", nullable = false)
    open var fechaHora: Instant? = null
}