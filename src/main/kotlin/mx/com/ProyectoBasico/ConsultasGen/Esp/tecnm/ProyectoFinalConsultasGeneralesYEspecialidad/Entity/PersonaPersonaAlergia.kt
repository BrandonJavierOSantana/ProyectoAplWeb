package mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity

import jakarta.persistence.*
import mx.com.ProyectoBasico.ConsultasGen.Esp.tecnm.ProyectoFinalConsultasGeneralesYEspecialidad.Entity.keys.PersonaPersonaAlergiaId


@Entity
@Table(name = "\"Persona_Persona.Alergia\"")
open class PersonaPersonaAlergia {
    @EmbeddedId
    open var id: PersonaPersonaAlergiaId? = null

    @MapsId("idPersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    open var idPersona: Persona? = null

    @MapsId("idPersonaAlergia")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona_alergia", nullable = false)
    open var idPersonaAlergia: PersonaAlergia? = null
}