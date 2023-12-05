import java.util.*;

class Patient {

	private static int nextPatientId = 1;

	private int patientId;
	private String name;
	private int age;
	private String gender;
	private String contactNumber;

	// Constructor
	public Patient(String name, int age, String gender, String contactNumber) {
		this.patientId = nextPatientId++; // increments the created IDs of the registered patients
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
	}

	public int getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}
}

class Doctor {

    private static int nextDoctorId = 1;

    private int doctorId;
    private String name;
    private List<String> availableTimeSlots;

    // Create the constructor
    public Doctor(String name, List<String> availableTimeSlots) {
        this.doctorId = nextDoctorId++; // increments the created IDs of the registered doctors
        this.name = name;
        this.availableTimeSlots = new ArrayList<>(availableTimeSlots);
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public List<String> getAvailableTimeSlots() {
        return new ArrayList<>(availableTimeSlots);
    }
}


class Appointment {

	private Patient patient;
	private Doctor doctor;
	private String timeSlot;

	public Appointment(Patient patient, Doctor doctor, String timeSlot) {
		this.patient = patient;
		this.doctor = doctor;
		this.timeSlot = timeSlot;
	}

	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getTimeSlot() {
		return timeSlot;
	}
}

class Hospital {

	// Create the List of patients
	private List<Patient> patients;
	// Create the List of doctors
	private List<Doctor> doctors;
	// Create the List of appointments
	private List<Appointment> appointments;

	public Hospital() { // Constructor
		this.patients = new ArrayList<>();
		this.doctors = new ArrayList<>(); // Initialize the doctors list
		this.appointments = new ArrayList<>();
	}

	// Method 'registerPatient' creates an object of the Patient and 'add's the info
	// to the List 'parients'
	public void registerPatient(String name, int age, String gender, String contactNumber) {
		Patient patient = new Patient(name, age, gender, contactNumber);
		patients.add(patient);
		System.out.println("Patient registered successfully. Patient ID: " + patient.getPatientId());
	}

	public void displayPatients() {
		for (Patient patient : patients) {
			System.out.println("Patient ID: " + patient.getPatientId() + ", Name: " + patient.getName() + ", Age: "
					+ patient.getAge() + ", Gender: " + patient.getGender() + ", Contact: "
					+ patient.getContactNumber());
		}
	}

	public void displayDoctors() {
		for (Doctor doctor : doctors) {
			System.out.println("Doctor ID: " + doctor.getDoctorId() + ", Name: " + doctor.getName()
					+ ", Available Time Slots: " + doctor.getAvailableTimeSlots());
		}
	}

	public void addDoctor(Doctor doctor) { // Adds a doctor to the List
		doctors.add(doctor);
	}

	public void scheduleAppointment(int patientId, int doctorId) {
		Scanner scanner = new Scanner(System.in);

		Patient patient = findPatientById(patientId);
		Doctor doctor = findDoctorById(doctorId);

		if (patient != null && doctor != null) {
			List<String> availableTimeSlots = new ArrayList<>(doctor.getAvailableTimeSlots());

			if (!availableTimeSlots.isEmpty()) {
				System.out.println("Available Time Slots for " + doctor.getName() + ": " + availableTimeSlots);

				// Display time slots as options
				for (int i = 0; i < availableTimeSlots.size(); i++) {
					System.out.println((i + 1) + ". " + availableTimeSlots.get(i));
				}

				System.out.print("Enter the number of your preferred time slot: ");
				int selectedOption = scanner.nextInt();

				if (selectedOption >= 1 && selectedOption <= availableTimeSlots.size()) {
					String selectedTimeSlot = availableTimeSlots.get(selectedOption - 1);

					// Add the appointment with the selected time slot
					appointments.add(new Appointment(patient, doctor, selectedTimeSlot));

					// Remove the selected time slot from the original list
					doctor.getAvailableTimeSlots().remove(selectedTimeSlot);

					System.out.println("Appointment scheduled successfully.");
				} else {
					System.out.println("Invalid option. Please choose from the available time slots.");
				}
			} else {
				System.out.println("No available time slots for Dr. " + doctor.getName() + " at the moment.");
			}
		} else {
			System.out.println("Invalid patient or doctor ID.");
		}
	}

	public void displayAppointments() {
		if (appointments.isEmpty()) {
			System.out.println("No appointments scheduled yet.");
		} else {
			System.out.println("Available Appointments:");
			for (Appointment appointment : appointments) {
				System.out.println("Patient: " + appointment.getPatient().getName() + ", Doctor: "
						+ appointment.getDoctor().getName() + ", Time Slot: " + appointment.getTimeSlot());
			}
		}
	}

	private Patient findPatientById(int patientId) {
		for (Patient patient : patients) {
			if (patient.getPatientId() == patientId) {
				return patient;
			}
		}
		return null;
	}

	private Doctor findDoctorById(int doctorId) {
		for (Doctor doctor : doctors) {
			if (doctor.getDoctorId() == doctorId) {
				return doctor;
			}
		}
		return null;
	}
}

public class HospitalManagementSystem {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Hospital hospital = new Hospital();

		// Creating some doctors with names and available time slots
		Doctor doctor1 = new Doctor("Dr. Smith", Arrays.asList("10:00 AM", "2:00 PM", "4:00 PM"));
		Doctor doctor2 = new Doctor("Dr. Johnson", Arrays.asList("9:00 AM", "1:00 PM", "3:00 PM"));
		hospital.addDoctor(doctor1);
		hospital.addDoctor(doctor2);

		int choice;

		do {
			System.out.println("\nHospital Management System");
			System.out.println("1. Register Patient");
			System.out.println("2. Display Patients");
			System.out.println("3. Display Doctors");
			System.out.println("4. Schedule Appointment");
			System.out.println("5. Display Appointments");
			System.out.println("6. Exit");

			try {
				System.out.print("Enter your choice: ");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.print("\nEnter patient name: ");
					String name = scanner.next();
					System.out.print("Enter patient age: ");
					int age = scanner.nextInt();
					System.out.print("Enter patient gender: ");
					String gender = scanner.next();
					System.out.print("Enter patient contact number: ");
					String contactNumber = scanner.next();
					hospital.registerPatient(name, age, gender, contactNumber);
					break;
				case 2:
					hospital.displayPatients();
					break;
				case 3:
					hospital.displayDoctors();
					break;
				case 4:
					System.out.print("\nEnter patient ID: ");
					int patientId = scanner.nextInt();
					System.out.print("Enter doctor ID: ");
					int doctorId = scanner.nextInt();
					hospital.scheduleAppointment(patientId, doctorId);
					break;
				case 5:
					hospital.displayAppointments();
					break;
				case 6:
					System.out.println("Exiting the system. Thank you!");
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
				choice = 0; // Reset the choice to force re-entering the loop
			}

		} while (choice != 6);

		scanner.close();
	}
}
