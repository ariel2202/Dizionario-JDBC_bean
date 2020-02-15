package dizJDBC;
import java.sql.*;
import java.util.*;

//IMPORTA IL MIO BEAN CONTENENTE LA CLASSE PAROLA
import mioBEAN.parola;


public class mostraDati {
	
	//ISTANZIO UN OBJECT DI TIPO PAROLA
	parola miaParola = new parola();
	
	int dd;
	//METODO PER VISUALIZZARE, AGGIUNGERE O ELIMINARE PAROLE DAL DIZIONARIO
	public void risposta() {
		try
		{
			//CREO LA CONNESSIONE
			Connection connessione =DriverManager.getConnection("jdbc:mysql://localhost:3306/dizionario","root","");
			Statement mioStatement = connessione.createStatement();
			
			System.out.println("connessione avvenuta con successo");
			System.out.println("per cercare una parola nel dizionario premi 1");
			System.out.println("per inserire una nuova parola nel dizionario premi 0");
			System.out.println("per eliminare una parola del dizionario premi 2");
			
			Scanner sc = new Scanner(System.in);
			dd = sc.nextInt();
			
			
			//SEZIONE VISUALIZZAZIONE DATI
			if(dd == 1) {
				String p;
				System.out.println("insrisci la parola da ricercare nel dizionario:");
			//	p = sc.next();
				miaParola.setParola(sc.next());
				
				//SELEZIONO LA PAROLA DA RICERCARE
				String istruzione = "SELECT * FROM parola WHERE pChiave ='"+miaParola.getParola()+"'";
				ResultSet mioResultset = mioStatement.executeQuery(istruzione);
			
				//STAMPO I RISULTATI
				while(mioResultset.next()) {
					
					System.out.println("PAROLA :"+mioResultset.getString("pChiave"));
					System.out.println("SINONIMO :"+mioResultset.getString("sinonimo"));
					System.out.println("CONTRARIO :"+mioResultset.getString("contrario"));
				}
			}
			//SEZIONE AGGIUNTA NUOVI DATI
			else if(dd == 0) {
				
				
				System.out.println("inserisci la parola da aggiungere nel dizionario:");
				miaParola.setParola(sc.next());
				
				System.out.println("inserisci il suo sinonimo:");
				miaParola.setSinonimo(sc.next());
				
				System.out.println("inserisci il suo contrario:");
				miaParola.setContrario(sc.next());
				
				
				
				//SELEZIONO I CAMPI DOVE VERRANNO AGGIUNTI I NUOVI DATI
				//ESEGUO L'ISTRUZIONE
				String istruzioneSql ="INSERT INTO parola (pChiave,sinonimo,contrario) VALUES ('"+miaParola.getParola()+"','"+miaParola.getSinonimo()+"','"+miaParola.getContrario()+"')";
				mioStatement.executeUpdate(istruzioneSql);
				System.out.println("parola aggiunta correttamente!!");
			}
			//SEZIONE ELIMINA DATI
			else if(dd == 2) {
				System.out.println("inserisci la parola presente nel dizionario che vuoi eliminare:");
				
				miaParola.setParola(sc.next());
				//SELEZIONO LA PAROLA CHE VERRA ELIMINATA
				String istruzioneSql ="DELETE FROM parola WHERE pChiave='"+miaParola.getParola()+"'";
				mioStatement.executeUpdate(istruzioneSql);
				System.out.println("parola ELIMINATA correttamente");
				
			}
			
				
		}
		catch (SQLException e)
		{

			System.out.println("non si connette!!");
			
			e.printStackTrace();
		}
	
	}

	public static void main(String[] args) {
		
		//ISTANZIO UN OBJECT DI TIPO visualizzaDati
		mostraDati dd = new mostraDati();
		//RICHIAMO IL SUO METODO
		dd.risposta();
		
		

	}

}