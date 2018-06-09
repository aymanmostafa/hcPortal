package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.DiabetesSugarTestService;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.DiabetesSugarTestDTO;
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
 * REST controller for managing DiabetesSugarTest.
 */
@RestController
@RequestMapping("/api")
public class DiabetesSugarTestResource {

    private final Logger log = LoggerFactory.getLogger(DiabetesSugarTestResource.class);

    private static final String ENTITY_NAME = "diabetesSugarTest";

    private final DiabetesSugarTestService diabetesSugarTestService;

    public DiabetesSugarTestResource(DiabetesSugarTestService diabetesSugarTestService) {
        this.diabetesSugarTestService = diabetesSugarTestService;
    }

    /**
     * POST  /diabetes-sugar-tests : Create a new diabetesSugarTest.
     *
     * @param diabetesSugarTestDTO the diabetesSugarTestDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new diabetesSugarTestDTO, or with status 400 (Bad Request) if the diabetesSugarTest has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/diabetes-sugar-tests")
    @Timed
    public ResponseEntity<DiabetesSugarTestDTO> createDiabetesSugarTest(@Valid @RequestBody DiabetesSugarTestDTO diabetesSugarTestDTO) throws URISyntaxException {
        log.debug("REST request to save DiabetesSugarTest : {}", diabetesSugarTestDTO);
        if (diabetesSugarTestDTO.getId() != null) {
            throw new BadRequestAlertException("A new diabetesSugarTest cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DiabetesSugarTestDTO result = diabetesSugarTestService.save(diabetesSugarTestDTO);
        return ResponseEntity.created(new URI("/api/diabetes-sugar-tests/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /diabetes-sugar-tests : Updates an existing diabetesSugarTest.
     *
     * @param diabetesSugarTestDTO the diabetesSugarTestDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated diabetesSugarTestDTO,
     * or with status 400 (Bad Request) if the diabetesSugarTestDTO is not valid,
     * or with status 500 (Internal Server Error) if the diabetesSugarTestDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/diabetes-sugar-tests")
    @Timed
    public ResponseEntity<DiabetesSugarTestDTO> updateDiabetesSugarTest(@Valid @RequestBody DiabetesSugarTestDTO diabetesSugarTestDTO) throws URISyntaxException {
        log.debug("REST request to update DiabetesSugarTest : {}", diabetesSugarTestDTO);
        if (diabetesSugarTestDTO.getId() == null) {
            return createDiabetesSugarTest(diabetesSugarTestDTO);
        }
        DiabetesSugarTestDTO result = diabetesSugarTestService.save(diabetesSugarTestDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, diabetesSugarTestDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /diabetes-sugar-tests : get all the diabetesSugarTests.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of diabetesSugarTests in body
     */
    @GetMapping("/diabetes-sugar-tests")
    @Timed
    public ResponseEntity<List<DiabetesSugarTestDTO>> getAllDiabetesSugarTests(Pageable pageable) {
        log.debug("REST request to get a page of DiabetesSugarTests");
        Page<DiabetesSugarTestDTO> page = diabetesSugarTestService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/diabetes-sugar-tests");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /diabetes-sugar-tests/byUserid : get all the diabetesSugarTests by userid.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of diabetesSugarTests in body
     */
    @GetMapping("/diabetes-sugar-tests/byUserid")
    @Timed
    public ResponseEntity<List<DiabetesSugarTestDTO>> getAllDiabetesSugarTestsByUserid(String[] userids, Pageable pageable) {
        log.debug("REST request to get a page of DiabetesSugarTests by userid");
        Page<DiabetesSugarTestDTO> page = diabetesSugarTestService.findAllByUserid(userids, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/diabetes-sugar-tests/byUserid");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /diabetes-sugar-tests/:id : get the "id" diabetesSugarTest.
     *
     * @param id the id of the diabetesSugarTestDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the diabetesSugarTestDTO, or with status 404 (Not Found)
     */
    @GetMapping("/diabetes-sugar-tests/{id}")
    @Timed
    public ResponseEntity<DiabetesSugarTestDTO> getDiabetesSugarTest(@PathVariable String id) {
        log.debug("REST request to get DiabetesSugarTest : {}", id);
        DiabetesSugarTestDTO diabetesSugarTestDTO = diabetesSugarTestService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(diabetesSugarTestDTO));
    }

    /**
     * DELETE  /diabetes-sugar-tests/:id : delete the "id" diabetesSugarTest.
     *
     * @param id the id of the diabetesSugarTestDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/diabetes-sugar-tests/{id}")
    @Timed
    public ResponseEntity<Void> deleteDiabetesSugarTest(@PathVariable String id) {
        log.debug("REST request to delete DiabetesSugarTest : {}", id);
        diabetesSugarTestService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
