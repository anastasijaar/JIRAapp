package rs.raf.projekat1.anastasija_radonjic_rn6819.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Bug;
import rs.raf.projekat1.anastasija_radonjic_rn6819.models.Enhancment;

public class MainViewModel extends ViewModel {

    public static int counter = 101;

    private final MutableLiveData<List<Enhancment>> enhancments = new MutableLiveData<>();
    private final ArrayList<Enhancment> enhancmentsList = new ArrayList<>();

    private final MutableLiveData<List<Bug>> bugs = new MutableLiveData<>();
    private final ArrayList<Bug> bugsList = new ArrayList<>();

    public MainViewModel() {

        Random random = new Random();

        for (int i = 0; i <= 100; i++) {
            Enhancment enhancment = new Enhancment("Enhancment" + i,
                    random.nextInt(11)*1000,
                    "Ovo je opis nekog enhancmenta");
            enhancmentsList.add(enhancment);
        }

        ArrayList<Enhancment> listToSubmitEnhancment = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmitEnhancment);

        for (int i = 0; i <= 100; i++) {
            Bug bug = new Bug("Bug" + i,
                    random.nextInt(11)*1000,
                    "Ovo je opis nekog buga");
            bugsList.add(bug);
        }

        ArrayList<Bug> listToSubmitBug = new ArrayList<>(bugsList);
        bugs.setValue(listToSubmitBug);

    }

    public LiveData<List<Enhancment>> getEnhancment() {
        return enhancments;
    }

    public LiveData<List<Bug>> getBug() {
        return bugs;
    }

    public void filterTickets(String filter){

        List<Enhancment> filteredList = enhancmentsList.stream().filter(enhancment -> enhancment.getTitle().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        enhancments.setValue(filteredList);

    }

    public void removeEnhancment(Enhancment enhancment) {
        enhancmentsList.remove(enhancment);
        ArrayList<Enhancment> listToSubmit = new ArrayList<>(enhancmentsList);
        enhancments.setValue(listToSubmit);
    }

    public void removeRashod(Bug bug) {
        bugsList.remove(bug);
        ArrayList<Bug> listToSubmit = new ArrayList<>(bugsList);
        bugs.setValue(listToSubmit);
    }


}
