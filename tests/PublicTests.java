package tests;

// (c) Larry Herman, 2015.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import submitserver.SubmitServer;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // Tests adding one submission to a SubmitServer, then calling
  // numSubmissions() to check the total number of submissions made.
  @Test public void testPublic1() {
    SubmitServer server= new SubmitServer();

    server.addSubmission("billy",
                         new int[]{10,  0, 10, 10,  0, 10, 10,  0, 10, 10});

    assertEquals(1, server.numSubmissions());
  }

  // Tests adding several submissions to a SubmitServer, all for the same
  // student, then calling numSubmissions() to check the number of
  // submissions made for that student.
  @Test public void testPublic2() {
    SubmitServer server= exampleSubmitServer1();

    assertEquals(4, server.numSubmissions("julie"));
  }

  // Tests adding several submissions to a SubmitServer, all for the same
  // student, then calling numsubmissions() to check the total number of
  // submissions made for all students, which in this case should be the
  // same as the total number of submissions made for that student.
  @Test public void testpublic3() {
    SubmitServer server= exampleSubmitServer1();

    assertEquals(4, server.numSubmissions());
  }

  // Tests adding several submissions to a SubmitServer, for different
  // students, then calling bestsubmissionscore() on one of them.
  @Test public void testpublic4() {
    SubmitServer server= exampleSubmitServer2();

    assertEquals(90, server.bestSubmissionScore("sally"));
  }

  // Tests adding several submissions to a SubmitServer, for different
  // students, then tests the results of the form of gotExtraCredit() that
  // returns a set of the students who got extra credit on the project.
  @Test public void testpublic5() {
    SubmitServer server= exampleSubmitServer3();
    Set<String> results= server.gotExtraCredit();
    String[] correctresults= new String[]{"polly", "susie"};
    int i;

    // make sure that all the names that should be in the result set are in it
    for (i= 0; i < correctresults.length; i++)
      assertTrue(results.contains(correctresults[i]));

    // make sure that no other names are in the result set
    assertEquals(2, results.size());
  }

  // private utility methods ////////////////////////////////////////////

  SubmitServer exampleSubmitServer1() {
    SubmitServer server= new SubmitServer();

    server.addSubmission("julie",
                         new int[]{ 0, 10, 10,  0,  0,  0,  0,  0,  0,  0});
    server.addSubmission("julie",
                         new int[]{ 0, 10, 10,  0,  0,  0,  0, 10, 10,  0});
    server.addSubmission("julie",
                         new int[]{ 0, 10, 10,  0,  0,  0,  0,  0, 10, 10});
    server.addSubmission("julie",
                         new int[]{ 0, 10, 10,  0,  0, 10, 10,  0, 10,  0});

    return server;
  }

  SubmitServer exampleSubmitServer2() {
    SubmitServer server= new SubmitServer();

    server.addSubmission("sally",
                         new int[]{10,  0, 10, 10,  0, 10, 10,  0, 10, 10});
    server.addSubmission("sally",
                         new int[]{10, 10,  0, 10, 10, 10, 10,  0, 10, 10});
    server.addSubmission("sally",
                         new int[]{10, 10, 10, 10, 10, 10, 10,  0, 10, 10});
    server.addSubmission("ellie",
                         new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    server.addSubmission("sally",
                         new int[]{ 0, 10,  0, 10, 10, 10, 10, 10,  0, 10});
    server.addSubmission("sally",
                         new int[]{10, 10,  0, 10, 10, 10, 10, 10,  0, 10});

    return server;
  }

  SubmitServer exampleSubmitServer3() {
    SubmitServer server= new SubmitServer();

    server.addSubmission("jennie",
                         new int[]{10,  0, 10, 10,  0, 10, 10,  0, 10, 10});
    server.addSubmission("polly",
                         new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    server.addSubmission("jennie",
                         new int[]{10, 10,  0, 10, 10, 10, 10,  0, 10, 10});
    server.addSubmission("jennie",
                         new int[]{10, 10, 10, 10, 10, 10, 10,  0, 10, 10});
    server.addSubmission("susie",
                         new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
    server.addSubmission("jennie",
                         new int[]{ 0, 10,  0, 10, 10, 10, 10, 10,  0, 10});

    return server;
  }

}
