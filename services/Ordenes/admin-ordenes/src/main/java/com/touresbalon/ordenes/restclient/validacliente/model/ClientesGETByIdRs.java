package com.touresbalon.ordenes.restclient.validacliente.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.touresbalon.ordenes.api.model.Cliente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Respuesta a la consulta de un cliente por Id
 */
@ApiModel(description = "Respuesta a la consulta de un cliente por Id")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-04-09T13:17:10.375-05:00[America/Bogota]")

public class ClientesGETByIdRs {
  @JsonProperty("cliente")
  private Cliente cliente = null;

  public ClientesGETByIdRs cliente(Cliente cliente) {
    this.cliente = cliente;
    return this;
  }

  /**
   * Get cliente
   * @return cliente
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientesGETByIdRs clientesGETByIdRs = (ClientesGETByIdRs) o;
    return Objects.equals(this.cliente, clientesGETByIdRs.cliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cliente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientesGETByIdRs {\n");
    
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

