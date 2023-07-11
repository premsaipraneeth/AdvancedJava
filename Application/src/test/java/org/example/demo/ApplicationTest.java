package org.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    @Mock
    private SubmissionService submissionService;

    @InjectMocks
    private SubmissionResource submissionResource;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostSubmission() {
        SubmissionForm inputForm = new SubmissionForm();
        inputForm.setName("Prem");
        inputForm.setVendorName("K-Force");
        inputForm.setRate(80);
        inputForm.setLeadName("Tejaan");
        inputForm.setTechnology("Java");

        when(submissionService.postSubmission(inputForm)).thenAnswer(invocation -> {
            SubmissionForm form = invocation.getArgument(0);
            form.setId("sampleId");
            return form;
        });
        SubmissionForm resultForm = submissionResource.postSubmission(inputForm);
        assertNotNull(resultForm.getId());
        verify(submissionService, times(1)).postSubmission(inputForm);    }

    @Test
    public void testGetSubmissionFormById() {
        String id = "sampleId";
        SubmissionForm expectedForm = new SubmissionForm();
        expectedForm.setId(id);
        expectedForm.setName("Prem");
        expectedForm.setVendorName("K-Force");
        expectedForm.setRate(80);
        expectedForm.setLeadName("Tejaan");
        expectedForm.setTechnology("Java");

        when(submissionService.getSubmissionFormById(id)).thenReturn(expectedForm);


        SubmissionForm resultForm = submissionResource.getSubmissionFormById(id);

        assertNotNull(resultForm.getId());
        verify(submissionService, times(1)).getSubmissionFormById(id);
    }

    @Test
    public void testEditSubmission() {
        SubmissionForm inputForm = new SubmissionForm();
        inputForm.setId("sampleId");
        inputForm.setName("Prem");
        inputForm.setVendorName("K-Force");
        inputForm.setRate(80);
        inputForm.setLeadName("Tejaan");
        inputForm.setTechnology("Java");

        when(submissionService.editSubmission(inputForm)).thenAnswer(invocation -> {
            SubmissionForm form = invocation.getArgument(0);
            return form;
        });

        SubmissionForm resultForm = submissionResource.editSubmission(inputForm);

        assertNotNull(resultForm.getId());
        verify(submissionService, times(1)).editSubmission(inputForm);
    }

    @Test
    public void testDeleteSubmission() {
        // Arrange
        String id = "sampleId";
        List<SubmissionForm> expectedList = Arrays.asList(
                new SubmissionForm("Prem", "K-Force", 80, "Tejaan", "Java"),
                new SubmissionForm("Akhil", "Tek Systems", 200, "Jagadish", "Full Stack")
        );

        when(submissionService.deleteSubmission(id)).thenReturn(expectedList);

        // Act
        List<SubmissionForm> resultList = submissionResource.deleteSubmission(id);

        // Assert
        assertEquals(expectedList, resultList);
        verify(submissionService, times(1)).deleteSubmission(id);
    }
}