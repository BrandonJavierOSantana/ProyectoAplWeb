package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.util.*

@Entity
@Table(name = "Historia_Clinica")
open class HistoriaClinica {
    @Id
    @ColumnDefault("newid()")
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_exploracion_fisica", nullable = false)
    open var idExploracionFisica: ExploracionFisica? = null

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_interrogatorio", nullable = false)
    open var idInterrogatorio: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Interrogatorio? = null

    @Column(name = "resultados_estudios_previos", nullable = false, length = 150)
    open var resultadosEstudiosPrevios: String? = null

    @Column(name = "resultados_estudios_actuales", nullable = false, length = 150)
    open var resultadosEstudiosActuales: String? = null

    @Column(name = "diagnostico", nullable = false, length = 150)
    open var diagnostico: String? = null

    @Column(name = "pronostico", nullable = false, length = 150)
    open var pronostico: String? = null

    @Column(name = "indicacion_terapeutica", nullable = false, length = 150)
    open var indicacionTerapeutica: String? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.Persona? = null
}