package ch.zhaw.gpi.twitterreview.delegates;

import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * Implementation of send task "Mitarbeiter benachrichtigen"
 * 
 * @author schoepa1 <schoepa1@students.zhaw.ch>
 */

@Named("notifyEmployeeAdapter")
public class NotifyEmployeeDelegate implements JavaDelegate{

    /**
     * Mocks the sending of a message via email
     * 
     * 1. reads the process variable
     * 2. creates the email
     * 3. prints email in system output
     * 
     * @param execution            Object, which creates a connection to the process engine and the current execution
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // Prozessvariablen auslesen
        String email = (String) execution.getVariable("email");
        String tweetContent = (String) execution.getVariable("tweetContent");
        String checkResult = (String) execution.getVariable("checkResult");
        String checkResultComment = (String) execution.getVariable("checkResultComment");
        
        // Die E-Mail-Nachricht zusammenbauen
        String mailHauptteil;
        if(checkResult.equals("rejected")){
            mailHauptteil = "Leider wurde diese Tweet-Anfrage abgelehnt mit " +
                    "folgender Begründung:\n" + checkResultComment;
        } else {
            mailHauptteil = "Dein Tweet wurde geposted. Herzlichen Dank für Deinen Beitrag.";
        }
        
        // Mail-Text zusammenbauen
        String mailBody = "Hallo Mitarbeiter\n\n" + "Du hast folgenden Text zum " +
                "Veröffentlichen als Tweet vorgeschlagen:\n" + tweetContent + "\n\n" +
                mailHauptteil + "\n\n" + "Deine Kommunikationsabteilung";
        
        // Mail in Konsole ausgeben
        System.out.println("########### BEGIN MAIL ##########################");
        System.out.println("############################### Mail-Empfänger: " + email);
        System.out.println(mailBody);
        System.out.println("########### END MAIL ############################");
    }
    
}
