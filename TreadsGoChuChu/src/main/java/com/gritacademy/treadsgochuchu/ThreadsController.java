package com.gritacademy.treadsgochuchu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.gritacademy.treadsgochuchu.TreadsApplication.t2;
import static com.gritacademy.treadsgochuchu.TreadsApplication.t3;

public class ThreadsController {
    List<Train> trainList = new ArrayList<>();

    @FXML
    private Label titel;

    @FXML
    private VBox trainContainer;
    @FXML
    private ScrollPane scroll;

    @FXML
    void onStopButton(ActionEvent event) {
        System.out.println("Commence operation TrainCrashy!!!");
       Thread tr= new Thread(t2);   // Runnable
       tr.start();                  //s


        for (Train t:trainList)
         t.interrupt();

    }
    @FXML
    void onStartTheadButton(ActionEvent event) throws InterruptedException {
        
/*        int x=8;
        int y=8888;
        int z=88888888;
        
        ArrayList<String> sl= new ArrayList<>();
        for(int i = 0 ; i<4000 ; i++){
            sl.add("hej");
        }
        sl.get(20);  // acces test
        makeBrackets(200);*/





        System.out.println("Go!!");
        ProgressBar pb = new ProgressBar();

        pb.setPrefWidth(trainContainer.getWidth());
        //pb.setProgress(0.5);
        trainContainer.getChildren().add(pb);


        Train newTrain= new Train(pb); // en ny thread implements Runnable
        newTrain.start();
        trainList.add(newTrain);
        //System.out.println(trainContainer.getWidth());
        scroll.setVvalue(scroll.getVmax());
            //pb.setMinWidth(Control.USE_PREF_SIZE);
            //pb.setMaxWidth(Control.USE_PREF_SIZE);
            //pb.setMaxWidth(trainContainer.getWidth());
    }

    //log n tournament
     int makeBrackets(int n){
        if(n==0) return 0;
         n = (int) Math.floor(n/2);
         System.out.println("amount of bracket i tournament: "+n);
        return makeBrackets(n);
    }


}
