package br.com.unifalmg.hotel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "railway", name = "guest")
public class Guest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_guest")
    private Integer id_guest;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "status")
    private Integer status;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "cellphone")
    private String cellphone;

}
