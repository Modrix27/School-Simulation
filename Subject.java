import java.util.ArrayList;

/**
 * The Subject class. Here subjects are made. Each subject has an ID, a specialism,
 * a duration and a description depending on the ID. Each subject also has an ArrayList containing
 * all current courses that teach this sunject.
 * @author modrix
 */
class Subject {

	int ID;
	int specialism;
	int duration;
	String description;
	ArrayList<Course> coursesWithThisSubject = new ArrayList<Course>();

	/**
	 * The constructor for the Subject. The description is set depending 
	 * in the ID of the subject using a switch method.
	 * @param ID The ID of the subject
	 * @param specialism The specialism of the subject
	 * @param duration The duration in days of the subject
	 */
	Subject(int ID, int specialism, int duration) {
		this.ID = ID;
		this.specialism = specialism;
		this.duration = duration;
		switch(ID) {
		case 1:
			description = "Basics";
			break;
		case 2:
			description = "Lab 1";
			break;
		case 3:
			description = "Arrays";
			break;
		case 4:
			description = "Algorithms";
			break;
		case 5:
			description = "Testing and Debugging";
			break;
		case 6:
			description = "Lab 2";
			break;
		case 7:
			description = "Object-Oriented 1";
			break;
		case 8:
			description = "Object-Oriented 2";
			break;
		case 9:
			description = "Lab 3";
			break;
		case 10:
			description = "Graphics";
			break;
		case 11:
			description = "Controllers";
			break;
		case 12:
			description = "GUI";
			break;
		}
	}

	/**
	 * Getter of the ID of the subject.
	 * @return ID The ID of the subject
	 */
	int getID() {
		return ID;
	}

	/**
	 * Getter of the subject's specialism
	 * @return specialism The specialism of the subject
	 */
	int getSpecialism() {
		return specialism;
	}

	/**
	 * Getter of the subject's duration
	 * @return duration The duration of the subject (in days)
	 */
	int getDuration() {
		return duration;
	}

	/**
	 * Setter of the subject's description
	 * @param description the new description of the subject
	 */
	void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter of the subject's decsription
	 * @return description The description of the subject
	 */
	String getDescription() {
		return description;
	}

	/**
	 * Method to return all courses teaching this subject, one per line.
	 * @return courseNames A string with all course names
	 */
	public String getAllCourses() {
		String courseNames = "";
		for(Course course: coursesWithThisSubject) {
			courseNames += course.toString();
			courseNames += "\n\r" + " ";
		}
		return courseNames;
	}

	/**
	 * Method that returns a string containing information about the subject.
	 */
	public String toString() {
		return "Subject ID: " + ID + ", " + "Specialism: " + specialism + ", " + "Duration: " + duration + " days, " + "Description: " + description;
	}
}
