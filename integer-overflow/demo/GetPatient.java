// Copyright 2012 Andrew Meneely. 
// Licensed under the Educational Community License, Version 2.0 (the "License"); 
// you may not use this file except in compliance with the License. 
// You may obtain a copy of the License at http://www.osedu.org/licenses/ECL-2.0. 
// Unless required by applicable law or agreed to in writing, 
// software distributed under the License is distributed on an "AS IS" BASIS, 
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
// See the License for the specific language governing permissions 
// and limitations under the License.

/**
 * An example of Integer Overflow.
 * 
 * The system is supposed to pull the health records of the patient named 
 * "Chuck Norris". But, in obtaining  * the patientID, it casts a "long" to 
 * an "int", which silently wraps around to a different patient ID (18 
 * instead). The wrong records are returned, and a HIPAA violation ensues.
 * 
 * Mitigations for this example: 
 * 		* Don't cast to int if you don't have to.
 * 		* Check for overflow yourself when it's important.
 */
public class GetPatient {

	public static void main(String[] args) {
		int patientID = (int) getPatient("Chuck Norris");
		//         oops ^^^^^
		System.out
				.println("Patient ID should be 4294967314L, but is: "
						+ patientID);
	}

	private static long getPatient(String string) {
		return 4294967314L;
	}
}
