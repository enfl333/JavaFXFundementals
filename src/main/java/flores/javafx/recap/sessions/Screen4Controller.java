package flores.javafx.recap.sessions;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.CheckBoxTreeCell;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen4Controller implements Initializable {

    @FXML
    TreeView<String> treeOfTest;

    public void runSelected(){

        TreeItem<String> root = treeOfTest.getRoot();
        ObservableList<TreeItem<String>> children = root.getChildren();
        System.out.println("All tests: "+children.size());

    }

    public void stopTest(){
        System.out.println("Stop the tests");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CheckBoxTreeItem<String> test1 = new CheckBoxTreeItem<String>("test1");
        CheckBoxTreeItem<String> test2 = new CheckBoxTreeItem<String>("test2");
        CheckBoxTreeItem<String> test3 = new CheckBoxTreeItem<String>("test3");
        CheckBoxTreeItem<String> test4 = new CheckBoxTreeItem<String>("test4");
        CheckBoxTreeItem<String> test5 = new CheckBoxTreeItem<String>("test5");
        CheckBoxTreeItem<String> testCase1 = new CheckBoxTreeItem<String>("TestCase1");

        CheckBoxTreeItem<String> test6 = new CheckBoxTreeItem<String>("test6");
        CheckBoxTreeItem<String> test7 = new CheckBoxTreeItem<String>("test7");
        CheckBoxTreeItem<String> test8 = new CheckBoxTreeItem<String>("test8");
        CheckBoxTreeItem<String> test9 = new CheckBoxTreeItem<String>("test9");
        CheckBoxTreeItem<String> test10 = new CheckBoxTreeItem<String>("test10");
        CheckBoxTreeItem<String> testCase2 = new CheckBoxTreeItem<String>("TestCase2");

        CheckBoxTreeItem<String> batch = new CheckBoxTreeItem<String>("Batch1");

        //Compose
        testCase1.getChildren().addAll(test1,test2,test3,test4,test5);
        testCase2.getChildren().addAll(test6,test7,test8,test9,test10);
        batch.getChildren().addAll(testCase1,testCase2);

        treeOfTest.setRoot(batch);
        treeOfTest.setCellFactory(CheckBoxTreeCell.<String>forTreeView());

    }
}
