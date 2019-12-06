
/**
 * GUITrainer class, child of Instructor. The same as Instructor, but the abstract 
 * methods for Instructor are defined here.
 * @author modrix
 */
public class GUITrainer extends Teacher {
	
	/**
	 * @param name Name of the trainer
	 * @param gender Gender of the trainer
	 * @param age Age of the trainer
	 */
	protected GUITrainer(String name, char gender, int age) {
		super(name, gender, age);
		Course assignedCourse = null;
		uniqueSpeciality = 4;
	}

	/**
	 *Returns the trainer's name
	 */
	String getName() {
		return name;
	}

	/**
	 *Returns the trainer's gender
	 */
	char getGender( ) {
		return gender;
	}

	/**
	 *Returns the trainer's age
	 */
	int getAge() {
		return age;
	}

	/**
	 * Sets the trainer's age
	 */
	void setAge(int age) {
		this.age = age;
	}

	/**
	 * Assigns a course to the trainer if it's vacant and
	 * the course is featured in the school's list of courses
	 */
	void assignCourse(Course course) {
		if((course.courseIsAdded == true) && (course.hasInstructor() == false))
			assignedCourse = course;
		course.setInstructor(this);
	}

	/**
	 *Unassigns the course from the trainer
	 */
	void unassignCourse() {
		assignedCourse = null;
	}

	/**
	 *Returns the course the trainer is teaching
	 */
	Course getAssignedCourse() {
		return assignedCourse;
	}

	/**
	 *Checks whether the trainer can teach such subject
	 */
	boolean canTeach(Subject subject) {
		if(subject.specialism == 2)
			return true;
		else return false;
	}

	/**
	 *Checks whether the trainer has a course or not
	 */
	boolean hasCourse() {
		if(assignedCourse == null)
			return false;
		else return true;
	}

	/**
	 *Gets some info about the trainer
	 */
	public String toString() {
		if(hasCourse() == true)
			return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Demonstrator, " + assignedCourse.toString();
		else return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Demonstrator, currently not teaching";
	}
}
