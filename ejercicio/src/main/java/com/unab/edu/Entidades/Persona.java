package com.unab.edu.Entidades;

import java.util.Date;
import lombok.Data;

@Data
public class Persona {
    protected int idPersona;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String sexo;
    protected Date fecha;
}
