package encapsulation;

import java.util.ArrayList;

class Patient {
	private String patientId, patientName, dateOfBirth;

//                                the constructor is to assign the values in the 'main' class:
	public Patient(String patientId, String patientName, String dateOfBirth) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
	}

//               the 'getters' below to call the methods with the assign values in the 'main' class
	public String getPatientId() {
		return patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

//                              the method is to print out the info about the patient:
	public void displayPatientInfo() {
		System.out.println(
				"\nPatient ID: " + patientId + "\nPatient Name: " + patientName + "\nDate of Birth: " + dateOfBirth);
	}
}

class Doctor {
	private String doctorId, doctorName, specialization;

//                                 the constructor is to assign the values in the 'main' class:
	public Doctor(String doctorId, String doctorName, String specialization) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
	}

//               the 'getters' below to call the methods with the assign values in the 'main' class
	public String getDoctorId() {
		;
		return doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

//                            the method is to print out the info about the doctor:
	public void displayDoctorInfo() {
		System.out.println(
				"\nDoctor ID: " + doctorId + "\nDoctor Name: " + doctorName + "\nSpecialization: " + specialization);
	}
}

class Appointment {
	private Patient patient;
	private Doctor doctor;
	private String date, time;

//                                  the constructor is to assign the values in the 'main' class:
	public Appointment(Patient patient, Doctor doctor, String date, String time) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
	}

//              the 'getters' below to call the methods with the assign values in the 'main' class
	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

//                                      the method is to print out the info about appointment:
	public void displayAppointmentDetails() {
		System.out.println("\nAppointment Date: " + date + "\nAppointment Time: " + time + "\nPatient ID: "
				+ patient.getPatientId() + "\nDoctor ID: " + doctor.getDoctorId());
	}
}

class Hospital {
	private ArrayList<Patient> patients;
	private ArrayList<Doctor> doctors;
	private ArrayList<Appointment> appointments;

	public Hospital() {
		patients = new ArrayList<>();
		doctors = new ArrayList<>();
		appointments = new ArrayList<>();
	}

//                                       METHOD TO ADD THE PATIENTS INFO:
	public boolean addPatient(String patientId, String patientName, String dateOfBirth) {
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				return false; // if patient with the same ID already in the 'ArrayList' 'patients';
			}
		}
		patients.add(new Patient(patientId, patientName, dateOfBirth));
		return true;// and add the new patient's info to the ArrayList 'patients' if not yet in the
					// list;
	}

//                                        METHOD TO ADD THE DOCTORS INFO:
	public boolean addDoctor(String doctorId, String doctorName, String specialization) {
		for (Doctor doctor : doctors) {
			if (doctor.getDoctorId().equals(doctorId)) {
				return false; // if doctor with the same ID is already in the 'ArrayList' 'doctors';
			}
		}
		doctors.add(new Doctor(doctorId, doctorName, specialization));
		return true;// and add the new doctor's info to the ArrayList 'doctors' if not yet in the
					// list;
	}

//                                       METHOD TO SCHEDULE AN APPOINTMENT:
	public boolean scheduleAppointment(String patientId, String doctorId, String date, String time) {
		Patient patient = findPatient(patientId);
		Doctor doctor = findDoctor(doctorId);
		if (patient != null && doctor != null) { // if
			appointments.add(new Appointment(patient, doctor, date, time));
			return true;
		}
		return false;
	}

	public void displayPatientInfo() { // the general mehtod 'displayPatientInfo' called in the 'main' class,
		System.out.println("Patients:");
		for (Patient patient : patients) {
			patient.displayPatientInfo();
			System.out.println();
		}
	}

	public void displayDoctorInfo() {
		System.out.println("Doctors:");
		for (Doctor doctor : doctors) {
			doctor.displayDoctorInfo();
			System.out.println();
		}
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	private Patient findPatient(String patientId) {
		for (Patient patient : patients) {
			if (patient.getPatientId().equals(patientId)) {
				return patient;
			}
		}
		return null; // patient is not found in the 'ArrayList';
	}

	private Doctor findDoctor(String doctorId) {
		for (Doctor doctor : doctors) {
			if (doctor.getDoctorId().equals(doctorId)) {
				return doctor;
			}
		}
		return null; // doctor is not found in the 'ArrayList';
	}
}

public class HospitalManagementSystem {
	public static void main(String[] args) {
		Hospital hospital = new Hospital(); // linking to the 'Hospital' class;

		hospital.addPatient("P532", "Alice", "2000-01-10"); // assigning the values to the methods;
		hospital.addPatient("P122", "Bob", "1995-05-20");

		hospital.addDoctor("D321", "Dr. Holmes", "Cardiology");
		hospital.addDoctor("D322", "Dr. Johnson", "Pediatrics");

		hospital.displayPatientInfo(); // display patient and doctor information;
		hospital.displayDoctorInfo();

		// Schedule appointments
		hospital.scheduleAppointment("P532", "D321", "2023-09-01", "10:00 AM");
		hospital.scheduleAppointment("P122", "D322", "2023-09-02", "2:00 PM");

		// Display appointment details
		System.out.println("Appointments:");
		for (Appointment appointment : hospital.getAppointments()) {
			appointment.displayAppointmentDetails();
			System.out.println();
		}
	}
}
