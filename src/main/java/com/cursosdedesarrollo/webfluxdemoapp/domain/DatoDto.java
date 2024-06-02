package com.cursosdedesarrollo.webfluxdemoapp.domain;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatoDto {
    @NotNull
    private String cadena;
}
