package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.DentistNextVisitService;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.DentistNextVisitDTO;
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
 * REST controller for managing DentistNextVisit.
 */
@RestController
@RequestMapping("/api")
public class DentistNextVisitResource {

    private final Logger log = LoggerFactory.getLogger(DentistNextVisitResource.class);

    private static final String ENTITY_NAME = "dentistNextVisit";

    private final DentistNextVisitService dentistNextVisitService;

    public DentistNextVisitResource(DentistNextVisitService dentistNextVisitService) {
        this.dentistNextVisitService = dentistNextVisitService;
    }

    /**
     * POST  /dentist-next-visits : Create a new dentistNextVisit.
     *
     * @param dentistNextVisitDTO the dentistNextVisitDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dentistNextVisitDTO, or with status 400 (Bad Request) if the dentistNextVisit has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/dentist-next-visits")
    @Timed
    public ResponseEntity<DentistNextVisitDTO> createDentistNextVisit(@Valid @RequestBody DentistNextVisitDTO dentistNextVisitDTO) throws URISyntaxException {
        log.debug("REST request to save DentistNextVisit : {}", dentistNextVisitDTO);
        if (dentistNextVisitDTO.getId() != null) {
            throw new BadRequestAlertException("A new dentistNextVisit cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DentistNextVisitDTO result = dentistNextVisitService.save(dentistNextVisitDTO);
        return ResponseEntity.created(new URI("/api/dentist-next-visits/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /dentist-next-visits : Updates an existing dentistNextVisit.
     *
     * @param dentistNextVisitDTO the dentistNextVisitDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dentistNextVisitDTO,
     * or with status 400 (Bad Request) if the dentistNextVisitDTO is not valid,
     * or with status 500 (Internal Server Error) if the dentistNextVisitDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/dentist-next-visits")
    @Timed
    public ResponseEntity<DentistNextVisitDTO> updateDentistNextVisit(@Valid @RequestBody DentistNextVisitDTO dentistNextVisitDTO) throws URISyntaxException {
        log.debug("REST request to update DentistNextVisit : {}", dentistNextVisitDTO);
        if (dentistNextVisitDTO.getId() == null) {
            return createDentistNextVisit(dentistNextVisitDTO);
        }
        DentistNextVisitDTO result = dentistNextVisitService.save(dentistNextVisitDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dentistNextVisitDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /dentist-next-visits : get all the dentistNextVisits.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dentistNextVisits in body
     */
    @GetMapping("/dentist-next-visits")
    @Timed
    public ResponseEntity<List<DentistNextVisitDTO>> getAllDentistNextVisits(Pageable pageable) {
        log.debug("REST request to get a page of DentistNextVisits");
        Page<DentistNextVisitDTO> page = dentistNextVisitService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/dentist-next-visits");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /dentist-next-visits /byUserid : get all the dentistNextVisits by userid.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of dentistNextVisits in body
     */
    @GetMapping("/dentist-next-visits/byUserid")
    @Timed
    public ResponseEntity<List<DentistNextVisitDTO>> getAllDentistNextVisitsByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("REST request to get a page of DentistVisits by userid");
        Page<DentistNextVisitDTO> page = dentistNextVisitService.findAllByUserid(userids, startDate, endDate, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/dentist-next-visits/byUserid");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /dentist-next-visits/:id : get the "id" dentistNextVisit.
     *
     * @param id the id of the dentistNextVisitDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dentistNextVisitDTO, or with status 404 (Not Found)
     */
    @GetMapping("/dentist-next-visits/{id}")
    @Timed
    public ResponseEntity<DentistNextVisitDTO> getDentistNextVisit(@PathVariable String id) {
        log.debug("REST request to get DentistNextVisit : {}", id);
        DentistNextVisitDTO dentistNextVisitDTO = dentistNextVisitService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dentistNextVisitDTO));
    }

    /**
     * DELETE  /dentist-next-visits/:id : delete the "id" dentistNextVisit.
     *
     * @param id the id of the dentistNextVisitDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/dentist-next-visits/{id}")
    @Timed
    public ResponseEntity<Void> deleteDentistNextVisit(@PathVariable String id) {
        log.debug("REST request to delete DentistNextVisit : {}", id);
        dentistNextVisitService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
