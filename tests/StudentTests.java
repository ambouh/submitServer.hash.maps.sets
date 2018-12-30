package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.*;

import submitserver.SubmitServer;
import static org.junit.Assert.*;

public class StudentTests {

	
	//get size for a non-submitted name
	@Test public void studentTest10() {
		SubmitServer server = new SubmitServer();
		assertEquals(0, server.numSubmissions("Eric"));
	}
	
	//get size to match server submission, and  student submission
	@Test public void studentTest10_5() {
		SubmitServer server = new SubmitServer();
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 5});
		server.addSubmission("Eric", new int[]{1, 2});
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 6});
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 6});
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 6});
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 6});
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 6});
		
		assertEquals(server.numSubmissions(), server.numSubmissions("Eric"));
	}
	
	//test if it return best submission's ID
	@Test public void studentTest11() {
		SubmitServer server = new SubmitServer();
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 5});
		assertEquals(1, 
				server.bestSubmissionNumber("Eric"));
		
		//best submission
		server.addSubmission("Eric", new int[]{1, 5, 3, 3, 5});

		server.addSubmission("Eric", new int[]{1, 3, 3, 3, 5});
		assertEquals(2, 
				server.bestSubmissionNumber("Eric"));
	}
	
	//test to see if it returns best submissions score
	@Test public void studentTest12() {
		SubmitServer server = new SubmitServer();
		server.addSubmission("Eric", new int[]{1, 2, 3, 4, 5});
		assertEquals(1, 
				server.bestSubmissionNumber("Eric"));
		
		//best submission
		server.addSubmission("Eric", new int[]{1, 5, 3, 3, 5});

		server.addSubmission("Eric", new int[]{1, 3, 3, 3, 5});
		assertEquals(17, 
				server.bestSubmissionScore("Eric"));
	}
	
	//test if null id gets extra
    @Test public void studentTest13() {
    	SubmitServer server = new SubmitServer();
		server.addSubmission("Eric", new int[]{85, 3, 3, 4, 5});
		
		boolean bestScore = server.gotExtraCredit("Eric");
		
		assertTrue(bestScore);
		
		server.addSubmission("Eric", new int[]{85, 3, 3, 4, 5});
		
		bestScore = server.gotExtraCredit(null);
		
		assertFalse(bestScore);
		
	}
    
    //test if all student are being add to gotExtraCredit
    @Test public void studentTest14() {
    	SubmitServer server = new SubmitServer();
		assertEquals(0, server.gotExtraCredit().size());
    	
		server.addSubmission("Eric", new int[]{85, 3, 3, 4, 5});
		server.addSubmission("John", new int[]{100});
		assertEquals(server.numSubmissions(), server.gotExtraCredit().size());
		
	}
    
}