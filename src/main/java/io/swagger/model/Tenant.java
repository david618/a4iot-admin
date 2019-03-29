package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Tenant
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-28T18:55:48.493Z")

public class Tenant   {
  @JsonProperty("a4iot-build-num")
  private String a4iotBuildNum = null;

  /**
   * Gets or Sets location
   */
  public enum LocationEnum {
    WESTUS2("westus2"),
    
    EASTUS2("eastus2");

    private String value;

    LocationEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static LocationEnum fromValue(String text) {
      for (LocationEnum b : LocationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("location")
  private LocationEnum location = null;

  /**
   * Gets or Sets azureCoresPerInstance
   */
  public enum AzureCoresPerInstanceEnum {
    _8("8"),
    
    _16("16"),
    
    _32("32"),
    
    _64("64");

    private String value;

    AzureCoresPerInstanceEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AzureCoresPerInstanceEnum fromValue(String text) {
      for (AzureCoresPerInstanceEnum b : AzureCoresPerInstanceEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("azure-cores-per-instance")
  private AzureCoresPerInstanceEnum azureCoresPerInstance = null;

  @JsonProperty("azure-num-instances")
  private Integer azureNumInstances = null;

  public Tenant a4iotBuildNum(String a4iotBuildNum) {
    this.a4iotBuildNum = a4iotBuildNum;
    return this;
  }

  /**
   * Get a4iotBuildNum
   * @return a4iotBuildNum
  **/
  @ApiModelProperty(value = "")


  public String getA4iotBuildNum() {
    return a4iotBuildNum;
  }

  public void setA4iotBuildNum(String a4iotBuildNum) {
    this.a4iotBuildNum = a4iotBuildNum;
  }

  public Tenant location(LocationEnum location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")


  public LocationEnum getLocation() {
    return location;
  }

  public void setLocation(LocationEnum location) {
    this.location = location;
  }

  public Tenant azureCoresPerInstance(AzureCoresPerInstanceEnum azureCoresPerInstance) {
    this.azureCoresPerInstance = azureCoresPerInstance;
    return this;
  }

  /**
   * Get azureCoresPerInstance
   * @return azureCoresPerInstance
  **/
  @ApiModelProperty(value = "")


  public AzureCoresPerInstanceEnum getAzureCoresPerInstance() {
    return azureCoresPerInstance;
  }

  public void setAzureCoresPerInstance(AzureCoresPerInstanceEnum azureCoresPerInstance) {
    this.azureCoresPerInstance = azureCoresPerInstance;
  }

  public Tenant azureNumInstances(Integer azureNumInstances) {
    this.azureNumInstances = azureNumInstances;
    return this;
  }

  /**
   * Get azureNumInstances
   * minimum: 3
   * maximum: 20
   * @return azureNumInstances
  **/
  @ApiModelProperty(value = "")

@Min(3) @Max(20) 
  public Integer getAzureNumInstances() {
    return azureNumInstances;
  }

  public void setAzureNumInstances(Integer azureNumInstances) {
    this.azureNumInstances = azureNumInstances;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tenant tenant = (Tenant) o;
    return Objects.equals(this.a4iotBuildNum, tenant.a4iotBuildNum) &&
        Objects.equals(this.location, tenant.location) &&
        Objects.equals(this.azureCoresPerInstance, tenant.azureCoresPerInstance) &&
        Objects.equals(this.azureNumInstances, tenant.azureNumInstances);
  }

  @Override
  public int hashCode() {
    return Objects.hash(a4iotBuildNum, location, azureCoresPerInstance, azureNumInstances);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tenant {\n");
    
    sb.append("    a4iotBuildNum: ").append(toIndentedString(a4iotBuildNum)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    azureCoresPerInstance: ").append(toIndentedString(azureCoresPerInstance)).append("\n");
    sb.append("    azureNumInstances: ").append(toIndentedString(azureNumInstances)).append("\n");
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

