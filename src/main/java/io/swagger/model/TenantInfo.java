package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TenantInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-11T18:54:47.440Z")

public class TenantInfo   {
  @JsonProperty("url")
  private String url = null;

  @JsonProperty("a4iot-build")
  private String a4iotBuild = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("messages")
  @Valid
  private List<String> messages = null;

  public TenantInfo url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public TenantInfo a4iotBuild(String a4iotBuild) {
    this.a4iotBuild = a4iotBuild;
    return this;
  }

  /**
   * Get a4iotBuild
   * @return a4iotBuild
  **/
  @ApiModelProperty(value = "")


  public String getA4iotBuild() {
    return a4iotBuild;
  }

  public void setA4iotBuild(String a4iotBuild) {
    this.a4iotBuild = a4iotBuild;
  }

  public TenantInfo status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public TenantInfo messages(List<String> messages) {
    this.messages = messages;
    return this;
  }

  public TenantInfo addMessagesItem(String messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<String>();
    }
    this.messages.add(messagesItem);
    return this;
  }

  /**
   * Get messages
   * @return messages
  **/
  @ApiModelProperty(value = "")


  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantInfo tenantInfo = (TenantInfo) o;
    return Objects.equals(this.url, tenantInfo.url) &&
        Objects.equals(this.a4iotBuild, tenantInfo.a4iotBuild) &&
        Objects.equals(this.status, tenantInfo.status) &&
        Objects.equals(this.messages, tenantInfo.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, a4iotBuild, status, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantInfo {\n");
    
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    a4iotBuild: ").append(toIndentedString(a4iotBuild)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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

