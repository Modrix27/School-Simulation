import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

/**
 * The School class. It has a name, some array for the students, courses, subjects, and instructors, ,
 * and methods to simulate a school day and to display information about what happened that day.
 * getters and setters for all of them, some random objects for the probabilities for people joining/leaving the school
 * @author modrix
 */
public class School {

	String name;

	/**
	 * Variable used to determine the time in ms that the program is paused 
	 */
	int sleepTime;

	//The first 4 arrays are for the components of the school. They are static so that they can be accessed from the Reader
	//class without creating a School (the processed data from the configuration file has to be placed into their
	//respective arrays).
	static ArrayList<Student> studentArray = new ArrayList<Student>();
	static ArrayList<Instructor> instructorArray = new ArrayList<Instructor>();
	static ArrayList<Subject> subjectArray = new ArrayList<Subject>();
	static ArrayList<Course> courseArray = new ArrayList<Course>();
	ArrayList<Course> coursesToRemove = new ArrayList<Course>();

	//The next two array lists contain male/female names for the random person generator.
	ArrayList<String> maleNames = new ArrayList<String>();
	ArrayList<String> femaleNames = new ArrayList<String>();
	ArrayList<Person> peopleToLeave = new ArrayList<Person>();

	//Random objects for number of new students, the age of a person, the probabilities
	//of an instructor type to join the school and the gender of the person
	Random newPerson = new Random();
	Random personAge = new Random();
	Random newTeacher = new Random();
	Random newOOTrainer = new Random();
	Random newDemonstrator = new Random();
	Random newGUITrainer = new Random();
	Random gender = new Random();

	/**
	 * School constructor. It has a name passed as an argument and 
	 * some male/female names used by the random person generator.
	 * @param name The school's name
	 */
	public School(String name) {

		this.name = name;

		maleNames.add("Marian");
		maleNames.add("Andrei");
		maleNames.add("Alin");
		maleNames.add("Ionut");
		maleNames.add("Petru");
		maleNames.add("Vasile");
		maleNames.add("Pavel");
		maleNames.add("Dorian");
		maleNames.add("Denis");

		femaleNames.add("Maria");
		femaleNames.add("Elena");
		femaleNames.add("Laura");
		femaleNames.add("Andreea");
		femaleNames.add("Alexandra");
		femaleNames.add("Crina");
		femaleNames.add("Lavinia");
		femaleNames.add("Ana");
		femaleNames.add("Daniela");
	}

	/**
	 * The student given as an argument is added to the student array.
	 * @param addedStudent Student to be added
	 */
	void addStudent(Student addedStudent) {
		studentArray.add(addedStudent);
	}

	/**
	 * The student given as an argument is removed from the student array.
	 * @param removedStudent Student to be removed
	 */
	void removeStudent(Student removedStudent) {
		studentArray.remove(removedStudent);
	}

	/**
	 * Returns the array of students.
	 * @return studentArray The array of students
	 */
	ArrayList<Student> getStudents() {
		return studentArray;
	}

	/**
	 * Method which adds an instructor to the instructor array and sorts the instructors by their unique specialty. This is the order:
	 * Teacher (unique specialty 1), Demonstrator (unique specialty 2), OO Trainer (unique specialty 3), GUI Trainer (unique specialty 4).
	 * Each instructor will first look after vacant courses with their unique specialty, if not, they will look after other courses they can teach (each instructor
	 * has a determined order of specialties in their respective classes).
	 * @param addedInstructor Instructor to be added
	 */
	void addInstructor(Instructor addedInstructor) {
		instructorArray.add(addedInstructor);
		Collections.sort(instructorArray);
	}

	/**
	 * Method to remove an instructor.
	 * @param removedInstructor Instructor to remove
	 */
	void removeInstructor(Instructor removedInstructor) {
		instructorArray.remove(removedInstructor);
	}

	/**
	 * Method to return the array of instructors.
	 * @return instructorArray The array of instructors
	 */
	ArrayList<Instructor> getInstructors() {
		return instructorArray;
	}

	/**
	 * Method to add a subject.
	 * @param addedSubject Subject to add.
	 */
	void addSubject(Subject addedSubject) {
		subjectArray.add(addedSubject);
	}

	/**
	 * Method to remove a subject.
	 * @param removedSubject Subject to remove
	 */
	void removeSubject(Subject removedSubject) {
		subjectArray.remove(removedSubject);
	}

	/**
	 * Method to return the array of subjects.
	 * @return subjectArray Array of subjects
	 */
	ArrayList<Subject> getSubjects() {
		return subjectArray;
	}

	/**
	 * Method to add a course, confirm that the course has been added and to add it to the array of courses that teach the course's subject.
	 * @param addedCourse Course to add
	 */
	void addCourse(Course addedCourse) {
		courseArray.add(addedCourse);
		addedCourse.subject.coursesWithThisSubject.add(addedCourse);
		addedCourse.courseIsAdded = true;
	}

	/**
	 * Method to remove a course.
	 * @param removedCourse Course to remove
	 */
	void removeCourse(Course removedCourse) {
		courseArray.remove(removedCourse);
	}

	/**
	 * Method that returns the array of questions.
	 * @return courseArray Array of courses
	 */
	ArrayList<Course> getCourses() {
		return courseArray;
	}

	/**
	 * Method to create a string containing the information of all instructors.
	 * @return instructorInfo The information of all instructors
	 */
	public String getAllInstructors() {
		String instructorInfo = "";
		for(Instructor instructor: getInstructors()) {
			instructorInfo += instructor.toString();
			instructorInfo += "\n\r" + " ";
		}
		return instructorInfo;
	}

	/**
	 * Method that creates a string which contains information about
	 * all students in the school.
	 * @return studentInfo The information of all students
	 */
	public String getAllStudents() {
		String studentInfo = "";
		for(Student student: getStudents()) {
			studentInfo += student.toString();
			studentInfo += "\n\r" + " ";
		}
		return studentInfo;
	}

	/**
	 * Method that creates a string which contains information about all subjects
	 * teached in the school.
	 * @return subjectInfo Information about all subjects
	 */
	public String getAllSubjects() {
		String subjectInfo = "";
		for(Subject subject: getSubjects()) {
			subjectInfo += subject.toString();
			subjectInfo += "\n\r" + " ";
		}
		return subjectInfo;
	}

	/**
	 * Method that creates a string which contains information about all
	 * current courses in the school.
	 * @return courseInfo Information about all current courses
	 */
	public String getAllCourses() {
		String courseInfo = "";
		for(Course course: getCourses()) {
			courseInfo += course.toString();
			courseInfo += "\n\r" + " ";
		}
		return courseInfo;
	}

	/**
	 * Method that displays in an ordered way information about all students, instructors, courses and subjects,
	 * using the 4 getAll methods from before. Each section is separated by a discontinuous line.
	 */
	public String toString() {
		return "School: " + name + "\n\r----------------------------------------------------------------------------"
				+ "--------------------------------------------------------------------------------------------\n\r" +
				"Instructors:\n\r" + getAllInstructors() + "\n\r-----------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------\n\r" +
				"Students:\n\r " + getAllStudents() + "\n\r---------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------\n\r" +
				"Subjects:\n\r " + getAllSubjects() + "\n\r---------------------------------------------------------------------------------------"
				+ "-----------------------------------------------------------------------------------------------------------------------\n\r" + 
				"Courses:\n\r " + getAllCourses() + "\n\r--------------------------------------------------------------------------------------"
				+ "---------------------------------------------------------------------------------------------------------------------------------";
	}

	/**
	 * Method that simulates a day at school. Here students and instructors come to and leave the school, each
	 * with a determined probability, courses are allocated to students/instructors, courses are removed and tests are given.
	 * It is the main function of the code.
	 */
	void aDayAtSchool() {

		try {
			
			//Here are some counters for probabilities of new instructors,
			//students/instructors that leave and other integers used in the random person generators.
			int studentsThatLeft = 0;
			int instructorsThatLeft = 0;
			int nameIndex;
			int randomIndex;
			int number;
			int studentAge;
			int chanceOfNewInstructor;
			int instructorAge;
			int numberOfInstructors = 0;

			//This pauses the thread for some time inputed by the user when running the simulation.
			Thread.sleep(sleepTime);

			//number represents the number of new students that day from 0 to 2.
			number = newPerson.nextInt(3);

			//For each new student a random gender (M/F), age (18-24) and name is given.
			for(int i = 1; i <= number; i++) {	
				
				//Gender comes before name as depending of the gender, the name will be randomly chosen form
				//a pool of names or the other (check maleNames and femaleNames).
				randomIndex = gender.nextInt(2);
				nameIndex = newPerson.nextInt(9);
				studentAge = 18 + personAge.nextInt(7);

				//gender = 0, then the student is a male.
				if(randomIndex == 0) {
					Student student = new Student(maleNames.get(nameIndex), 'M', studentAge);
					studentArray.add(student);
				}

				//gender = 1, then the students is a female.
				else if(randomIndex == 1) {
					Student student = new Student(femaleNames.get(nameIndex), 'F', studentAge);
					studentArray.add(student);
				}	
			}	

			//Depending of the amount of new students that day, a different message will be displayed as a report.
			if(number == 0)
				System.out.println("No students have joined the school");
			if(number == 1)
				System.out.println(number + " student has joined the school");
			if(number == 2)
				System.out.println(number + " students have joined the school");

			//This tells you how many students are currently in the school.
			System.out.println("There are currently " + studentArray.size() + " students in the school");
			System.out.println();

			//The thread sleeps again so that the user can keep the pace with the simulation, because there is a lot of printing involved.
			Thread.sleep(sleepTime);
			
			//RNG used to determine if a teacher will join. if the chance is between 1 and 20, someone will join.
			chanceOfNewInstructor = 1 + newTeacher.nextInt(100);

			if(chanceOfNewInstructor <= 20) {
				System.out.println("One teacher has joined the school");

				//RNG used to generate a new Teacher
				randomIndex = gender.nextInt(2);
				nameIndex = newPerson.nextInt(9);
				instructorAge = 25 + personAge.nextInt(35);

				//New male teacher
				if(randomIndex == 0) {
					Teacher teacher = new Teacher(maleNames.get(nameIndex), 'M', instructorAge);
					instructorArray.add(teacher);
				}

				//New female teacher
				else if(randomIndex == 1) {
					Teacher teacher = new Teacher(femaleNames.get(nameIndex), 'F', instructorAge);
					instructorArray.add(teacher);
				}
			}

			//This is in case no one joins
			else {
				System.out.println("No teacher has joined the school");
			}

			Thread.sleep(sleepTime);

			//Chance of a new demonstrator (10% chance). The variable takes a number between 1 and 100
			chanceOfNewInstructor = 1 + newDemonstrator.nextInt(100);

			//If that number is less than 11, a new demonstrator will come
			if(chanceOfNewInstructor <= 10) {
				System.out.println("One demonstrator has joined the school");

				//Variables for a new Demonstrator
				randomIndex = gender.nextInt(2);
				nameIndex = newPerson.nextInt(9);
				instructorAge = 25 + personAge.nextInt(35);

				//New male demonstrator
				if(randomIndex == 0) {
					Demonstrator demonstrator = new Demonstrator(maleNames.get(nameIndex), 'M', instructorAge);
					instructorArray.add(demonstrator);
				}

				//new female demonstrator
				else if(randomIndex == 1) {
					Demonstrator demonstrator = new Demonstrator(femaleNames.get(nameIndex), 'F', instructorAge);	
					instructorArray.add(demonstrator);
				}
			}

			//This is in case no one joins
			else {
				System.out.println("No demonstrator has joined the school");
			}

			Thread.sleep(sleepTime);

			//Chance for new OO trainer (5%)
			chanceOfNewInstructor = 1 + newOOTrainer.nextInt(100);

			if(chanceOfNewInstructor <= 5) {
				System.out.println("One OO trainer has joined the school");

				randomIndex = gender.nextInt(2);
				nameIndex = newPerson.nextInt(9);
				instructorAge = 25 + personAge.nextInt(35);

				//New male trainer
				if(randomIndex == 0) {
					OOTrainer ootrainer = new OOTrainer(maleNames.get(nameIndex), 'M', instructorAge);
					instructorArray.add(ootrainer);
				}

				//New female trainer
				else if(randomIndex == 1) {
					OOTrainer ootrainer = new OOTrainer(femaleNames.get(nameIndex), 'F', instructorAge);	
					instructorArray.add(ootrainer);
				}
			}

			//This is in case no one joins
			else {
				System.out.println("No OO trainer has joined the school");
			}

			Thread.sleep(sleepTime);

			//Chance for a new GUI trainer to come in (5%)
			chanceOfNewInstructor = 1 + newTeacher.nextInt(100);

			if(chanceOfNewInstructor <= 5) {
				System.out.println("One GUI trainer has joined the school");

				randomIndex = gender.nextInt(2);
				nameIndex = newPerson.nextInt(9);
				instructorAge = 25 + personAge.nextInt(35);

				//New male trainer
				if(randomIndex == 0) {
					GUITrainer guitrainer = new GUITrainer(maleNames.get(nameIndex), 'M', instructorAge);
					instructorArray.add(guitrainer);
				}

				//New female trainer
				else if(randomIndex == 1) {
					GUITrainer guitrainer = new GUITrainer(femaleNames.get(nameIndex), 'F', instructorAge);	
					instructorArray.add(guitrainer);
				}
			}

			//This is in case no one joins
			else {
				System.out.println("No GUI trainer has joined the school");
			}

			System.out.println();

			numberOfInstructors = 0;

			//This loops through the array of instructors and updates the counter in case it finds a Teacher, an OOTrainer or a GUI trainer.
			//The trainers decrease the counter as the instanceof Teacher looks after Teacher objects *and* trainer objects, as the OOTrainer and
			//GUITrainer are children of Teacher, and I don't want those to be added here.
			for(Instructor instructor: instructorArray) {
				if(instructor instanceof Teacher)
					numberOfInstructors++;
				if(instructor instanceof OOTrainer)
					numberOfInstructors--;
				if(instructor instanceof GUITrainer)
					numberOfInstructors--;
			}
			System.out.println(numberOfInstructors + " teachers are in the school");

			numberOfInstructors = 0;

			//Here the demonstrators are counted
			for(Instructor instructor: instructorArray)
				if(instructor instanceof Demonstrator)
					numberOfInstructors++;
			System.out.println(numberOfInstructors + " demonstrators are in the school");

			numberOfInstructors = 0;

			//Here the OO trainers are counted
			for(Instructor instructor: instructorArray)
				if(instructor instanceof OOTrainer)
					numberOfInstructors++;
			System.out.println(numberOfInstructors + " OO trainers are in the school");

			numberOfInstructors = 0;

			//Here the GUI trainers are counted
			for(Instructor instructor: instructorArray)
				if(instructor instanceof GUITrainer)
					numberOfInstructors++;
			System.out.println(numberOfInstructors + " GUI trainers are in the school");

			System.out.println();

			Thread.sleep(sleepTime);

			/**
			 * Here a course is created for each subject without courses.
			 * It loops through the subjects and check whether they have a course or not.
			 * If not, a course is created 
			 */
			for(Subject subject: subjectArray) {
				if(subject.coursesWithThisSubject.size() == 0) {
					Subject subjectWithoutCourses = subject;
					Course course = new Course(subjectWithoutCourses, 2);
					addCourse(course);
					System.out.println("A course for " + course.subject.description + " has been added");
				}
			}

			Thread.sleep(sleepTime);

			System.out.println();

			/**
			 * Here the vacant instructors are given a course to teach in (if they are any vacant courses and
			 * vacant instructors, and some instructor can teach that course).
			 */
			for(Course vacantCourse: courseArray) {
				if(vacantCourse.hasInstructor() == false) {
					for(Instructor vacantInstructor: instructorArray) {
						if(vacantInstructor.canTeach(vacantCourse.subject) && (vacantInstructor.hasCourse() == false)) {
							vacantCourse.courseInstructor = vacantInstructor;
							vacantInstructor.assignedCourse = vacantCourse;
							break;
						}
					}
				}
			}

			Thread.sleep(sleepTime);

			/**
			 * Here each student is given a course to take part in (if they have no assigned course and
			 * there are vacant places in a course from which they don't have the certificate)
			 */
			for(Student student: studentArray) {
				if(student.hasCourse == false)
					for(Course course: courseArray) {
						if(course.enrolledStudents.size() < 3) {
							if(student.hasCertificate(course.subject) == false)
								course.enrolStudent(student);	
						}
					}
			}

			Thread.sleep(sleepTime);

			//Here a course is added to an array for courses to remove if it's finished or cancelled.
			//Removing it here throws an ConcurrentModificationException (You remove something from 
			//an array while something is still looping through the array).
			for(Course courseToRemove: courseArray) {
				courseToRemove.aDayPasses();
				if((courseToRemove.cancelledCourse == true) || (courseToRemove.daysToRun == 0)) {
					coursesToRemove.add(courseToRemove);
				}
			}

			Thread.sleep(sleepTime);

			//Here the courses to be removed are actually removed.
			System.out.println(coursesToRemove.size() + " courses will be removed");
			courseArray.removeAll(coursesToRemove);
			coursesToRemove.clear();
			System.out.println();

			//Here an instructor has a 20% chance of leaving the school at the end of the day if it is vacant.
			for(Instructor instructorToLeave: instructorArray) {
				if(instructorToLeave.hasCourse() == false) {
					Random leavingChance = new Random();
					number = 1 + leavingChance.nextInt(100);
					if(number <= 20) {
						peopleToLeave.add(instructorToLeave);
						instructorsThatLeft++;
					}
				}
			}

			Thread.sleep(sleepTime);

			//Here the student has a 5% chance of leaving the school each day.
			for(Student studentToLeave: studentArray) {
				if(studentToLeave.hasCourse == false) {
					Random leavingChance = new Random();
					number = 1 + leavingChance.nextInt(100);
					if(number <= 5) {
						peopleToLeave.add(studentToLeave);
						studentsThatLeft++;
					}
				}

				Thread.sleep(sleepTime);

				//Here the student automatically leaves if it has all the certificates for each subject.
				if(studentToLeave.certificates.size() == subjectArray.size()) {
					peopleToLeave.add(studentToLeave);
					studentsThatLeft++;
				}
			}

			Thread.sleep(sleepTime);

			//This prints how may students/instructors left today
			System.out.println(studentsThatLeft + " student/s will leave the school");
			System.out.println(instructorsThatLeft + " instructor/s will leave the school");
			System.out.println();
			studentArray.removeAll(peopleToLeave);
			instructorArray.removeAll(peopleToLeave);

			System.out.println("END OF DAY");
			System.out.println("---------------------------------------------------------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------");

		} catch(Exception e) {

		}

	}
}
