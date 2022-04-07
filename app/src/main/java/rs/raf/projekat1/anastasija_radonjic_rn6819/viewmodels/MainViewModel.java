package rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Ticket;

public class MainViewModel extends ViewModel {

//    public static int counter = 101;

    private final MutableLiveData<List<Ticket>> enhancments = new MutableLiveData<>();
    private final ArrayList<Ticket> enhancmentsList = new ArrayList<>();

    private final MutableLiveData<List<Ticket>> inProgress = new MutableLiveData<>();
    private final ArrayList<Ticket> inProgressList = new ArrayList<>();

    private final MutableLiveData<List<Ticket>> inDone = new MutableLiveData<>();
    private final ArrayList<Ticket> inDoneList = new ArrayList<>();

//    private final MutableLiveData<List<Bug>> bugs = new MutableLiveData<>();
//    private final ArrayList<Bug> bugsList = new ArrayList<>();

    public MainViewModel() {

        Random random = new Random();
        int numEnhancment = random.nextInt(25);
        int numBug = random.nextInt(25);

        for (int i = 0; i <= numEnhancment; i++) {
            Ticket ticket = new Ticket("Enhancment" + i,
                    random.nextInt(11)*1000,
                    "This is a description of an enhancement");
            ticket.setType("Enhancment");
            ticket.setPriority("High");
            enhancmentsList.add(ticket);
        }

//        ArrayList<Ticket> listToSubmitTicket = new ArrayList<>(enhancmentsList);
//        enhancments.setValue(listToSubmitTicket);

        for (int i = 0; i <= numBug; i++) {
            Ticket bug = new Ticket("Bug" + i,
                    random.nextInt(11)*1000,
                    "This is a description of a bug");
            bug.setType("Bug");
            bug.setPriority("High");
            enhancmentsList.add(bug);
        }

//        ArrayList<Bug> listToSubmitBug = new ArrayList<>(bugsList);
//        bugs.setValue(listToSubmitBug);

        ArrayList<Ticket> listToSubmitTicket = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmitTicket);


    }

    public LiveData<List<Ticket>> getEnhancment() {
        return enhancments;
    }

    public  LiveData<List<Ticket>> getInProgress() { return inProgress;}

    public LiveData<List<Ticket>> getInDone(){ return inDone;}

//    public LiveData<List<Bug>> getBug() {
//        return bugs;
//    }

    public int getEnhancmentSum() {
        int sum = 0;
        for (Ticket e: enhancmentsList) {
            if(e.getType().equals("Enhancment")){
                sum ++;
            }
        }
        return sum;
    }

    public int getBugSum() {
        int sum = 0;
        for (Ticket b: enhancmentsList) {
            if(b.getType().equals("Bug")){
                sum ++;
            }
        }
        return sum;
    }

    public int getInProgressEnhancmentSum() {
        int sum = 0;
        for (Ticket e: inProgressList) {
            if(e.getType().equals("Enhancment")){
                sum ++;
            }
        }
        return sum;
    }

    public int getInProgressBugSum() {
        int sum = 0;
        for (Ticket b: inProgressList) {
            if(b.getType().equals("Bug")){
                sum ++;
            }
        }
        return sum;
    }

    public int getDoneEnhancmentSum() {
        int sum = 0;
        for (Ticket e: inDoneList) {
            if(e.getType().equals("Enhancment")){
                sum ++;
            }
        }
        return sum;
    }

    public int getDoneBugSum() {
        int sum = 0;
        for (Ticket b: inDoneList) {
            if(b.getType().equals("Bug")){
                sum ++;
            }
        }
        return sum;
    }


    public void addTicket(String type, String priority, int estimation, String title, String description) {
        Ticket ticket = new Ticket(type, priority, estimation, title, description);
        enhancmentsList.add(ticket);
        ArrayList<Ticket> listToSubmit = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmit);
    }

//    public void addBug(String title, int estimation, String description) {
//        Ticket ticket = new Bug(title, estimation, description);
//        enhancmentsList.add(ticket);
//        ArrayList<Bug> listToSubmit = new ArrayList<>(bugsList);
//        enhancments.setValue(listToSubmit);
//    }

    public void filterTickets(String filter){

        List<Ticket> filteredList = enhancmentsList.stream().filter(enhancment -> enhancment.getTitle().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        enhancments.setValue(filteredList);

    }

    public void filterTicketsInProgress(String filter){

        List<Ticket> filteredList = inProgressList.stream().filter(enhancment -> enhancment.getTitle().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        inProgress.setValue(filteredList);

    }

    public void filterTicketsInDone(String filter){

        List<Ticket> filteredList = inDoneList.stream().filter(enhancment -> enhancment.getTitle().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        inDone.setValue(filteredList);

    }

    public void moveFromToDo2InProgress(Ticket ticket){
        //Brisem element iz liste TO-DO
        enhancmentsList.remove(ticket);
        ArrayList<Ticket> listToSubmitTicket = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmitTicket);

        //Taj element dodajem u listu InProgress
        inProgressList.add(ticket);
        ArrayList<Ticket> listToSubmitTicketInProgress = new ArrayList<>(inProgressList);
        inProgress.setValue(listToSubmitTicketInProgress);
    }

    public void moveFromInProgress2InDone(Ticket ticket){
        //Brisem element iz liste InProgress
        inProgressList.remove(ticket);
        ArrayList<Ticket> listToSubmitTicket = new ArrayList<>(inProgressList);
        inProgress.setValue(listToSubmitTicket);

        //Taj element dodajem u listu InDone
        inDoneList.add(ticket);
        ArrayList<Ticket> listToSubmitTicketInDone = new ArrayList<>(inDoneList);
        inDone.setValue(listToSubmitTicketInDone);
    }

    public void moveFromInProgress2InToDo(Ticket ticket){
        //Brisem element iz liste InProgress
        inProgressList.remove(ticket);
        ArrayList<Ticket> listToSubmitTicket = new ArrayList<>(inProgressList);
        inProgress.setValue(listToSubmitTicket);

        //Taj element dodajem u listu To Do
        enhancmentsList.add(ticket);
        ArrayList<Ticket> listToSubmitTicketInDone = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmitTicketInDone);
    }

    public void deleteTicket(Ticket ticket){
        enhancmentsList.remove(ticket);
        ArrayList<Ticket>listToSubmit = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmit);
    }
//    public void removeEnhancment(Ticket ticket) {
//        enhancmentsList.remove(ticket);
//        ArrayList<Ticket> listToSubmit = new ArrayList<>(enhancmentsList);
//        enhancments.setValue(listToSubmit);
//    }
//
//    public void removeBug(Bug bug) {
//        bugsList.remove(bug);
//        ArrayList<Bug> listToSubmit = new ArrayList<>(bugsList);
//        bugs.setValue(listToSubmit);
//    }
}
