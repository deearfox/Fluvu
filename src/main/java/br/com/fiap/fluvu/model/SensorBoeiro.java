package br.com.fiap.fluvu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class SensorBoeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(length = 200, nullable = false)
    public String status;

    @Column(length = 200, nullable = false)
    public String alerta;

    @Column(length = 10, nullable = false)
    public double volume;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "central_id", nullable = false)
    private Central central;

    public static Object getIdSensorBoeiro() {
        return null;
    }

}