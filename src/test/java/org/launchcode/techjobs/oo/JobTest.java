package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName() instanceof String);
        assertEquals(testJob.getName(), "Product tester");
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse((testJob1).equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),new PositionType("Back-end developer"), new CoreCompetency("Java"));
        assertTrue(testJob.toString().startsWith(lineSeparator()));
        assertTrue(testJob.toString().endsWith(lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"),new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String jobString = testJob.toString();
        assertEquals(jobString, lineSeparator()+"ID: "+testJob.getId()+lineSeparator()+"Name: "+testJob.getName()+lineSeparator()+"Employer: "+testJob.getEmployer()+lineSeparator()+"Location: "+testJob.getLocation()+lineSeparator()+"Position Type: "+testJob.getPositionType()+lineSeparator()+"Core Competency: "+testJob.getCoreCompetency()+lineSeparator());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("Web Developer", new Employer(""), new Location("StL"),new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String jobString = testJob.toString();
        assertEquals(jobString, lineSeparator()+"ID: "+testJob.getId()+lineSeparator()+"Name: "+testJob.getName()+lineSeparator()+"Employer: "+testJob.getEmployer()+lineSeparator()+"Location: "+testJob.getLocation()+lineSeparator()+"Position Type: "+testJob.getPositionType()+lineSeparator()+"Core Competency: "+testJob.getCoreCompetency()+lineSeparator());
    }
}