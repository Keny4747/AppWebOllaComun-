package com.sistema.olla.detalleOllaGrupo;

import com.sistema.olla.beneficiario.Olla;
import com.sistema.olla.grupo.Grupo;

import javax.persistence.*;

@Entity
@Table(name = "detalle_ollagrupo")
public class DetalleOllagrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ollaid", nullable = false)
    private Olla ollaid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grupoid", nullable = false)
    private Grupo grupoid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Olla getOllaid() {
        return ollaid;
    }

    public void setOllaid(Olla ollaid) {
        this.ollaid = ollaid;
    }

    public Grupo getGrupoid() {
        return grupoid;
    }

    public void setGrupoid(Grupo grupoid) {
        this.grupoid = grupoid;
    }

}