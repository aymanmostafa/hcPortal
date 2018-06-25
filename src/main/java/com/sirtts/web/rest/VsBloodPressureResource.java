package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.VsBloodPressureService;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.VsBloodPressureDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing VsBloodPressure.
 */
@RestController
@RequestMapping("/api")
public class VsBloodPressureResource {

    private final Logger log = LoggerFactory.getLogger(VsBloodPressureResource.class);

    private static final String ENTITY_NAME = "vsBloodPressure";

    private final VsBloodPressureService vsBloodPressureService;

    public VsBloodPressureResource(VsBloodPressureService vsBloodPressureService) {
        this.vsBloodPressureService = vsBloodPressureService;
    }

    /**
     * POST  /vs-blood-pressures : Create a new vsBloodPressure.
     *
     * @param vsBloodPressureDTO the vsBloodPressureDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vsBloodPressureDTO, or with status 400 (Bad Request) if the vsBloodPressure has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vs-blood-pressures")
    @Timed
    public ResponseEntity<VsBloodPressureDTO> createVsBloodPressure(@Valid @RequestBody VsBloodPressureDTO vsBloodPressureDTO) throws URISyntaxException {
        log.debug("REST request to save VsBloodPressure : {}", vsBloodPressureDTO);
        if (vsBloodPressureDTO.getId() != null) {
            throw new BadRequestAlertException("A new vsBloodPressure cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VsBloodPressureDTO result = vsBloodPressureService.save(vsBloodPressureDTO);
        return ResponseEntity.created(new URI("/api/vs-blood-pressures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /vs-blood-pressures : Updates an existing vsBloodPressure.
     *
     * @param vsBloodPressureDTO the vsBloodPressureDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vsBloodPressureDTO,
     * or with status 400 (Bad Request) if the vsBloodPressureDTO is not valid,
     * or with status 500 (Internal Server Error) if the vsBloodPressureDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vs-blood-pressures")
    @Timed
    public ResponseEntity<VsBloodPressureDTO> updateVsBloodPressure(@Valid @RequestBody VsBloodPressureDTO vsBloodPressureDTO) throws URISyntaxException {
        log.debug("REST request to update VsBloodPressure : {}", vsBloodPressureDTO);
        if (vsBloodPressureDTO.getId() == null) {
            return createVsBloodPressure(vsBloodPressureDTO);
        }
        VsBloodPressureDTO result = vsBloodPressureService.save(vsBloodPressureDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, vsBloodPressureDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /vs-blood-pressures : get all the vsBloodPressures.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsBloodPressures in body
     */
    @GetMapping("/vs-blood-pressures")
    @Timed
    public ResponseEntity<List<VsBloodPressureDTO>> getAllVsBloodPressures(Pageable pageable) {
        log.debug("REST request to get a page of VsBloodPressures");
        Page<VsBloodPressureDTO> page = vsBloodPressureService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-blood-pressures");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-blood-pressures/byUserid : get all the vsBloodPressures by userid.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsBloodPressures in body
     */
    @GetMapping("/vs-blood-pressures/byUserid")
    @Timed
    public ResponseEntity<List<VsBloodPressureDTO>> getAllVsBloodPressuresByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("REST request to get a page of VsBloodPressures by userid");
        Page<VsBloodPressureDTO> page = vsBloodPressureService.findAllByUserid(userids, startDate, endDate, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-blood-pressures/byUserid");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-blood-pressures/:id : get the "id" vsBloodPressure.
     *
     * @param id the id of the vsBloodPressureDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vsBloodPressureDTO, or with status 404 (Not Found)
     */
    @GetMapping("/vs-blood-pressures/{id}")
    @Timed
    public ResponseEntity<VsBloodPressureDTO> getVsBloodPressure(@PathVariable String id) {
        log.debug("REST request to get VsBloodPressure : {}", id);
        VsBloodPressureDTO vsBloodPressureDTO = vsBloodPressureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(vsBloodPressureDTO));
    }

    /**
     * DELETE  /vs-blood-pressures/:id : delete the "id" vsBloodPressure.
     *
     * @param id the id of the vsBloodPressureDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vs-blood-pressures/{id}")
    @Timed
    public ResponseEntity<Void> deleteVsBloodPressure(@PathVariable String id) {
        log.debug("REST request to delete VsBloodPressure : {}", id);
        vsBloodPressureService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
