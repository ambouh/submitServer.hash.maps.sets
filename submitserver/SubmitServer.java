package submitserver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SubmitServer {
	Map<String , Map> allSubmissions;
	
	public SubmitServer() {
		allSubmissions = new HashMap<String , Map>();
	}
	
  public void addSubmission(String id, int[] results) throws IllegalArgumentException {
	  
	  if (id == null || results == null)
		  throw new NullPointerException();
	  
	  if (results.length == 0)
		  throw new IllegalArgumentException();
	  
	//this is where all the submissions results for an id goes
	  Map<Integer, Integer> resultsById = allSubmissions.get(id);
	  //this gets the size of map + adds 1 to create id -- hash function
	  int unusedPosition = numSubmissions(id) + 1;
	  
	  if (allSubmissions.containsKey(id)) {
		    
		  //add new result to results-map using incremented id 
		  //called unusedPosition
		  /*so looks like 
		   *key: Nth, Value: next-result total -- inside a same id*/
		  resultsById.put(unusedPosition, addAResult(id, results));
	  } else {
		  /*adds the first result-map to id which also new to allSub, 
		   * so looks like key: 1, value: result-total */
		  allSubmissions.put(id, addResults(id, results));
	  }
  }

  
public int numSubmissions(String id) {
	int size;
	boolean containsKey = allSubmissions.containsKey(id);

	if (containsKey) 
		size = allSubmissions.get(id).size();
	else 
		size = 0;
	
	return size;
  }

  public int numSubmissions() {
    int allSize = 0;
    
    for (String aSub : allSubmissions.keySet()) {
    	allSize += this.numSubmissions(aSub);
    }
    
    return allSize;
  }

  public int bestSubmissionNumber(String id) {
	boolean containsKey = allSubmissions.containsKey(id);
    Map<Integer, Integer> allScoresById = allSubmissions.get(id);
    
	if (containsKey) {
    	return bestSubIDHelper(allScoresById, 0, 1, 1);
    }
	else 
		return 0;
  }

public int bestSubmissionScore(String id) {
	boolean containsKey = allSubmissions.containsKey(id);
	
	@SuppressWarnings("unchecked")
	Map<Integer, Integer> allScoresById = allSubmissions.get(id);
	
    if (containsKey) {
    	return bestScoreChecker(allScoresById, 0, 1);
    } else
    	return 0;
  }

  public boolean gotExtraCredit(String id) {
	  boolean containsKey = allSubmissions.containsKey(id);
	  boolean onlyOneSubExist = numSubmissions(id) == 1;
	  boolean gotAHundredOnIt = bestSubmissionScore(id) == 100;
	  boolean gotExtra = false;
	  
	  if (containsKey & onlyOneSubExist & gotAHundredOnIt )
		  gotExtra = true;
	  
	  return gotExtra;
	
  }

  public Set<String> gotExtraCredit() {
	  Set<String> students= new HashSet<String>();
	  
	  for (String aSub : allSubmissions.keySet()){
		  if(gotExtraCredit(aSub))
			  students.add(aSub);
	  }
	  return students;
  }
  
  /*HELPERS*/
  private Map<Integer, Integer> addResults(String id, int[] results) {
	Map<Integer, Integer> addedResults = new LinkedHashMap<Integer, Integer>();
	//this gets the size of map + adds 1 to create id -- hash function
	  int unusedPosition = numSubmissions(id) + 1;
	  
	int resultsTotal = 0;
	for (int aResult : results) {
		resultsTotal += aResult;
	}
	
   addedResults.put(unusedPosition, resultsTotal);
	return addedResults;
    } 
  
  private int addAResult(String id, int[] results){
        int resultsTotal= 0;
        for (int score : results){
            resultsTotal += score;
        }

        return resultsTotal;
        }
  
  private int bestSubIDHelper(Map<Integer, Integer> scores, int max, int key, int i){
      if (i == scores.size()){
          return key;
      }else {
          max = (scores.get(i) > max) ? scores.get(i) : max;
          key = i;
          return bestSubIDHelper(scores, max, key, i+1);
      }
  }


private int bestScoreChecker(Map<Integer, Integer> allScoresById, int max, int id) {
	// TODO Auto-generated method stub
	  if (id == allScoresById.size() + 1) {
		  return max;
	  } else {
		  max = allScoresById.get(id) > max? allScoresById.get(id) : max;
		  return bestScoreChecker(allScoresById, max, id+1);
	  }
}

 /*END HELPERS*/
    

}
