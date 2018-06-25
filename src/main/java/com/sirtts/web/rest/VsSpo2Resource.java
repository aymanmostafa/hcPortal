package com.sirtts.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.sirtts.service.VsSpo2Service;
import com.sirtts.web.rest.errors.BadRequestAlertException;
import com.sirtts.web.rest.util.HeaderUtil;
import com.sirtts.web.rest.util.PaginationUtil;
import com.sirtts.service.dto.VsSpo2DTO;
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
 * REST controller for managing VsSpo2.
 */
@RestController
@RequestMapping("/api")
public class VsSpo2Resource {

    private final Logger log = LoggerFactory.getLogger(VsSpo2Resource.class);

    private static final String ENTITY_NAME = "vsSpo2";

    private final VsSpo2Service vsSpo2Service;

    public VsSpo2Resource(VsSpo2Service vsSpo2Service) {
        this.vsSpo2Service = vsSpo2Service;
    }

    /**
     * POST  /vs-spo-2-s : Create a new vsSpo2.
     *
     * @param vsSpo2DTO the vsSpo2DTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new vsSpo2DTO, or with status 400 (Bad Request) if the vsSpo2 has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/vs-spo-2-s")
    @Timed
    public ResponseEntity<VsSpo2DTO> createVsSpo2(@Valid @RequestBody VsSpo2DTO vsSpo2DTO) throws URISyntaxException {
        log.debug("REST request to save VsSpo2 : {}", vsSpo2DTO);
        if (vsSpo2DTO.getId() != null) {
            throw new BadRequestAlertException("A new vsSpo2 cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VsSpo2DTO result = vsSpo2Service.save(vsSpo2DTO);
        return ResponseEntity.created(new URI("/api/vs-spo-2-s/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /vs-spo-2-s : Updates an existing vsSpo2.
     *
     * @param vsSpo2DTO the vsSpo2DTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated vsSpo2DTO,
     * or with status 400 (Bad Request) if the vsSpo2DTO is not valid,
     * or with status 500 (Internal Server Error) if the vsSpo2DTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/vs-spo-2-s")
    @Timed
    public ResponseEntity<VsSpo2DTO> updateVsSpo2(@Valid @RequestBody VsSpo2DTO vsSpo2DTO) throws URISyntaxException {
        log.debug("REST request to update VsSpo2 : {}", vsSpo2DTO);
        if (vsSpo2DTO.getId() == null) {
            return createVsSpo2(vsSpo2DTO);
        }
        VsSpo2DTO result = vsSpo2Service.save(vsSpo2DTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, vsSpo2DTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /vs-spo-2-s : get all the vsSpo2S.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsSpo2S in body
     */
    @GetMapping("/vs-spo-2-s")
    @Timed
    public ResponseEntity<List<VsSpo2DTO>> getAllVsSpo2S(Pageable pageable) {
        log.debug("REST request to get a page of VsSpo2S");
        Page<VsSpo2DTO> page = vsSpo2Service.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-spo-2-s");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-spo-2-sbyUserid/byUserid : get all the vsSpo2S by userid.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of vsSpo2S in body
     */
    @GetMapping("/vs-spo-2-s/byUserid")
    @Timed
    public ResponseEntity<List<VsSpo2DTO>> getAllVsSpo2SByUserid(String[] userids, String startDate, String endDate, Pageable pageable) {
        log.debug("REST request to get a page of VsSpo2S by userid");
        Page<VsSpo2DTO> page = vsSpo2Service.findAllByUserid(userids, startDate, endDate, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/vs-spo-2-s/byUserid");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /vs-spo-2-s/:id : get the "id" vsSpo2.
     *
     * @param id the id of the vsSpo2DTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the vsSpo2DTO, or with status 404 (Not Found)
     */
    @GetMapping("/vs-spo-2-s/{id}")
    @Timed
    public ResponseEntity<VsSpo2DTO> getVsSpo2(@PathVariable String id) {
        log.debug("REST request to get VsSpo2 : {}", id);
        VsSpo2DTO vsSpo2DTO = vsSpo2Service.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(vsSpo2DTO));
    }

    /**
     * DELETE  /vs-spo-2-s/:id : delete the "id" vsSpo2.
     *
     * @param id the id of the vsSpo2DTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/vs-spo-2-s/{id}")
    @Timed
    public ResponseEntity<Void> deleteVsSpo2(@PathVariable String id) {
        log.debug("REST request to delete VsSpo2 : {}", id);
        vsSpo2Service.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
