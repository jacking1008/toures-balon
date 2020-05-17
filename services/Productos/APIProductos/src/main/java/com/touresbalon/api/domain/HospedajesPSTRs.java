package com.touresbalon.api.domain;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.touresbalon.api.domain.Hospedaje;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Respuesta de creación de un hospedaje.
 */
@ApiModel(description = "Respuesta de creación de un hospedaje.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-05-10T10:11:38.301-05:00[America/Bogota]")

public class HospedajesPSTRs   {
  @JsonProperty("hospedaje")
  private Hospedaje hospedaje = null;

  public HospedajesPSTRs hospedaje(Hospedaje hospedaje) {
    this.hospedaje = hospedaje;
    return this;
  }

  /**
   * Get hospedaje
   * @return hospedaje
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Hospedaje getHospedaje() {
    return hospedaje;
  }

  public void setHospedaje(Hospedaje hospedaje) {
    this.hospedaje = hospedaje;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HospedajesPSTRs hospedajesPSTRs = (HospedajesPSTRs) o;
    return Objects.equals(this.hospedaje, hospedajesPSTRs.hospedaje);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hospedaje);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HospedajesPSTRs {\n");
    
    sb.append("    hospedaje: ").append(toIndentedString(hospedaje)).append("\n");
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

