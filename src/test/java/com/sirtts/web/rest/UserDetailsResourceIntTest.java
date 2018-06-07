package com.sirtts.web.rest;

import com.sirtts.HcPortalApp;

import com.sirtts.domain.UserDetails;
import com.sirtts.repository.UserDetailsRepository;
import com.sirtts.service.UserDetailsService;
import com.sirtts.service.dto.UserDetailsDTO;
import com.sirtts.service.mapper.UserDetailsMapper;
import com.sirtts.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static com.sirtts.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.sirtts.domain.enumeration.Gender;
import com.sirtts.domain.enumeration.Ethnicity;
/**
 * Test class for the UserDetailsResource REST controller.
 *
 * @see UserDetailsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HcPortalApp.class)
public class UserDetailsResourceIntTest {

    private static final Integer DEFAULT_USERID = 1;
    private static final Integer UPDATED_USERID = 2;

    private static final String DEFAULT_ACTIVATIONKEY = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVATIONKEY = "BBBBBBBBBB";

    private static final String DEFAULT_RESETKEY = "AAAAAAAAAA";
    private static final String UPDATED_RESETKEY = "BBBBBBBBBB";

    private static final Gender DEFAULT_GENDER = Gender.MALE;
    private static final Gender UPDATED_GENDER = Gender.FEMALE;

    private static final LocalDate DEFAULT_BIRTHDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_BIRTHDATE = LocalDate.now(ZoneId.systemDefault());

    private static final Ethnicity DEFAULT_ETHNICITY = Ethnicity.EUROPEAN;
    private static final Ethnicity UPDATED_ETHNICITY = Ethnicity.MAORI;

    private static final String DEFAULT_MARITAL_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_MARITAL_STATUS = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_DOCTOR = false;
    private static final Boolean UPDATED_IS_DOCTOR = true;

    private static final LocalDate DEFAULT_RESETDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RESETDATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restUserDetailsMockMvc;

    private UserDetails userDetails;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final UserDetailsResource userDetailsResource = new UserDetailsResource(userDetailsService);
        this.restUserDetailsMockMvc = MockMvcBuilders.standaloneSetup(userDetailsResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static UserDetails createEntity() {
        UserDetails userDetails = new UserDetails()
            .userid(DEFAULT_USERID)
            .activationkey(DEFAULT_ACTIVATIONKEY)
            .resetkey(DEFAULT_RESETKEY)
            .gender(DEFAULT_GENDER)
            .birthdate(DEFAULT_BIRTHDATE)
            .ethnicity(DEFAULT_ETHNICITY)
            .maritalStatus(DEFAULT_MARITAL_STATUS)
            .isDoctor(DEFAULT_IS_DOCTOR)
            .resetdate(DEFAULT_RESETDATE);
        return userDetails;
    }

    @Before
    public void initTest() {
        userDetailsRepository.deleteAll();
        userDetails = createEntity();
    }

    @Test
    public void createUserDetails() throws Exception {
        int databaseSizeBeforeCreate = userDetailsRepository.findAll().size();

        // Create the UserDetails
        UserDetailsDTO userDetailsDTO = userDetailsMapper.toDto(userDetails);
        restUserDetailsMockMvc.perform(post("/api/user-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDetailsDTO)))
            .andExpect(status().isCreated());

        // Validate the UserDetails in the database
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        assertThat(userDetailsList).hasSize(databaseSizeBeforeCreate + 1);
        UserDetails testUserDetails = userDetailsList.get(userDetailsList.size() - 1);
        assertThat(testUserDetails.getUserid()).isEqualTo(DEFAULT_USERID);
        assertThat(testUserDetails.getActivationkey()).isEqualTo(DEFAULT_ACTIVATIONKEY);
        assertThat(testUserDetails.getResetkey()).isEqualTo(DEFAULT_RESETKEY);
        assertThat(testUserDetails.getGender()).isEqualTo(DEFAULT_GENDER);
        assertThat(testUserDetails.getBirthdate()).isEqualTo(DEFAULT_BIRTHDATE);
        assertThat(testUserDetails.getEthnicity()).isEqualTo(DEFAULT_ETHNICITY);
        assertThat(testUserDetails.getMaritalStatus()).isEqualTo(DEFAULT_MARITAL_STATUS);
        assertThat(testUserDetails.isIsDoctor()).isEqualTo(DEFAULT_IS_DOCTOR);
        assertThat(testUserDetails.getResetdate()).isEqualTo(DEFAULT_RESETDATE);
    }

    @Test
    public void createUserDetailsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = userDetailsRepository.findAll().size();

        // Create the UserDetails with an existing ID
        userDetails.setId("existing_id");
        UserDetailsDTO userDetailsDTO = userDetailsMapper.toDto(userDetails);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUserDetailsMockMvc.perform(post("/api/user-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDetailsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the UserDetails in the database
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        assertThat(userDetailsList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void checkUseridIsRequired() throws Exception {
        int databaseSizeBeforeTest = userDetailsRepository.findAll().size();
        // set the field null
        userDetails.setUserid(null);

        // Create the UserDetails, which fails.
        UserDetailsDTO userDetailsDTO = userDetailsMapper.toDto(userDetails);

        restUserDetailsMockMvc.perform(post("/api/user-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDetailsDTO)))
            .andExpect(status().isBadRequest());

        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        assertThat(userDetailsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllUserDetails() throws Exception {
        // Initialize the database
        userDetailsRepository.save(userDetails);

        // Get all the userDetailsList
        restUserDetailsMockMvc.perform(get("/api/user-details?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(userDetails.getId())))
            .andExpect(jsonPath("$.[*].userid").value(hasItem(DEFAULT_USERID)))
            .andExpect(jsonPath("$.[*].activationkey").value(hasItem(DEFAULT_ACTIVATIONKEY.toString())))
            .andExpect(jsonPath("$.[*].resetkey").value(hasItem(DEFAULT_RESETKEY.toString())))
            .andExpect(jsonPath("$.[*].gender").value(hasItem(DEFAULT_GENDER.toString())))
            .andExpect(jsonPath("$.[*].birthdate").value(hasItem(DEFAULT_BIRTHDATE.toString())))
            .andExpect(jsonPath("$.[*].ethnicity").value(hasItem(DEFAULT_ETHNICITY.toString())))
            .andExpect(jsonPath("$.[*].maritalStatus").value(hasItem(DEFAULT_MARITAL_STATUS.toString())))
            .andExpect(jsonPath("$.[*].isDoctor").value(hasItem(DEFAULT_IS_DOCTOR.booleanValue())))
            .andExpect(jsonPath("$.[*].resetdate").value(hasItem(DEFAULT_RESETDATE.toString())));
    }

    @Test
    public void getUserDetails() throws Exception {
        // Initialize the database
        userDetailsRepository.save(userDetails);

        // Get the userDetails
        restUserDetailsMockMvc.perform(get("/api/user-details/{id}", userDetails.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(userDetails.getId()))
            .andExpect(jsonPath("$.userid").value(DEFAULT_USERID))
            .andExpect(jsonPath("$.activationkey").value(DEFAULT_ACTIVATIONKEY.toString()))
            .andExpect(jsonPath("$.resetkey").value(DEFAULT_RESETKEY.toString()))
            .andExpect(jsonPath("$.gender").value(DEFAULT_GENDER.toString()))
            .andExpect(jsonPath("$.birthdate").value(DEFAULT_BIRTHDATE.toString()))
            .andExpect(jsonPath("$.ethnicity").value(DEFAULT_ETHNICITY.toString()))
            .andExpect(jsonPath("$.maritalStatus").value(DEFAULT_MARITAL_STATUS.toString()))
            .andExpect(jsonPath("$.isDoctor").value(DEFAULT_IS_DOCTOR.booleanValue()))
            .andExpect(jsonPath("$.resetdate").value(DEFAULT_RESETDATE.toString()));
    }

    @Test
    public void getNonExistingUserDetails() throws Exception {
        // Get the userDetails
        restUserDetailsMockMvc.perform(get("/api/user-details/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateUserDetails() throws Exception {
        // Initialize the database
        userDetailsRepository.save(userDetails);
        int databaseSizeBeforeUpdate = userDetailsRepository.findAll().size();

        // Update the userDetails
        UserDetails updatedUserDetails = userDetailsRepository.findOne(userDetails.getId());
        updatedUserDetails
            .userid(UPDATED_USERID)
            .activationkey(UPDATED_ACTIVATIONKEY)
            .resetkey(UPDATED_RESETKEY)
            .gender(UPDATED_GENDER)
            .birthdate(UPDATED_BIRTHDATE)
            .ethnicity(UPDATED_ETHNICITY)
            .maritalStatus(UPDATED_MARITAL_STATUS)
            .isDoctor(UPDATED_IS_DOCTOR)
            .resetdate(UPDATED_RESETDATE);
        UserDetailsDTO userDetailsDTO = userDetailsMapper.toDto(updatedUserDetails);

        restUserDetailsMockMvc.perform(put("/api/user-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDetailsDTO)))
            .andExpect(status().isOk());

        // Validate the UserDetails in the database
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        assertThat(userDetailsList).hasSize(databaseSizeBeforeUpdate);
        UserDetails testUserDetails = userDetailsList.get(userDetailsList.size() - 1);
        assertThat(testUserDetails.getUserid()).isEqualTo(UPDATED_USERID);
        assertThat(testUserDetails.getActivationkey()).isEqualTo(UPDATED_ACTIVATIONKEY);
        assertThat(testUserDetails.getResetkey()).isEqualTo(UPDATED_RESETKEY);
        assertThat(testUserDetails.getGender()).isEqualTo(UPDATED_GENDER);
        assertThat(testUserDetails.getBirthdate()).isEqualTo(UPDATED_BIRTHDATE);
        assertThat(testUserDetails.getEthnicity()).isEqualTo(UPDATED_ETHNICITY);
        assertThat(testUserDetails.getMaritalStatus()).isEqualTo(UPDATED_MARITAL_STATUS);
        assertThat(testUserDetails.isIsDoctor()).isEqualTo(UPDATED_IS_DOCTOR);
        assertThat(testUserDetails.getResetdate()).isEqualTo(UPDATED_RESETDATE);
    }

    @Test
    public void updateNonExistingUserDetails() throws Exception {
        int databaseSizeBeforeUpdate = userDetailsRepository.findAll().size();

        // Create the UserDetails
        UserDetailsDTO userDetailsDTO = userDetailsMapper.toDto(userDetails);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restUserDetailsMockMvc.perform(put("/api/user-details")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDetailsDTO)))
            .andExpect(status().isCreated());

        // Validate the UserDetails in the database
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        assertThat(userDetailsList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    public void deleteUserDetails() throws Exception {
        // Initialize the database
        userDetailsRepository.save(userDetails);
        int databaseSizeBeforeDelete = userDetailsRepository.findAll().size();

        // Get the userDetails
        restUserDetailsMockMvc.perform(delete("/api/user-details/{id}", userDetails.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        assertThat(userDetailsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserDetails.class);
        UserDetails userDetails1 = new UserDetails();
        userDetails1.setId("id1");
        UserDetails userDetails2 = new UserDetails();
        userDetails2.setId(userDetails1.getId());
        assertThat(userDetails1).isEqualTo(userDetails2);
        userDetails2.setId("id2");
        assertThat(userDetails1).isNotEqualTo(userDetails2);
        userDetails1.setId(null);
        assertThat(userDetails1).isNotEqualTo(userDetails2);
    }

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UserDetailsDTO.class);
        UserDetailsDTO userDetailsDTO1 = new UserDetailsDTO();
        userDetailsDTO1.setId("id1");
        UserDetailsDTO userDetailsDTO2 = new UserDetailsDTO();
        assertThat(userDetailsDTO1).isNotEqualTo(userDetailsDTO2);
        userDetailsDTO2.setId(userDetailsDTO1.getId());
        assertThat(userDetailsDTO1).isEqualTo(userDetailsDTO2);
        userDetailsDTO2.setId("id2");
        assertThat(userDetailsDTO1).isNotEqualTo(userDetailsDTO2);
        userDetailsDTO1.setId(null);
        assertThat(userDetailsDTO1).isNotEqualTo(userDetailsDTO2);
    }
}
