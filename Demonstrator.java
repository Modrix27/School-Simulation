
/**
 * Demonstrator class, child of Instructor. The same as Instructor, but the abstract 
 * methods for Instructor are defined here.
 * @author modrix
 */
public class Demonstrator extends Instructor {

	/** Constructor of the Demonstrator
	 * @param name Name of the Demonstrator
	 * @param gender Gender of the Demonstrator
	 * @param age Age of the Demonstrator
	 */
	protected Demonstrator(String name, char gender, int age) {
		super(name, gender, age);
		uniqueSpeciality = 2;
	}

	/**
	 *Returns the demonstrator's name
	 */
	String getName() {
		return name;
	}

	/**
	 *Returns the demonstrator's gender
	 */
	char getGender( ) {
		return gender;
	}

	/**
	 *Returns the demonstrator's age
	 */
	int getAge() {
		return age;
	}

	/**
	 * Sets the demonstrator's age
	 */
	void setAge(int age) {
		this.age = age;
	}

	/**
	 * Assigns a course to the demonstrator if it's vacant and
	 * the course is featured in the school's list of courses
	 */
	void assignCourse(Course course) {
		if((course.courseIsAdded == true) && (course.hasInstructor() == false))
			assignedCourse = course;
		course.setInstructor(this);
	}

	/**
	 *Unassigns the course from the demonstrator
	 */
	void unassignCourse() {
		assignedCourse = null;
	}

	/**
	 *Returns the course the demonstrator is teaching
	 */
	Course getAssignedCourse() {
		return assignedCourse;
	}

	/**
	 *Checks whether the demonstrator can teach such subject
	 */
	boolean canTeach(Subject subject) {
		if(subject.specialism == 2)
			return true;
		else return false;
	}

	/**
	 *Checks whether the demonstrator has a course or not
	 */
	boolean hasCourse() {
		if(assignedCourse == null)
			return false;
		else return true;
	}

	/**
	 *Gets some info about the demonstrator
	 */
	public String toString() {
		if(hasCourse() == true)
			return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Demonstrator, " + assignedCourse.toString();
		else return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Demonstrator, currently not teaching";
	}
}
