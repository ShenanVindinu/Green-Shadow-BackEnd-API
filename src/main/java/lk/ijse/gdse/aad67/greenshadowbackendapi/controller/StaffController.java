package lk.ijse.gdse.aad67.greenshadowbackendapi.controller;

import lk.ijse.gdse.aad67.greenshadowbackendapi.dto.StaffDTO;
import lk.ijse.gdse.aad67.greenshadowbackendapi.entity.impl.StaffEntity;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.DataPersistException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.exception.StaffNotFoundException;
import lk.ijse.gdse.aad67.greenshadowbackendapi.service.StaffService;
import lk.ijse.gdse.aad67.greenshadowbackendapi.util.RegexProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    private final StaffService staffService;
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaffMember(@RequestBody StaffDTO staffDTO) {
        try {
            staffService.saveStaffMember(staffDTO);
            logger.info("staff saved");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDTO> getStaffMembers() {
        return staffService.getALLStaffMembers();
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @DeleteMapping(value = "{staffId}")
    public ResponseEntity<Void> deleteStaffMember(@PathVariable String staffId) {
        try {
            if (!RegexProcess.staffIdMatcher(staffId) || staffId == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            staffService.deleteStaffMember(staffId);
            logger.info("staff deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (StaffNotFoundException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PutMapping(value = "{staffId}")
    public ResponseEntity<Void> updateStaffMember(@PathVariable("staffId") String staffId,
                                                  @RequestBody StaffDTO staffDTO)
    {
        try {
            logger.info(staffDTO.toString());
            if (!RegexProcess.staffIdMatcher(staffId) || staffId == null) {
                logger.info("staffId don't match");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                staffService.updateStaffMember(staffId, staffDTO);
                logger.info("staff updated");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (StaffNotFoundException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
