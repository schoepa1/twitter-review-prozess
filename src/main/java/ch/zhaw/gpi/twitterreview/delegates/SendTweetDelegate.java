package ch.zhaw.gpi.twitterreview.delegates;

import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 *
 * Implementation of Service Task "Tweet senden"
 * 
 * @author schoepa1 <schoepa1@students.zhaw.ch>
 */

@Named("sendTweetAdapter")
public class SendTweetDelegate implements JavaDelegate
{

    /**
     * 1. Read the process variable "tweetContent"
     * 2. The text will be outputet on the console
     * 
     * @param execution            Object, which creates a connection to the process engine and the current execution
     * @throws Exception
     */
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String tweetContent = (String) execution.getVariable("tweetContent");
        System.out.println("-------------------------------------------------\nFolgender Tweet wird veröffentlicht: " + tweetContent + "\n---------------------");
    }
    
}
