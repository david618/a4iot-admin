package io.swagger.api;

import com.esri.a4iot.TenantImpl;
import io.swagger.model.ModelApiResponse;
import io.swagger.model.Tenant;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-03-28T18:55:48.493Z")

@Controller
public class TenantApiController implements TenantApi {

    private static final Logger log = LoggerFactory.getLogger(TenantApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TenantApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ModelApiResponse> createTenant(@Pattern(regexp="^[a-z][a-z0-9]{4,10}$") @ApiParam(value = "tenant-id to create",required=true) @PathVariable("tenant-id") String tenantId,@ApiParam(value = "Information needed to create a tenant" ,required=true )  @Valid @RequestBody Tenant body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                TenantImpl tenant = new TenantImpl();
                ModelApiResponse resp = tenant.create(tenantId, body);

                if (resp.getCode() == 0) {
                    return new ResponseEntity<ModelApiResponse>(resp, HttpStatus.OK);
                } else {
                    return new ResponseEntity<ModelApiResponse>(resp, HttpStatus.EXPECTATION_FAILED);
                }

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ModelApiResponse> deleteTenant(@ApiParam(value = "tenant-id to delete; for dev use only; in production delete will snapshot before delete.",required=true) @PathVariable("tenant-id") String tenantId,@ApiParam(value = "") @Valid @RequestParam(value = "confirm", required = false) String confirm) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                TenantImpl tenant = new TenantImpl();
                ModelApiResponse resp = tenant.delete(tenantId,confirm);
                return new ResponseEntity<ModelApiResponse>(resp, HttpStatus.OK);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ModelApiResponse> getTenant(@ApiParam(value = "tenant-id to retrieve info on",required=true) @PathVariable("tenant-id") String tenantId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                TenantImpl tenant = new TenantImpl();
                ModelApiResponse resp = tenant.get(tenantId);
                return new ResponseEntity<ModelApiResponse>(resp, HttpStatus.OK);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ModelApiResponse> updateTenant(@ApiParam(value = "tenant-id to update; for dev use only",required=true) @PathVariable("tenant-id") String tenantId,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "a4iot-build-num", required = true) String a4iotBuildNum) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                TenantImpl tenant = new TenantImpl();
                ModelApiResponse resp = tenant.update(tenantId,a4iotBuildNum);
                return new ResponseEntity<ModelApiResponse>(resp, HttpStatus.OK);

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ModelApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
