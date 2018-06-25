package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.VsBodyTemperatureService;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.VsBodyTemperatureDTO;
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
 * REST controller for managing VsBodyTemperature.
 */
@RestController
@RequestMapping("/api")
public class VsBodyTemperatureResource {

    private final Logger log = LoggerFactory.getLogger(VsBodyTemperatureResource.class);

    private static final String ENTITY_NAME = "vsBodyTemperature";

    private final VsBodyTemperatureService vsBodyTemperatureService;

    public VsBodyTemperatureResource(VsBodyTemperatureService vsBodyTemperatureService) {
        this.vsBodyTemperatureService = vsBodyTemperatureService;
    }

    /**
     * POST  /vs-body-temperatures : Create a new vsBodyTemperature.
     *
     * @param vsBodyTemperatureDTO the vsBodyTemperatureDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vsBodyTemperatureDTO, or with status 400 (Bad Request) if the vsBodyTemperature has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vs-body-temperatures")
    @Timed
    public ResponseEntity<VsBodyTemperatureDTO> createVsBodyTemperature(@Valid @RequestBody VsBodyTemperatureDTO vsBodyTemperatureDTO) throws URISyntaxException {
        log.debug("REST request to save VsBodyTemperature : {}", vsBodyTemperatureDTO);
        if (vsBodyTemperatureDTO.getId() != null) {
            throw new BadRequestAlertException("A new vsBodyTemperature cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VsBodyTemperatureDTO result = vsBodyTemperatureService.save(vsBodyTemperatureDTO);
        return ResponseEntity.created(new URI("/api/vs-body-temperatures/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /vs-body-temperatures : Updates an existing vsBodyTemperature.
     *
     * @param vsBodyTemperatureDTO the vsBodyTemperatureDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vsBodyTemperatureDTO,
     * or with status 400 (Bad Request) if the vsBodyTemperatureDTO is not valid,
     * or with status 500 (Internal Server Error) if the vsBodyTemperatureDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vs-body-temperatures")
    @Timed
    public ResponseEntity<VsBodyTemperatureDTO> updateVsBodyTemperature(@Valid @RequestBody VsBodyTemperatureDTO vsBodyTemperatureDTO) throws URISyntaxException {
        log.debug("REST request to update VsBodyTemperature : {}", vsBodyTemperatureDTO);
        if (vsBodyTemperatureDTO.getId() == null) {
            return createVsBodyTemperature(vsBodyTemperatureDTO);
        }
        VsBodyTemperatureDTO result = vsBodyTemperatureService.save(vsBodyTemperatureDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, vsBodyTemperatureDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /vs-body-temperatures : get all the vsBodyTemperatures.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsBodyTemperatures in body
     */
    @GetMapping("/vs-body-temperatures")
    @Timed
    public ResponseEntity<List<VsBodyTemperatureDTO>> getAllVsBodyTemperatures(Pageable pageable) {
        log.debug("REST request to get a page of VsBodyTemperatures");
        Page<VsBodyTemperatureDTO> page = vsBodyTemperatureService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-body-temperatures");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-body-temperatures/byUserid : get all the vsBodyTemperatures by userid.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsBodyTemperatures in body
     */
    @GetMapping("/vs-body-temperatures/byUserid")
    @Timed
    public ResponseEntity<List<VsBodyTemperatureDTO>> getAllVsBodyTemperaturesByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("REST request to get a page of VsBodyTemperatures by userid");
        Page<VsBodyTemperatureDTO> page = vsBodyTemperatureService.findAllByUserid(userids, startDate, endDate, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-body-temperatures/byUserid");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-body-temperatures/:id : get the "id" vsBodyTemperature.
     *
     * @param id the id of the vsBodyTemperatureDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vsBodyTemperatureDTO, or with status 404 (Not Found)
     */
    @GetMapping("/vs-body-temperatures/{id}")
    @Timed
    public ResponseEntity<VsBodyTemperatureDTO> getVsBodyTemperature(@PathVariable String id) {
        log.debug("REST request to get VsBodyTemperature : {}", id);
        VsBodyTemperatureDTO vsBodyTemperatureDTO = vsBodyTemperatureService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(vsBodyTemperatureDTO));
    }

    /**
     * DELETE  /vs-body-temperatures/:id : delete the "id" vsBodyTemperature.
     *
     * @param id the id of the vsBodyTemperatureDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vs-body-temperatures/{id}")
    @Timed
    public ResponseEntity<Void> deleteVsBodyTemperature(@PathVariable String id) {
        log.debug("REST request to delete VsBodyTemperature : {}", id);
        vsBodyTemperatureService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
