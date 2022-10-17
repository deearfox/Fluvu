package br.com.fiap.fluvu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Central {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(length = 200, nullable = false)
    public String nome;

    @Column(length = 200, nullable = false)
    public String cnpj;

    @Column(length = 200, nullable = false)
    public String acao;

    public static Object getIdCentral() {
        return null;
    }

}
