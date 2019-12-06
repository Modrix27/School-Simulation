
/**
 * Teacher class, child of Instructor. The same as Instructor, but the abstract 
 * methods for Instructor are defined here.
 * @author modrix
 */
public class Teacher extends Instructor {
	
	/**
	 * @param name Name of the teacher
	 * @param gender Gender of the teacher
	 * @param age Age of the teacher
	 */
	protected Teacher(String name, char gender, int age) {
		super(name, gender, age);
		Course assignedCourse = null;
	}

	/**
	 *Returns the teacher's name
	 */
	String getName() {
		return name;
	}

	/**
	 *Returns the teacher's gender
	 */
	char getGender( ) {
		return gender;
	}

	/**
	 *Returns the teacher's age
	 */
	int getAge() {
		return age;
	}

	/**
	 * Sets the teacher's age
	 */
	void setAge(int age) {
		this.age = age;
	}

	/**
	 * Assigns a course to the teacher if it's vacant and
	 * the course is featured in the school's list of courses
	 */
	void assignCourse(Course course) {
		if((course.courseIsAdded == true) && (course.hasInstructor() == false))
			assignedCourse = course;
		course.setInstructor(this);
	}

	/**
	 *Unassigns the course from the teacher
	 */
	void unassignCourse() {
		assignedCourse = null;
	}

	/**
	 *Returns the course the teacher is teaching
	 */
	Course getAssignedCourse() {
		return assignedCourse;
	}

	/**
	 *Checks whether the teacher can teach such subject
	 */
	boolean canTeach(Subject subject) {
		if(subject.specialism == 2)
			return true;
		else return false;
	}

	/**
	 *Checks whether the teacher has a course or not
	 */
	boolean hasCourse() {
		if(assignedCourse == null)
			return false;
		else return true;
	}

	/**
	 *Gets some info about the teacher
	 */
	public String toString() {
		if(hasCourse() == true)
			return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Demonstrator, " + assignedCourse.toString();
		else return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Status: Demonstrator, currently not teaching";
	}
}
