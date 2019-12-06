
import java.util.ArrayList;

/**
 * The Student class. Each student has a name, an age, a gender and an ArrayList of obtained certificates.
 * @author modrix
 */
class Student extends Person {

	//Verifiers for whether he his enrolled in a course or not, and whether he passed a test ot not
	protected boolean hasCourse = false;
	protected boolean testPassed = false;
	
	//each new element of this list means that the student has passed a certain subject
	protected ArrayList<Integer> certificates = new ArrayList<Integer>();

	/**
	 * Student constructor. It inherits the name, gender and age from the Person parent class.
	 * @param name
	 * @param gender
	 * @param age
	 */
	public Student(String name, char gender, int age) {
		super(name, gender, age);
	}

	/**
	 * Method to graduate the student on a specific subject (he/she gets the certificate)
	 * @param subject The subject the student has passed
	 */
	void graduate(Subject subject) {
		certificates.add(subject.ID);
	}

	/**
	 * @return certificates The certificates of the students
	 */
	ArrayList<Integer> getCertificates() {
		return certificates;
	}

	/**
	 * Checks if the students has a particular certificate
	 * @param requestedSubject
	 * @return Returns whether the students has the certificate or not
	 */
	boolean hasCertificate(Subject requestedSubject) {
		for(Integer subjectIDLoop: certificates)
			if(subjectIDLoop.equals(requestedSubject.ID))
				return true;
		return false;
	}
	
	/**
	 * @return stringOfCertificates A string containing the certificates of the students, separated by a space and comma
	 */
	String certificatesString() {
		String stringOfCertificates = "";
		for(Integer certificate: certificates)
			stringOfCertificates += certificate + ", ";
		return stringOfCertificates;
	}

	/**
	 * Returns a string with some information about the student
	 */
	public String toString() {
		return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Student, Certificates: "
				+ certificatesString();
	}
}
