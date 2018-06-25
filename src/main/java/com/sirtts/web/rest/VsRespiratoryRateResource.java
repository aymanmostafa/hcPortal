package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.VsRespiratoryRateService;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.VsRespiratoryRateDTO;
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
 * REST controller for managing VsRespiratoryRate.
 */
@RestController
@RequestMapping("/api")
public class VsRespiratoryRateResource {

    private final Logger log = LoggerFactory.getLogger(VsRespiratoryRateResource.class);

    private static final String ENTITY_NAME = "vsRespiratoryRate";

    private final VsRespiratoryRateService vsRespiratoryRateService;

    public VsRespiratoryRateResource(VsRespiratoryRateService vsRespiratoryRateService) {
        this.vsRespiratoryRateService = vsRespiratoryRateService;
    }

    /**
     * POST  /vs-respiratory-rates : Create a new vsRespiratoryRate.
     *
     * @param vsRespiratoryRateDTO the vsRespiratoryRateDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vsRespiratoryRateDTO, or with status 400 (Bad Request) if the vsRespiratoryRate has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vs-respiratory-rates")
    @Timed
    public ResponseEntity<VsRespiratoryRateDTO> createVsRespiratoryRate(@Valid @RequestBody VsRespiratoryRateDTO vsRespiratoryRateDTO) throws URISyntaxException {
        log.debug("REST request to save VsRespiratoryRate : {}", vsRespiratoryRateDTO);
        if (vsRespiratoryRateDTO.getId() != null) {
            throw new BadRequestAlertException("A new vsRespiratoryRate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VsRespiratoryRateDTO result = vsRespiratoryRateService.save(vsRespiratoryRateDTO);
        return ResponseEntity.created(new URI("/api/vs-respiratory-rates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /vs-respiratory-rates : Updates an existing vsRespiratoryRate.
     *
     * @param vsRespiratoryRateDTO the vsRespiratoryRateDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vsRespiratoryRateDTO,
     * or with status 400 (Bad Request) if the vsRespiratoryRateDTO is not valid,
     * or with status 500 (Internal Server Error) if the vsRespiratoryRateDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vs-respiratory-rates")
    @Timed
    public ResponseEntity<VsRespiratoryRateDTO> updateVsRespiratoryRate(@Valid @RequestBody VsRespiratoryRateDTO vsRespiratoryRateDTO) throws URISyntaxException {
        log.debug("REST request to update VsRespiratoryRate : {}", vsRespiratoryRateDTO);
        if (vsRespiratoryRateDTO.getId() == null) {
            return createVsRespiratoryRate(vsRespiratoryRateDTO);
        }
        VsRespiratoryRateDTO result = vsRespiratoryRateService.save(vsRespiratoryRateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, vsRespiratoryRateDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /vs-respiratory-rates : get all the vsRespiratoryRates.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsRespiratoryRates in body
     */
    @GetMapping("/vs-respiratory-rates")
    @Timed
    public ResponseEntity<List<VsRespiratoryRateDTO>> getAllVsRespiratoryRates(Pageable pageable) {
        log.debug("REST request to get a page of VsRespiratoryRates");
        Page<VsRespiratoryRateDTO> page = vsRespiratoryRateService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-respiratory-rates");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-respiratory-rates/byUserid : get all the vsRespiratoryRates by userid.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsRespiratoryRates in body
     */
    @GetMapping("/vs-respiratory-rates/byUserid")
    @Timed
    public ResponseEntity<List<VsRespiratoryRateDTO>> getAllVsRespiratoryRatesByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("REST request to get a page of VsRespiratoryRates by userid");
        Page<VsRespiratoryRateDTO> page = vsRespiratoryRateService.findAllByUserid(userids, startDate, endDate, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-respiratory-rates/byUserid");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-respiratory-rates/:id : get the "id" vsRespiratoryRate.
     *
     * @param id the id of the vsRespiratoryRateDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vsRespiratoryRateDTO, or with status 404 (Not Found)
     */
    @GetMapping("/vs-respiratory-rates/{id}")
    @Timed
    public ResponseEntity<VsRespiratoryRateDTO> getVsRespiratoryRate(@PathVariable String id) {
        log.debug("REST request to get VsRespiratoryRate : {}", id);
        VsRespiratoryRateDTO vsRespiratoryRateDTO = vsRespiratoryRateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(vsRespiratoryRateDTO));
    }

    /**
     * DELETE  /vs-respiratory-rates/:id : delete the "id" vsRespiratoryRate.
     *
     * @param id the id of the vsRespiratoryRateDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vs-respiratory-rates/{id}")
    @Timed
    public ResponseEntity<Void> deleteVsRespiratoryRate(@PathVariable String id) {
        log.debug("REST request to delete VsRespiratoryRate : {}", id);
        vsRespiratoryRateService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
