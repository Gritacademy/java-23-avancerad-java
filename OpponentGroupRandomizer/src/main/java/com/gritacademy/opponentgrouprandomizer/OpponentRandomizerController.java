package com.gritacademy.opponentgrouprandomizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.util.*;

public class OpponentRandomizerController {
    private ArrayList<TitledPane> paneGroups = new ArrayList<>();

    @FXML
    private Accordion leftTitled;

    @FXML
    private Accordion rightTitled;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Label welcomeText;

    @FXML
    void onLoadButtonAction(ActionEvent event) {
        leftTitled.getPanes().clear();
        rightTitled.getPanes().clear();
        // Label label = new Label();
        //ArrayList<String> nameArray = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
        try {
            File namnfile = new File("src/nameList.txt");
            Scanner sc = new Scanner(namnfile);
            int key;
            //nameArray = new ArrayList<>();
            //Avslutas med vad somd standard? whitespace?
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] sa = line.split("\\s", 2);
                System.out.println(Arrays.deepToString(sa));

                try {
                    key = Integer.parseInt(sa[0]);
                } catch (Exception ne) {
                    System.out.println(ne);
                    continue;
                }
                System.out.println(key);
                if (hm.containsKey(key))
                    hm.get(key).add(sa[1]);
                else
                    hm.put(key, new ArrayList<String>() {
                        {
                            add(sa[1]);
                        }
                    });

                System.out.println(hm);

            }

            for (int i : hm.keySet()) {
                String[] sa = hm.get(i).toArray(new String[2]);
                paneGroups.add(makeTitlePanes("group " + i, sa));
            }


            System.out.println(hm);
            //System.out.println(paneGroups);
            Collections.shuffle(paneGroups);
            for (int i = 0; i < paneGroups.size() - 1; i++)
                if (i % 2 == 0) leftTitled.getPanes().add(paneGroups.get(i));
                else rightTitled.getPanes().add(paneGroups.get(i));

            // nameArray.add(sc.nextLine());
      /*      for (ArrayList<String> l:leftGroups) {
                String [] sa=((String[]) l.toArray());
                System.out.println(Arrays.deepToString(sa));
                leftTitled.getPanes().add(makeTitlePanes("1", sa ));
            }*/
   /*         groups.forEach((arrayList) -> {
                System.out.println(arrayList);
                String[] sa = arrayList.toArray(new String[2]);
                leftTitled.getPanes().add(makeTitlePanes("1", sa));
            });*/

            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private TitledPane makeTitlePanes(String groupName, String[] members) {
        TitledPane tp = new TitledPane(groupName, null);
        //tp.setExpanded(false);
        String result = "";
        for (String m : members)
            result += m + "\n";
        tp.setContent(new TextArea(result));

        return tp;
    }

}
