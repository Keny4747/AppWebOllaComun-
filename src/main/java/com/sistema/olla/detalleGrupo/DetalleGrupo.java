package com.sistema.olla.detalleGrupo;

import com.sistema.olla.grupo.Grupo;
import com.sistema.olla.voluntario.Voluntario;

import javax.persistence.*;

@Entity
@Table(name = "detalle_grupo")
public class DetalleGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "voluntarioid", nullable = false)
    private Voluntario voluntarioid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grupoid", nullable = false)
    private Grupo grupoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voluntario getVoluntarioid() {
        return voluntarioid;
    }

    public void setVoluntarioid(Voluntario voluntarioid) {
        this.voluntarioid = voluntarioid;
    }

    public Grupo getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(Grupo grupoid) {
        this.grupoid = grupoid;
    }



}