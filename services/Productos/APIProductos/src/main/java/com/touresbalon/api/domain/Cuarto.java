package com.touresbalon.api.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.Valid;

/**
 * Espacio, habitacion o lugar que pertenece a un hospedaje
 */
@ApiModel(description = "Espacio, habitacion o lugar que pertenece a un hospedaje")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-24T13:46:35.218-05:00[America/Bogota]")

public class Cuarto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("numeroCuarto")
  private String numeroCuarto;

  @JsonProperty("Cliente")
  private Cliente cliente;

  @JsonProperty("fechaReservaInicio")
  @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime fechaReservaInicio;

  @JsonProperty("fechaReservaFin")
  @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime fechaReservaFin;

  @JsonProperty("fechaReserva")
  @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  private LocalDateTime fechaReserva;

  public Cuarto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * identificador unico del cuarto
   * @return id
  */
  @ApiModelProperty(value = "identificador unico del cuarto")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cuarto numeroCuarto(String numeroCuarto) {
    this.numeroCuarto = numeroCuarto;
    return this;
  }

  /**
   * identificador unico del cuarto en el hospedaje
   * @return numeroCuarto
  */
  @ApiModelProperty(value = "identificador unico del cuarto en el hospedaje")


  public String getNumeroCuarto() {
    return numeroCuarto;
  }

  public void setNumeroCuarto(String numeroCuarto) {
    this.numeroCuarto = numeroCuarto;
  }

  public Cuarto cliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  /**
   * Get cliente
   * @return cliente
  */
  @ApiModelProperty(value = "")

  @Valid

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Cuarto fechaReservaInicio(LocalDateTime fechaReservaInicio) {
    this.fechaReservaInicio = fechaReservaInicio;
    return this;
  }

  /**
   * fecha de inicio de la reserva del cuarto
   * @return fechaReservaInicio
  */
  @ApiModelProperty(value = "fecha de inicio de la reserva del cuarto")

  @Valid

  public LocalDateTime getFechaReservaInicio() {
    return fechaReservaInicio;
  }

  public void setFechaReservaInicio(LocalDateTime fechaReservaInicio) {
    this.fechaReservaInicio = fechaReservaInicio;
  }

  public Cuarto fechaReservaFin(LocalDateTime fechaReservaFin) {
    this.fechaReservaFin = fechaReservaFin;
    return this;
  }

  /**
   * fecha de fin de la reserva del cuarto
   * @return fechaReservaFin
  */
  @ApiModelProperty(value = "fecha de fin de la reserva del cuarto")

  @Valid

  public LocalDateTime getFechaReservaFin() {
    return fechaReservaFin;
  }

  public void setFechaReservaFin(LocalDateTime fechaReservaFin) {
    this.fechaReservaFin = fechaReservaFin;
  }

  public Cuarto fechaReserva(LocalDateTime fechaReserva) {
    this.fechaReserva = fechaReserva;
    return this;
  }

  /**
   * fecha en que fue realizada la reserva
   * @return fechaReserva
  */
  @ApiModelProperty(value = "fecha en que fue realizada la reserva")

  @Valid

  public LocalDateTime getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(LocalDateTime fechaReserva) {
    this.fechaReserva = fechaReserva;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cuarto cuarto = (Cuarto) o;
    return Objects.equals(this.id, cuarto.id) &&
        Objects.equals(this.numeroCuarto, cuarto.numeroCuarto) &&
        Objects.equals(this.cliente, cuarto.cliente) &&
        Objects.equals(this.fechaReservaInicio, cuarto.fechaReservaInicio) &&
        Objects.equals(this.fechaReservaFin, cuarto.fechaReservaFin) &&
        Objects.equals(this.fechaReserva, cuarto.fechaReserva);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numeroCuarto, cliente, fechaReservaInicio, fechaReservaFin, fechaReserva);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cuarto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numeroCuarto: ").append(toIndentedString(numeroCuarto)).append("\n");
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("    fechaReservaInicio: ").append(toIndentedString(fechaReservaInicio)).append("\n");
    sb.append("    fechaReservaFin: ").append(toIndentedString(fechaReservaFin)).append("\n");
    sb.append("    fechaReserva: ").append(toIndentedString(fechaReserva)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

