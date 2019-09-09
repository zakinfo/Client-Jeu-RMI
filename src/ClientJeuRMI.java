import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jeu.IJeuRemote;

public class ClientJeuRMI {

	public static void main(String[] args) {
		try {
			Context ctx = new InitialContext();
			IJeuRemote stub = (IJeuRemote) ctx.lookup("JH");
			Scanner clavier = new Scanner(System.in);
			while (true) {
				System.out.print("Devenez un nombre : ");
				int nb = clavier.nextInt();
				if (nb==-1) break;
				String rep = stub.Jouer(nb);
				System.out.println(rep);
				if(rep.contains("Bravo")) {
					String rep1 = stub.Jouer(nb);
					System.out.println(rep1);
					break;
					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
