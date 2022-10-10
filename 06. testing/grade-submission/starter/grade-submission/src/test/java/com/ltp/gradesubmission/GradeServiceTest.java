package com.ltp.gradesubmission;

import com.ltp.gradesubmission.pojo.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepositoryMock;

    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGradeFromRepoTest(){
        when(gradeRepositoryMock.getGrades()).thenReturn(Arrays.asList(
                new Grade("Harry", "Positions", "C-"),
                new Grade("Hermoney", "Arithmency", "A-")
        ));
        List<Grade> result = gradeService.getGrades();

        assertEquals("Harry", result.get(0).getName());
        assertEquals("Hermoney", result.get(1).getName());
    }

    @Test
    public void getGradeIndexTest(){
        Grade grade = new Grade("Harry", "Positions", "C-");

        when(gradeRepositoryMock.getGrades()).thenReturn(List.of(
                grade
        ));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        int valid = gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void getGradeByIdTest(){
        Grade grade = new Grade("Harry", "Positions", "C-");

        when(gradeRepositoryMock.getGrades()).thenReturn(List.of(
                grade
        ));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);


        String id = grade.getId();
        Grade gradeResult = gradeService.getGradeById(id);

        assertEquals(grade, gradeResult);
    }

    @Test
    public void addGradeTest(){
        Grade grade = new Grade("Harry", "Positions", "C-");

        when(gradeRepositoryMock.getGrades()).thenReturn(List.of(
                grade
        ));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        Grade newGrade = new Grade("Herm","Arithmancy", "A+");

        gradeService.submitGrade(newGrade);

        verify(gradeRepositoryMock, times(1)).addGrade(newGrade);
    }

    @Test
    public void updateGradeTest(){
        Grade grade = new Grade("Harry", "Positions", "C-");

        when(gradeRepositoryMock.getGrades()).thenReturn(List.of(
                grade
        ));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);
        grade.setScore("A-");
        gradeService.submitGrade(grade);
        verify(gradeRepositoryMock,times(1))
                .updateGrade(grade,0);
    }
        
}
