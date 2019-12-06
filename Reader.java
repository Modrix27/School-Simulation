import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * The Reader class. Here the configuration file is read and the information
 * about the school is processed.
 * @author modrix
 */
public class Reader {

	/**
	 * The reader of the file.
	 */
	private BufferedReader reader = null;
	
	/**
	 * The current line of text.
	 */
	private String line;
	
	/**
	 * The name of the school, extracted from the first line of the configuration file.
	 */
	public static String schoolName;
	
	// Arrays containing the information about the students, instructors and subjects extracted from the file.
	ArrayList<Subject> subjects = new ArrayList<Subject>();
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Instructor> instructors = new ArrayList<Instructor>();


	/**
	 * The Reader constructor. Here a BufferedReader is made
	 * and each line is read. Also the file is checked to see whether it's ready
	 * to be read and each line is checked to ensure that the information is
	 * correct and complete. Otherwise, an error message is printed and the program is stopped. 
	 */
	Reader() {	

		/*
		 * Here the BufferedReader looks after the configuration file named "mySchool.txt".
		 * If it doesn't find it, a FileNotFoundException will be catched and a custom error message
		 * will be printed.
		 */
		try {	

			reader = new BufferedReader(new FileReader("mySchool.txt"));

		} catch (IOException e) {
			System.out.println("mySchool.txt not found!");
			System.exit(0);
		}

	}

	/**
	 * @return line The line of text to be processes, or null in case the reader can't find any text 
	 * (It finished reading the file).
	 */
	String getLine() {
		try {
			if((line = reader.readLine()) != null) {
				return line;
			}
		} catch (IOException e) {
			System.out.println("mySchool.txt not found!");
		}
		return null;
	}

	/**
	 * Checks if the file is ready to be read. True if it exists or false if there is nothing more
	 * to be read.
	 * @return Returns whether the file is ready to be read or not
	 */
	boolean fileIsReady() {
		try {
			if(reader.ready())
				return true;
			else if (reader == null) 
				return false;
		} catch (IOException e) {
			System.out.println("mySchool.txt not found!");
			System.exit(0);
		}
		return false;
	}

	/**
	 * This method gets every line from the file and splits it by the ":" symbol and the comma.
	 * Each part of the line is put into an array of strings. Then, depending on the first element of
	 * the array (the first word in the line), it switches between cases depending on what is initialised in the line
	 * (school, subject, student or teacher). Also each type of object has a different number of arguments, and they are checked to
	 * ensure that the information is complete and correct. If that is the case, a new Subject/Student/Instructor object is made 
	 * and added into their respective arrays inside the School object. If not, the program is stopped for wrong information.
	 */
	void getLines() {
		String line;
		while((line = getLine()) != null) {
			String[] parts = line.split(":|,");
			switch(parts[0]) {
			case "school":
				if(parts.length != 2) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					schoolName = parts[1];
				}

				break;
			case "subject":
				if(parts.length != 5) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					int i;
					//Parsing is needed to change the string into an integer
					Subject subject = new Subject(i = Integer.parseInt(parts[2]), i = Integer.parseInt(parts[3]), i = Integer.parseInt(parts[4]));
					parts[1] = subject.description;
					School.subjectArray.add(subject);		
				}

				break;
			case "student":
				if(parts.length != 4) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					int i;
					char gender;
					//The same thing here as above, but there is another string that has to be changed into a char (it's the gender)
					Student student = new Student(parts[1], gender = parts[2].charAt(0), i = Integer.parseInt(parts[3]));
					School.studentArray.add(student);
				}

				break;
			case "Teacher":
				if(parts.length != 4) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					int i;
					char gender;
					Teacher teacher = new Teacher(parts[1], gender = parts[2].charAt(0), i = Integer.parseInt(parts[3]));
					School.instructorArray.add(teacher);
				}

				break;
			case "Demonstrator":
				if(parts.length != 4) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					int i;
					char gender;
					Demonstrator demonstrator = new Demonstrator(parts[1], gender = parts[2].charAt(0), i = Integer.parseInt(parts[3]));
					School.instructorArray.add(demonstrator);
				}

				break;
			case "OOTrainer":
				if(parts.length != 4) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					int i;
					char gender;
					OOTrainer ootrainer = new OOTrainer(parts[1], gender = parts[2].charAt(0), i = Integer.parseInt(parts[3]));
					School.instructorArray.add(ootrainer);
				}

				break;
			case "GUITrainer":
				if(parts.length != 4) {
					System.out.println("Wrong information!");
					System.exit(0);
				}

				else {
					int i;
					char gender;
					GUITrainer guitrainer = new GUITrainer(parts[1], gender = parts[2].charAt(0), i = Integer.parseInt(parts[3]));
					School.instructorArray.add(guitrainer);
				}

				break;
			}
		}
	}
}
