package chapter3;

public class Main2 {

	public static void main(String[] args) {
		Videoconference conference = new Videoconference(10);
		Thread threadConference = new Thread(conference);
		threadConference.start();
		
		for(int i=0;i<10;i++) {
			Participant participant = new Participant(conference, "Paticipant " + i);
			Thread t = new Thread(participant);
			t.start();
		}
	}

}
