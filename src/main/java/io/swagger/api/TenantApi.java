/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.4).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.ModelApiResponse;
import io.swagger.model.Tenant;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-28T18:55:48.493Z")

@Api(value = "tenant", description = "the tenant API")
public interface TenantApi {

    @ApiOperation(value = "Create new tenant", nickname = "createTenant", notes = "", response = ModelApiResponse.class, tags={ "tenant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Tenant not found") })
    @RequestMapping(value = "/tenant/{tenant-id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ModelApiResponse> createTenant(@Pattern(regexp="^[a-z][a-z0-9]{4,10}$") @ApiParam(value = "tenant-id to create",required=true) @PathVariable("tenant-id") String tenantId,@ApiParam(value = "Information needed to create a tenant" ,required=true )  @Valid @RequestBody Tenant body);


    @ApiOperation(value = "Deletes a tenant", nickname = "deleteTenant", notes = "", response = ModelApiResponse.class, tags={ "tenant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Tenant not found") })
    @RequestMapping(value = "/tenant/{tenant-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<ModelApiResponse> deleteTenant(@ApiParam(value = "tenant-id to delete; for dev use only; in production delete will snapshot before delete.",required=true) @PathVariable("tenant-id") String tenantId,@ApiParam(value = "") @Valid @RequestParam(value = "confirm", required = false) String confirm);


    @ApiOperation(value = "Get info about tenant", nickname = "getTenant", notes = "", response = ModelApiResponse.class, tags={ "tenant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Tenant not found") })
    @RequestMapping(value = "/tenant/{tenant-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<ModelApiResponse> getTenant(@ApiParam(value = "tenant-id to retrieve info on",required=true) @PathVariable("tenant-id") String tenantId);


    @ApiOperation(value = "Updates a tenant", nickname = "updateTenant", notes = "Updates the A4IOT Build Number", response = ModelApiResponse.class, tags={ "tenant", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class),
        @ApiResponse(code = 400, message = "Invalid tenant-id supplied"),
        @ApiResponse(code = 404, message = "Build Number not found") })
    @RequestMapping(value = "/tenant/{tenant-id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<ModelApiResponse> updateTenant(@ApiParam(value = "tenant-id to update; for dev use only",required=true) @PathVariable("tenant-id") String tenantId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "a4iot-build-num", required = true) String a4iotBuildNum);

}