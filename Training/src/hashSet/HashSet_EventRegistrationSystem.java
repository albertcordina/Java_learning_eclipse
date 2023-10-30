package hashSet;
import java.util.HashSet;
import java.util.Scanner;

class Participant {
    String name;
    public Participant(String name) {
        this.name = name;
    }
}
class EventRegistration {
    HashSet<Participant> participantsSet = new HashSet<>();
    public void registerParticipant(String name) {
        Participant participant = new Participant(name);
        participantsSet.add(participant);
    }
    public void displayParticipants() {
        System.out.println("Registered Participants:");
        for (Participant participant : participantsSet) {
            System.out.println(participant.name);
        }
    }
}
public class HashSet_EventRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventRegistration eventRegistration = new EventRegistration();
        System.out.println("Enter participant names (enter 'done' to finish):");
        while (true) {                                   //  the loop 'while' is until the user enters 'done';
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            eventRegistration.registerParticipant(name);
        }
        System.out.println("\nRegistered Participants:");
        eventRegistration.displayParticipants();
    }
}
