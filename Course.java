import java.util.ArrayList;
import java.util.Random;
/**
 * Here courses are created for the given subjects
 * @author modrix
 */
class Course {

	//Both random objects used for the grading system
	private Random testGrade = new Random();
	private Random testPrediction = new Random();

	protected Subject subject;
	private int daysUntilStarts;
	protected int daysToRun;

	/**
	 * This contains the students currently doing the course
	 */
	protected ArrayList<Student> enrolledStudents = new ArrayList<Student>(); 

	//Tells if the course is cancelled
	protected boolean cancelledCourse = false;

	//Tells if the course is added into the school list of courses so that is available to students/instructors
	protected boolean courseIsAdded = false;
	Instructor courseInstructor;
	private int studentGrade; 
	private int prediction;

	/**
	 * Here a course is created. It also needs an instructor and some students to not be cancelled.
	 * Depending of the ID of the subject, the course has a different duration (daysToRun).
	 * This is set using the switch() method
	 * @param subject The subject that will be teached
	 * @param daysUntilStarts Days to wait until the course starts
	 */
	Course(Subject subject, int daysUntilStarts) {

		courseInstructor = null;
		this.subject = subject;
		this.daysUntilStarts = daysUntilStarts;

		int s = getSubject().ID;
		switch(s) {
		case 10:
			daysToRun = 5;
			break;
		case 2:
		case 6:
		case 11:
			daysToRun = 2;
			break;
		case 1:
		case 3:
		case 5:
		case 9:
		case 12:
			daysToRun = 3;
			break;
		case 4:
			daysToRun = 1;
			break;
		case 7:
			daysToRun = 6;
			break;
		case 8:
			daysToRun = 7;
			break;
		}
	}

	/**
	 * Assigns an instructor to the course if he is not assigned yet to any course and if it can teach it
	 * (as they have different specialties depending on the type of instructor)
	 * @param instructor The instructor to be assigned to this course
	 * @return Returns whether the given instructor has been assigned to this course or not
	 */
	boolean setInstructor(Instructor instructor) {
		if((instructor.assignedCourse == null) && (instructor.canTeach(this.subject) == true)) {
			courseInstructor = instructor;
			instructor.assignCourse(this);
			return true;
		}

		else return false;
	}

	/**
	 * @return Returns whether the course has an instructor or not
	 */
	boolean hasInstructor() {
		if(courseInstructor == null)
			return false;
		else return true;
	}

	/**
	 * Method that cancels the course if there are no students
	 * or no instructor. Clears the array of students (if any) and unassigns the
	 * instructor (if any). Also removes the course from the list of courses that 
	 * teach this course's subject. Method used only when the course has started 
	 * and there are either no enrolled students or no instructor.
	 */
	void cancelCourse() {
		if(enrolledStudents.size() > 0)
			enrolledStudents.clear();
		if(hasInstructor() == true) {
			courseInstructor.unassignCourse();
			courseInstructor = null;
		}
		subject.coursesWithThisSubject.remove(this);
		cancelledCourse = true;
	}

	/**
	 * @return Returns whether the course is cancelled or not
	 */
	boolean isCancelled() {
		return cancelledCourse;
	}

	/**
	 * @return subject The course's subject
	 */
	Subject getSubject() {
		return subject;
	}

	/**
	 * Enrolls the students if he doesn't have the certificate of this course,
	 * there are available places in the course (3 students at most per course) and
	 * he is not yet enrolled to any course.
	 * @param enrolledStudent The student to be enrolled
	 * @return returns whether the student has been enrolled or not
	 */
	boolean enrolStudent(Student enrolledStudent) {
		for(Integer subjectCertificate: enrolledStudent.certificates)
			if(this.subject.ID == subjectCertificate)
				return false;
		if((enrolledStudents.size() < 3) && (daysUntilStarts > 0) && (enrolledStudent.hasCourse == false)) {
			enrolledStudents.add(enrolledStudent);
			enrolledStudent.hasCourse = true;
			return true;
		}
		return false;
	}

	/**
	 * Method that simulates a day of this course.
	 * Decreases the count of daysUntilStarts if it hasn't started yet, 
	 * cancels the course if it starts to day and there are no students/instructor, 
	 * and gives a test to the students in the last day of the course.
	 */
	void aDayPasses() {
		daysUntilStarts--;

		if(daysUntilStarts == 0 && ((courseInstructor == null)||(enrolledStudents.size() == 0)))
			cancelCourse();

		if (daysUntilStarts < 0)
			if (daysToRun > 0)
				daysToRun--;


		if (daysToRun == 0) {	
			if(enrolledStudents.size() > 0) {
				System.out.println("Test time!");
				System.out.println();

				/*
				 * To make it more realistic, I chose a 25% chance of getting a bad grade, 50% for a decent grade and 25% for an excellent grade
				 * (Something like the Bell Curve). Check the README text for more info about the grades. The grades are determined by random number generators
				 */
				for(Student enrolledStudent: enrolledStudents) {
					prediction = 1 + testPrediction.nextInt(100);

					if(prediction <= 25) {
						studentGrade = 1 + testGrade.nextInt(45);
					}

					if((prediction > 25) && (prediction <= 75)) {
						studentGrade = 40 + testGrade.nextInt(41);
					}

					if(prediction > 75) {
						studentGrade = 70 + testGrade.nextInt(31);
					}

					/*
					 * Pass the test and you get the certificate. Fail it and you don't get anything.
					 * The grades are also displayed in the console.
					 */
					System.out.println(enrolledStudent.name + " got a grade of " + studentGrade);

					if(studentGrade > 39) {
						enrolledStudent.testPassed = true;
						enrolledStudent.graduate(subject);
						System.out.println(enrolledStudent.name + " has received the certificate for the subject " + subject.description); 
					}	

					enrolledStudent.hasCourse = false;
				}

				//Removes all students from the course after the test
				enrolledStudents.clear();
				System.out.println();
			}

			//Removes the instructor from the course and the course from the list of courses of that subject
			if(hasInstructor() == true) {
				courseInstructor.unassignCourse();
				courseInstructor = null;
			}
			subject.coursesWithThisSubject.remove(this);
			System.out.println();
		}
	}

	/**
	 * Tells you how many days are left for the course to start/finish
	 * @return Returns a negative of the days left until the course starts, 
	 * or a positive of the days left until the course finishes.
	 */
	int getStatus() {
		if (daysUntilStarts > 0) {
			int x;
			x = -daysUntilStarts; 
			return x;
		}
		else return daysToRun;  
	}

	/**
	 * @return Return the number of enrolled students
	 */
	int getSize() {
		return enrolledStudents.size();
	}

	/**
	 * @return Returns an array of the students in the course. Used to display their info
	 */
	Student[] getStudents() {
		Student[] students = new Student[enrolledStudents.size()];
		students = enrolledStudents.toArray(students);
		return students;
	}

	/**
	 * @return Returns a string of each student's info from the course
	 */
	String studentsInThisCourse() {
		String studentData = "";
		for(Student student: enrolledStudents)
			studentData += student.toString() + "\n\r";
		return studentData;
	}

	/**
	 * @return Returns whether the course has students or not
	 */
	boolean hasStudents() {
		if(enrolledStudents.size() == 0)
			return false;
		else return true;
	}

	/**
	 * Returns information about the course
	 */
	public String toString() {
		if(hasStudents() == true)
			return "Course information: " + subject + ", " + "Days until the course starts: " + daysUntilStarts + "\n\r" + "Enrolled students:\n\r " 
			+ studentsInThisCourse();
		else return "Course information: " + subject + ", " + "Days until the course starts: " + daysUntilStarts;
	}

}
