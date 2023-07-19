package com.ltech.Entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "Clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private String telefonoCliente;
    private String descripcionCliente;
    @Column(columnDefinition = "bit default 0")
    private Boolean atendido;
}
