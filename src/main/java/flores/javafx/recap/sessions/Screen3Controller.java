package flores.javafx.recap.sessions;


import flores.javafx.recap.model.Worker;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Screen3Controller implements Initializable {

    @FXML
    private TextField searchTxTField;
    @FXML
    private TableView<Worker> workerTableView;
    @FXML
    private TableColumn<Worker,Integer> idColumn;
    @FXML
    private TableColumn<Worker,String> nameColumn;
    @FXML
    private TableColumn<Worker,String> emailColumn;
    @FXML
    private TableColumn<Worker,String> departmentColumn;
    @FXML
    private TableColumn<Worker,Integer> salaryColumn;


    private ObservableList<Worker> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        List<Worker> testData  = getTestData();
        dataList.addAll(testData);

        //Wrap the observableList in a FilteredList (initially display all data)
        FilteredList<Worker> filteredData = new FilteredList<>(dataList,b->true);

        //Add listener to input from the textFields
        searchTxTField.textProperty().addListener((observable, oldvalue,newValue)->{
            // Implement Predicate interface
           filteredData.setPredicate(worker -> {
               if(newValue == null || newValue.isEmpty()){
                   return true;
               }
               String lowerCaseFilter = newValue.toLowerCase();

               if(worker.getName().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                   return true;
               }else if(worker.getDepartment().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
               } else if(worker.getEmail().toLowerCase().indexOf(lowerCaseFilter)!=-1){

                   return true;
               }else if(String.valueOf(worker.getSalary()).indexOf(lowerCaseFilter)!=-1) {
                      return true;

               }else if(String.valueOf(worker.getId()).indexOf(lowerCaseFilter)!=-1) {
                    return true;
               }
               else{
                   return false;
               }
           });

        });

        SortedList<Worker> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(workerTableView.comparatorProperty());
        workerTableView.setItems(sortedData);


    }

    private List<Worker> getTestData() {
        List<Worker> dataList = new ArrayList<>();
        dataList.add(new Worker(11,"Kalle Persson","kalle@gmail.com","GT",40000));
        dataList.add(new Worker(12,"Pelle Persson","pelle@gmail.com","GT",41000));
        dataList.add(new Worker(13,"Urban Persson","urban@gmail.com","GT",42000));
        dataList.add(new Worker(14,"Camilla Flores","cjos@gmail.com","MT",43000));
        dataList.add(new Worker(15,"Enrique Flores","enfl@gmail.com","MT",44000));
        dataList.add(new Worker(16,"Adrian Flores","adibad@gmail.com","MT",45000));
        dataList.add(new Worker(17,"Abdula Mohammed","abdu@gmail.com","MT",46000));
        dataList.add(new Worker(18,"Shalom  Peres","shapo@gmail.com","GT",47000));
        return dataList;
    }
}
