package ba.bitcamp.homework25;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Napraviti jedan normalni server koji prima od klijenta dva String-a, jedan za
 * link, a drugi za ime linka. Server mora provjeriti da li je dati link validan
 * i postojci. Ukoliko zadovoljava oba uslova onda zapisati dati link i dato
 * ime u File (koji ce HTTP server kasnije citati).
 * 
 * @author amra.sabic
 *
 */
public class Client {

	public static void main(String[] args) {

		try {

			Socket server = new Socket("localhost", 1989);

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					server.getOutputStream()));
			Scanner in = new Scanner(System.in);

			// writer sends 2 strings to server
			System.out
					.println("Insert website in format: https://www.example.com");
			String link = in.nextLine();
			writer.write(link);
			writer.newLine();

			System.out.println("Insert website name: example");
			String web = in.nextLine();
			writer.write(web);
			writer.newLine();

			writer.flush();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}