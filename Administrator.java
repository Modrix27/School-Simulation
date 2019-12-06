import java.util.Scanner;

/**
 * This is the class in which The simulation is ran and the configuration file is written.
 * @author modrix
 */
public class Administrator {

	/**
	 * A School object. Is private because no other class needs to access it, 
	 * so why leave the possibility of doing that?
	 */
	private School school;

	/**
	 * This method runs the simulation. First it displays what
	 * happens in a day at school (who joined, who left, who had exams, 
	 * who got certificates and how many students and instructors are there), 
	 * and the toString() method displays info about every subject, course, instructor and student,
	 * including names, age, gender, course duration, students taking part in a course etc.
	 * Does that just once.
	 */
	void run() {
		school.aDayAtSchool();
		System.out.println(school.toString());
	}

	/**
	 * Method that overloads the run() method. Now you can give a number as an 
	 * argument to simulate that number of days.
	 * @param simulatedDays The number of days the simulation lasts
	 */
	void run(int simulatedDays) {
		for(int day = 0; day < simulatedDays; day ++) {
			school.aDayAtSchool();
			System.out.println(school.toString());	
		}
	}

	/**
	 * Constructor of the Administrator. It takes a school
	 * to administered.
	 * @param school
	 */
	public Administrator(School school) {
		this.school = school;
	}

	/**
	 * Here the configuration file is read (it includes some subjects, students and personnel), 
	 * a school is created using the name from the file, a new Administrator is created that administers
	 * the School and the simulation is ran according to some user inputs.
	 */
	public static void main(String[] args) {

		//This reads the file
		Reader reader = new Reader();
		
		//This method is called to read each line
		reader.getLines();

		School school = new School(Reader.schoolName);

		Administrator schoolAdministrator = new Administrator(school);

		int daysToRun;
		
		//A scanner is needed for the user input
		Scanner f = new Scanner(System.in);

		//User schooses the days to simulate
		System.out.println("Enter the number of days to simulate the school");
		daysToRun = f.nextInt();
		System.out.println();

		//User chooses the waiting time for the instructions to be executed, so that he/she can see what's going on better, as
		//the run() method prints a lot of info each day
		System.out.println("Enter the sleep time (in ms, where 1000 ms = 1 second)");
		school.sleepTime = f.nextInt();
		System.out.println();

		schoolAdministrator.run(daysToRun);

		//The scanner is closed to avoid resource leaks
		f.close();
	}
}
