
/**
 * Base plate for all students and instructors in the school.
 * Each person has a name, an age and a a gender
 * @author modrix
 */
class Person {

	String name;
	char gender;
	int age;

	/**
	 * @param name Name of the person
	 * @param gender Gender of the person
	 * @param age Age of the person
	 */
	protected Person(String name, char gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * @return name The name of the person
	 */
	String getName() {
		return name;
	}

	/**
	 * @return gender The gender of the person
	 */
	char getGender( ) {
		return gender;
	}

	/**
	 * @return age The age of the person
	 */
	int getAge() {
		return age;
	}

	/**
	 * Sets the age of the person
	 * @param age The new age of the person
	 */
	void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns some info about the person
	 */
	public String toString() {
		return "Name: " + name + ", " + "Age: " + age + ", " + "Gender: " + gender;
	}
}
