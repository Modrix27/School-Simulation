
/**
 * Base plate for the instructors. Teacher, Demonstrator, OOTrainer and GUITrainer derive from this class.
 * Each instructor has a name, an age, a gender, some specialties and an assigned course.
 * Some methods are abstract as each child has a different implementation of them.
 * @author modrix
 */
public abstract class Instructor extends Person implements Comparable <Instructor> {

	Course assignedCourse = null;

	abstract void assignCourse(Course course);
	abstract void unassignCourse();
	abstract Course getAssignedCourse();
	abstract boolean hasCourse();
	abstract boolean canTeach(Subject subject);
	int uniqueSpeciality;

	/**
	 * @param name Name of the instructor
	 * @param gender Gender of the instructor
	 * @param age Age of the instructor
	 */
	protected Instructor(String name, char gender, int age) {
		super(name, gender, age);
	}

	/**
	 *Returns the instructor's name
	 */
	String getName() {
		return name;
	}

	/**
	 *Returns the instructor's gender
	 */
	char getGender( ) {
		return gender;
	}

	/**
	 *Returns the instructor's age
	 */
	int getAge() {
		return age;
	}

	/**
	 * Sets the instructor's age
	 */
	void setAge(int age) {
		this.age = age;
	}

	/**
	 *Method made so that each instructor occupies first the courses which its unique specialty
	 *(he is the only one who can teach the subjects with such specialty). 
	 */
	public int compareTo(Instructor instructor) 
	{   
		if (this.uniqueSpeciality > instructor.uniqueSpeciality) {
			return 1;
		}
		else if(this.uniqueSpeciality < instructor.uniqueSpeciality) {
			return -1;
		}
		else return 0;
	}
	
	/**
	 * Prints information about the instructor 
	 */
	public String toString() {
		if(getAssignedCourse() != null)
		return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender + ", Currently teaching" + getAssignedCourse().toString();
		else return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender;
	}
}
