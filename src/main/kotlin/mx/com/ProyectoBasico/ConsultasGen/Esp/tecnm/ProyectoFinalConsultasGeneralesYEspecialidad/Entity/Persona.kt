package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*

@Entity
@Table(name = "Persona")
data class Persona(
    @Id
    @Column(name = "id", nullable = false)
    var id: UUID? = null,

    @Column(name = "nombre", nullable = false, length = 50)
    var nombre: String = "",

    @Column(name = "apellido_paterno", nullable = false, length = 20)
    var apellidoPaterno: String = "",

    @Column(name = "apellido_materno", nullable = false, length = 20)
    var apellidoMaterno: String = "",

    @Column(name = "curp", nullable = false, length = 18)
    var curp: String = "",

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_sanguineo", nullable = false)
    var tipoSanguineo: PersonaTipoSanguineo,

    @Column(name = "grupo_etnico", nullable = false, length = 20)
    var grupoEtnico: String = "",

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_religion", nullable = false)
    var religion: PersonaReligion,

    @Column(name = "nss", nullable = false, length = 10)
    var nss: String = "",

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_direccion", nullable = false)
    var direccion: Direccion,

    @Column(name = "fecha_nacimiento", nullable = false)
    var fechaNacimiento: LocalDate,

    @Column(name = "institucion", nullable = false, length = 50)
    var institucion: String = "",

    @Column(name = "nivel_socioeconomico", nullable = false, length = 20)
    var nivelSocioeconomico: String = "",

    @Column(name = "telefono", nullable = false, length = 10)
    var telefono: String = "",

    @Column(name = "contrasena", nullable = false, length = 255)
    var contrasena: String = "",

    @Column(name = "sexo", nullable = false, length = 1)
    var sexo: Char? = null,

    @Column(name = "rol", nullable = false, length = 20)
    var rol: String = "USER"
)

