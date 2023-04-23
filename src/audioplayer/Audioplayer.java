package audioplayer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

//This is the driver class for the music player.
public class Audioplayer {
	// Static block to display a welcome message
	static {
		System.out.println("************************************\n");
		System.out.println("WELCOME TO ONLINE MUSIC PALYER\n");
		System.out.println("************************************");
	}

	/*
	 * The main method that initializes the music player and its components.
	 * 
	 * @throws UnsupportedAudioFileException If the audio file format is not
	 * supported.
	 * 
	 * @throws IOException If an I/O error occurs.
	 * 
	 * @throws LineUnavailableException If a line to the audio output is
	 * unavailable.
	 */
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		DetailsPage details = new DetailsPage(); // Create a new DetailsPage object.
		details.DetailsPage();// Call the DetailsPage method of the DetailsPage object.
		MusicPlayr mu = new MusicPlayr();// Create a new Music object.
		mu.chooseMusic();// Call the Music method of the Music object.

	}
}

//This class represents the personal details of the user and handles user signup and login logic.
class DetailsPage {
	public void DetailsPage() {
		// Signup Page Logic
		System.out.println("-----------------------------------------------------\n");
		System.out.println("--------->>Signup Page\n");
		System.out.println("-----------------------------------------------------");
		String Name;
		String Email;
		String Contact;
		String Userid;
		String password;
		
		System.out.println("-----------------------------------------------------\n");
		System.out.println("--------->>Enter your details to create your account\n ");
		System.out.println("-----------------------------------------------------");
		
		Scanner ref = new Scanner(System.in);
		System.out.print(" 1.Full Name:- ");
		Name = ref.nextLine();
		// Validate Email end with @gmail.com
		System.out.print(" 2.Email Address (must end with @gmail.com):-");
		Email = ref.next();
		while (!Email.endsWith("@gmail.com")) {
			System.out.print("# Invalid email address. Please enter a valid email address ending with @gmail.com:-");
			Email = ref.next();
		}
		// Validate Contact it should be 10-digits.
		System.out.print(" 3.Contact:- ");
		Contact = ref.next();
		while (!Contact.matches("\\d{10}")) {
			System.out.print("# Invalid phone number. Please enter a 10-digit phone number:-");
			Contact = ref.next();
		}
		System.out.print(" 4.User I'd:- ");
		Userid = ref.next();
		System.out.print(" 5.Create a Password:- ");
		password = ref.next();
		System.out.println("  ");
		
		// Validate Password again
		System.out.print(" 6.Confirm Password again:- ");
		String confirmpassword = ref.next();
		while (!password.equals(confirmpassword)) {
			System.out.print("# Invalid Password . Please enter a valid Password :-");
			confirmpassword = ref.next();
		}
		
		//This shows all the details as you mentioned above if Password is right.
		if (password.equals(confirmpassword)) {
			System.out.println("-----------------------------------------------------\n");
			System.out.println("--------->>Details entered by you\n");
			System.out.println("-----------------------------------------------------");
			System.out.println(" * Name:- " + Name);
			System.out.println(" * Email:- " + Email);
			System.out.println(" * Contact:- " + Contact);
			System.out.println(" * Userid:-" + Userid);
			System.out.println(" * Password:-" + password);
			System.out.println("\n");
			
			//Submit button and Cancel button logic
			System.out.println("----->>press 1 to submit details");
			System.out.println("----->>press 2 to cancel");
			int submit = ref.nextInt();
			if (submit == 1) {
				System.out.println(" ");
				System.out.println("--------->>You can now Login\n");

			} else {
				System.out.println("We're sorry to see you go, but you are always welcome back");
				System.exit(0);
			}
		}

		// Login Page Logic
		Scanner ref1 = new Scanner(System.in);
		System.out.println("-----------------------------------------------------\n");
		System.out.println("--------->>Login Page\n");
		System.out.println("-----------------------------------------------------");
	
		//userid check while login
		System.out.print("Enter Userid:-");
		String id = ref1.nextLine();
		while (!Userid.equals(id)) {
			System.out.print("# Invalid Userid . Please enter a valid Userid :-");
			id = ref1.nextLine();
		}
		
		//Password check while login
		System.out.print("Enter Password:-");
		String ps = ref1.nextLine();
		while (!confirmpassword.equals(ps)) {
			System.out.print("# Invalid Password . Please enter a valid Password :-");
			ps = ref1.nextLine();
		}
		//login button logic
		System.out.println();
		System.out.println("----->>press 1 to Login");
		int login = ref.nextInt();
		if (login == 1) {
			if (confirmpassword.equals(ps)) {
				System.out.println("-----------------------------------------------------\n");
				System.out.println("--------->>WELCOME TO FEELMUSIC\n");
				System.out.println("-----------------------------------------------------");
			}
		}	
	}
}

//Super class for all Sub Music class
class MusicPlayr {
//Method to choice the Music Language
	public void chooseMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		int a = 0;
		System.out.println("-----------------------------------------------------\n");
		System.out.println("--------->>Types Of Music\n");
		System.out.println("-----------------------------------------------------");
		System.out.println("   ");
		System.out.println("Press 1. for - Marathi songs");
		System.out.println("Press 2. for - Hindi songs");
		System.out.println("Press 3. for - English songs");
		System.out.println("Press 4. for - Exit");
		System.out.println("   ");
		System.out.println("-----------------------------------------------------\n");
		System.out.println("--------->>Choose Music type\n");
		System.out.println("-----------------------------------------------------");
		System.out.println("Enter The Number:- ");
		System.out.println("");

		Scanner ref2 = new Scanner(System.in);
		MarathiSongs mr = new MarathiSongs();
		HindiSongs hi = new HindiSongs();
		Englishsongs en = new Englishsongs();
		do {
			a = ref2.nextInt();
			switch (a) {

			case 1:
				System.out.println("You have chosen Marathi songs");
				mr.playMarathiSong();
				break;

			case 2:
				System.out.println("You have chosen Hindi songs");
				hi.playHindiSong();
				break;

			case 3:
				System.out.println("You have chosen English songs");
				en.playEnglishSong();
				break;
			case 4:
				System.out.println("Thank you for coming to enjoy the music. We hope to see you again soon!");
				System.exit(0);
				break;

			default:
				System.out.println();
				System.out.println("Choose valid Number");
				break;
			}
		} while (a != 3);
	}

	// This method plays the audio file specified by the fileName parameter and
	// allows the user to control playback.
	// It throws three exceptions: UnsupportedAudioFileException, IOException, and
	// LineUnavailableException.
	public void playMusic(String fileName) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Scanner scanner = new Scanner(System.in);
		// Create a new File object using the fileName parameter and get the audio
		// stream for that file.
		File file = new File(fileName);
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);

		// Loop until the user enters "Q" to quit.
		String response = "";
		while (!response.equals("Q")) {
			// Prompt the user to enter a command to control playback.
			System.out.println("P = Play, R = Reset, FF = Fast Forward 5s, M = Choose Music again, S = Stop");
			System.out.print("Enter your choice: ");

			// Get the user's response and convert it to uppercase.
			response = scanner.next().toUpperCase();
			// Use a switch statement to perform the appropriate action based on the user's
			// response.
			switch (response) {
			case ("P"):
				clip.start();
				break;
			case ("S"):
				clip.stop();
				break;
			case ("R"):
				clip.setMicrosecondPosition(0);
				break;
			case ("FF"):
				clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 20000000);
				break;
			case ("M"):
				clip.close();
				chooseMusic();
				break;
			default:
				System.out.println("Not a valid response");
			}
		}
		System.out.println("Song END!");
	}
}

// This is a subclass of Music that plays a specific Marathi song.
class MarathiSongs extends MusicPlayr {
	// This method plays the Marathi song specified by the file name
	// "Man-Sudhha-Tuza.wav".
	public void playMarathiSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		playMusic("Man-Sudhha-Tuza.wav");
	}
}

//This is a subclass of Music that plays a specific Hindi song.
class HindiSongs extends MusicPlayr {
	// This method plays the Hindi song specified by the file name "02. Zindagi Ki
	// Yehi Reet Hai.wav".
	public void playHindiSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		playMusic("Zindagi-Ki-Yehi-Reet-Hai");
	}
}

//This is a subclass of Music that plays a specific English song.
class Englishsongs extends MusicPlayr {
	// This method plays the English song specified by the file name "just the way u
	// r.wav".
	public void playEnglishSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		playMusic("just-the-way-u-r.wav");
	}
}

