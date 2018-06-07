package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.MenstrualCycleService;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.MenstrualCycleDTO;
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
 * REST controller for managing MenstrualCycle.
 */
@RestController
@RequestMapping("/api")
public class MenstrualCycleResource {

    private final Logger log = LoggerFactory.getLogger(MenstrualCycleResource.class);

    private static final String ENTITY_NAME = "menstrualCycle";

    private final MenstrualCycleService menstrualCycleService;

    public MenstrualCycleResource(MenstrualCycleService menstrualCycleService) {
        this.menstrualCycleService = menstrualCycleService;
    }

    /**
     * POST  /menstrual-cycles : Create a new menstrualCycle.
     *
     * @param menstrualCycleDTO the menstrualCycleDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new menstrualCycleDTO, or with status 400 (Bad Request) if the menstrualCycle has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/menstrual-cycles")
    @Timed
    public ResponseEntity<MenstrualCycleDTO> createMenstrualCycle(@Valid @RequestBody MenstrualCycleDTO menstrualCycleDTO) throws URISyntaxException {
        log.debug("REST request to save MenstrualCycle : {}", menstrualCycleDTO);
        if (menstrualCycleDTO.getId() != null) {
            throw new BadRequestAlertException("A new menstrualCycle cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MenstrualCycleDTO result = menstrualCycleService.save(menstrualCycleDTO);
        return ResponseEntity.created(new URI("/api/menstrual-cycles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /menstrual-cycles : Updates an existing menstrualCycle.
     *
     * @param menstrualCycleDTO the menstrualCycleDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated menstrualCycleDTO,
     * or with status 400 (Bad Request) if the menstrualCycleDTO is not valid,
     * or with status 500 (Internal Server Error) if the menstrualCycleDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/menstrual-cycles")
    @Timed
    public ResponseEntity<MenstrualCycleDTO> updateMenstrualCycle(@Valid @RequestBody MenstrualCycleDTO menstrualCycleDTO) throws URISyntaxException {
        log.debug("REST request to update MenstrualCycle : {}", menstrualCycleDTO);
        if (menstrualCycleDTO.getId() == null) {
            return createMenstrualCycle(menstrualCycleDTO);
        }
        MenstrualCycleDTO result = menstrualCycleService.save(menstrualCycleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, menstrualCycleDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /menstrual-cycles : get all the menstrualCycles.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of menstrualCycles in body
     */
    @GetMapping("/menstrual-cycles")
    @Timed
    public ResponseEntity<List<MenstrualCycleDTO>> getAllMenstrualCycles(Pageable pageable) {
        log.debug("REST request to get a page of MenstrualCycles");
        Page<MenstrualCycleDTO> page = menstrualCycleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/menstrual-cycles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /menstrual-cycles/:id : get the "id" menstrualCycle.
     *
     * @param id the id of the menstrualCycleDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the menstrualCycleDTO, or with status 404 (Not Found)
     */
    @GetMapping("/menstrual-cycles/{id}")
    @Timed
    public ResponseEntity<MenstrualCycleDTO> getMenstrualCycle(@PathVariable String id) {
        log.debug("REST request to get MenstrualCycle : {}", id);
        MenstrualCycleDTO menstrualCycleDTO = menstrualCycleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(menstrualCycleDTO));
    }

    /**
     * DELETE  /menstrual-cycles/:id : delete the "id" menstrualCycle.
     *
     * @param id the id of the menstrualCycleDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/menstrual-cycles/{id}")
    @Timed
    public ResponseEntity<Void> deleteMenstrualCycle(@PathVariable String id) {
        log.debug("REST request to delete MenstrualCycle : {}", id);
        menstrualCycleService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
