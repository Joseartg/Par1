package com.unab.edu.Entidades;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class Estudiante extends Persona {
    private int Id;
    private int matricula;
    private String usu;
    private String pass;
    private int nie;
}
