package com.example.jerrypaddy;

import com.example.jerrypaddy.collection.MyQueue;
import com.example.jerrypaddy.inventorycategories.*;
import com.example.jerrypaddy.others.Bill;
import com.example.jerrypaddy.others.IssuedGoods;
import com.example.jerrypaddy.others.Vendors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.*;

public class Trrrr implements Initializable {

    @FXML
    private TextField v_contact;

    @FXML
    private TextField vendor_name;

    @FXML
    private TextField vendor_product;

    @FXML
    private TextField v_gender;

    @FXML
    private TextField v_age;


    @FXML
    private MenuButton addGoods;

    @FXML
    private MenuItem beverages;

    @FXML
    private MenuItem bakery;

    @FXML
    private MenuItem canned;

    @FXML
    private MenuItem dairy;

    @FXML
    private MenuItem dry;

    @FXML
    private MenuItem frozenProducts;

    @FXML
    private MenuItem meat;

    @FXML
    private MenuItem farmProduce;

    @FXML
    private MenuItem homeCleaners;

    @FXML
    private MenuItem paperGoods;

    @FXML
    private MenuItem homeCare;

    @FXML
    private Label type_product;

    @FXML
    private TextField nameProduct;

    @FXML
    private TextField numberInPackage;

    @FXML
    private TextField cost_per_item;

    @FXML
    private TextField sellingPrice;

    @FXML
    private TableView<Vendors> v_table;

    @FXML
    private TableColumn<Vendors, String> vend_product;

    @FXML
    private TableColumn<Vendors, String> vend_name;

    @FXML
    private TableColumn<Vendors, String> vend_gender;

    @FXML
    private TableColumn<Vendors, Integer> vend_age;

    @FXML
    private TableColumn<Vendors, Integer> vend_contact;

    ObservableList<Vendors> vendorsObservableList = FXCollections.observableArrayList();



    @FXML
    private Button add;
//Bakery, Canned/Jarred, Dairy Products
    @FXML
    void onAddGoods(ActionEvent event) {
        if (nameProduct.getText().equals("") || numberInPackage.getText().equals("") ||
        cost_per_item.getText().equals("") || sellingPrice.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.WARNING, "There is an empty field");
            alert.show();
        } else if (type_product.getText().contains("Select")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Select your product category from add goods drop down");
            alert.show();
        } else {
            if (type_product.getText().equals("Beverages")){
                try{
                    String beverageName = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    Beverages beverage = new Beverages(beverageName, number, cost, sell);
                    Stack<Beverages> stack = new Stack<>();
                    stack.push(beverage);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into beverages (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + beverageName + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();


                }catch(Exception e){
                    e.printStackTrace();
                }



            }

            if (type_product.getText().equals("Bakery")){
                try{
                    String bakeryName = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    Bakery bakery = new Bakery(bakeryName, number, cost, sell);
                    Stack<Bakery> stack = new Stack<>();
                    stack.push(bakery);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into bakery (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + bakeryName + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch(Exception e){
                    e.printStackTrace();
                }


            }

            if (type_product.getText().equals("Canned")){
                try{
                    String cannedName = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    Canned_Jarred canned1 = new Canned_Jarred(cannedName, number, cost, sell);
                    Stack<Canned_Jarred> stack = new Stack<>();
                    stack.push(canned1);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into canned (name, number_in_package, cost_per_item, selling_price) values (\""  + cannedName + "\"" + "," + number + "," + cost + "," + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            if (type_product.getText().equals("Dairy Products")){
                try{
                    String dairy = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    DairyProducts dairyProduct = new DairyProducts(dairy, number, cost, sell);
                    Stack<DairyProducts> stack = new Stack<>();
                    stack.push(dairyProduct);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into dairy (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + dairy + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            //using queues

            if (type_product.getText().equals("Dry/Baking Goods")){
                try{
                    String dryName = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    Dry_Products dryProducts = new Dry_Products(dryName, number, cost, sell);
                    MyQueue<Dry_Products> queue = new MyQueue<>();
                    queue.enqueue(dryProducts);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into dry_goods (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + dryName + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }


            }

            if (type_product.getText().equals("Frozen Products")){
                try{
                    String frozen = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    FrozenProducts frozenProducts = new FrozenProducts(frozen, number, cost, sell);
                    MyQueue<FrozenProducts> queue = new MyQueue<>();
                    queue.enqueue(frozenProducts);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into frozen_products (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + frozen + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }


            }

            if (type_product.getText().equals("Meat")){
                try{
                    String meatName = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());

                    Meat meat = new Meat(meatName, number, cost, sell);
                    MyQueue<Meat> queue = new MyQueue<>();
                    queue.enqueue(meat);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into meat (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + meatName + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            //Farm Produce, Home Cleaners, Paper Goods, Home Care

            if (type_product.getText().equals("Farm Produce")){
                try{
                    String farmP = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());
                    FarmProduce farmProduce1 = new FarmProduce(farmP, number, cost, sell);
                    List<FarmProduce> list2 = new ArrayList<>();
                    list2.add(farmProduce1);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into farm_produce (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + farmP + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (type_product.getText().equals("Home Cleaners")){
                try{
                    String homeClean = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());
                    HomeCleaners homeCleaners1 = new HomeCleaners(homeClean, number, cost, sell);
                    List<HomeCleaners> list2 = new ArrayList<>();
                    list2.add(homeCleaners1);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into home_cleaners (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + homeClean + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            if (type_product.getText().equals("Paper Goods")){
                try{
                    String paper = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());
                    PaperGoods paperGoods1 = new PaperGoods(paper, number, cost, sell);
                    List<PaperGoods> list2 = new ArrayList<>();
                    list2.add(paperGoods1);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into paper_goods (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + paper + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if (type_product.getText().equals("Home Care")){
                try{
                    String care = nameProduct.getText().toString();
                    int number = Integer.parseInt(numberInPackage.getText().toString());
                    float cost = Float.parseFloat(cost_per_item.getText().toString());
                    float sell = Float.parseFloat(sellingPrice.getText().toString());
                    HomeCare homeCare1 = new HomeCare(care, number, cost, sell);
                    List<HomeCare> list1 = new ArrayList<>();
                    list1.add(homeCare1);
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
                    Statement statement = connection.createStatement();
                    statement.execute("insert into home_care (name, number_in_package, cost_per_item, selling_price) values (" + "\"" + care + "\"" + ", " + number +", " + cost +", " + sell + ")");
                    nameProduct.setText("");
                    numberInPackage.setText("");
                    cost_per_item.setText("");
                    sellingPrice.setText("");
                    type_product.setText("Select from Menu");
                    list.clear();
                    addToTable();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }





        }


    }

    @FXML
    void onBakeryClick(ActionEvent event) {
        type_product.setText(bakery.getText());

    }

    @FXML
    void onBeverageClick(ActionEvent event) {
        type_product.setText(beverages.getText());

    }

    @FXML
    void onCannedClick(ActionEvent event) {
        type_product.setText(canned.getText());
    }

    @FXML
    void onDairyClick(ActionEvent event) {
        type_product.setText(dairy.getText());
    }

    @FXML
    void onDryClick(ActionEvent event) {
        type_product.setText(dry.getText());

    }

    @FXML
    void onFarmClick(ActionEvent event) {
        type_product.setText(farmProduce.getText());

    }

    @FXML
    void onFrozenClick(ActionEvent event) {
        type_product.setText(frozenProducts.getText());

    }

    @FXML
    void onHomeCareClick(ActionEvent event) {
        type_product.setText(homeCare.getText());
    }

    @FXML
    void onHomeCleanersClick(ActionEvent event) {
        type_product.setText(homeCleaners.getText());

    }

    @FXML
    void onMeatClick(ActionEvent event) {
        type_product.setText(meat.getText());

    }

    @FXML
    void onPaperGoodsClick(ActionEvent event) {
        type_product.setText(paperGoods.getText());

    }

    public void onAddVendor(ActionEvent actionEvent) {
        try{
            String name = vendor_name.getText().toString();
            String productType = vendor_product.getText().toString();
            String gender = v_gender.getText().toString();

            int age = Integer.parseInt(v_age.getText().toString());
            int phoneNumber = Integer.parseInt(v_contact.getText().toString());
            Vendors vendor = new Vendors(name, productType, gender, age, phoneNumber);
            HashMap<Integer, Vendors> vendorsHashMap = new HashMap<>();
            vendorsHashMap.put(phoneNumber, vendor);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            statement.execute("insert into vendors (name, gender, age, contact, product_type) values (" + "\"" + name + "\"" + ", "
            + "\"" + gender + "\"" + ", " + age + ", " + phoneNumber + ", " + "\"" + productType + "\"" + ")");



        }catch (Exception e){
            e.printStackTrace();
        }


    }

    ObservableList<AllGoods> list = FXCollections.observableArrayList();


    @FXML
    private TableView<AllGoods> remove_table;

    @FXML
    private TableColumn<AllGoods, String> name_column;

    @FXML
    private TableColumn<AllGoods, Integer> number_column;

    @FXML
    private TableColumn<AllGoods, Float> cost_column;

    @FXML
    private TableColumn<AllGoods, Float> selling_column;

    @FXML
    private TableColumn<AllGoods, Float> gross_column;

    public void addToTable(){
        try{
            list3.clear();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            String sql = "Select * from beverages";
            String sql2 = "Select * from bakery";
            String sql3 = "Select * from canned";
            String sql4 = "Select * from dairy";
            String sql5 = "select * from dry_goods";
            String sql6 = "select * from farm_produce";
            String sql7 = "select * from frozen_products";
            String sql8 = "select * from home_care";
            String sql9 = "select * from home_cleaners";
            String sql10 = "select * from meat";
            String sql11 = "select * from paper_goods";
            ResultSet result1 = statement.executeQuery(sql);
            while (result1.next()){
                list3.add(new AllGoods(result1.getString("name"),
                        result1.getInt("number_in_package"),
                        result1.getFloat("cost_per_item"),
                        result1.getFloat("selling_price"),
                        result1.getFloat("gross_cost")));
            }
            ResultSet result2 = statement.executeQuery(sql2);
            while (result2.next()){
                list3.add(new AllGoods(result2.getString("name"),
                        result2.getInt("number_in_package"),
                        result2.getFloat("cost_per_item"),
                        result2.getFloat("selling_price"),
                        result2.getFloat("gross_cost")));
            }
            ResultSet result3 = statement.executeQuery(sql3);
            while (result3.next()){
                list3.add(new AllGoods(result3.getString("name"),
                        result3.getInt("number_in_package"),
                        result3.getFloat("cost_per_item"),
                        result3.getFloat("selling_price"),
                        result3.getFloat("gross_cost")));
            }
            ResultSet result4 = statement.executeQuery(sql4);
            while (result4.next()){
                list3.add(new AllGoods(result4.getString("name"),
                        result4.getInt("number_in_package"),
                        result4.getFloat("cost_per_item"),
                        result4.getFloat("selling_price"),
                        result4.getFloat("gross_cost")));
            }
            ResultSet result5 = statement.executeQuery(sql5);
            while (result5.next()){
                list3.add(new AllGoods(result5.getString("name"),
                        result5.getInt("number_in_package"),
                        result5.getFloat("cost_per_item"),
                        result5.getFloat("selling_price"),
                        result5.getFloat("gross_cost")));
            }
            ResultSet result6 = statement.executeQuery(sql6);
            while (result6.next()){
                list3.add(new AllGoods(result6.getString("name"),
                        result6.getInt("number_in_package"),
                        result6.getFloat("cost_per_item"),
                        result6.getFloat("selling_price"),
                        result6.getFloat("gross_cost")));
            }
            ResultSet result7 = statement.executeQuery(sql7);
            while (result7.next()){
                list3.add(new AllGoods(result7.getString("name"),
                        result7.getInt("number_in_package"),
                        result7.getFloat("cost_per_item"),
                        result7.getFloat("selling_price"),
                        result7.getFloat("gross_cost")));
            }
            ResultSet result8 = statement.executeQuery(sql8);
            while (result8.next()){
                list3.add(new AllGoods(result8.getString("name"),
                        result8.getInt("number_in_package"),
                        result8.getFloat("cost_per_item"),
                        result8.getFloat("selling_price"),
                        result8.getFloat("gross_cost")));
            }
            ResultSet result9 = statement.executeQuery(sql9);
            while (result9.next()){
                list3.add(new AllGoods(result9.getString("name"),
                        result9.getInt("number_in_package"),
                        result9.getFloat("cost_per_item"),
                        result9.getFloat("selling_price"),
                        result9.getFloat("gross_cost")));
            }
            ResultSet result10 = statement.executeQuery(sql10);
            while (result10.next()){
                list3.add(new AllGoods(result10.getString("name"),
                        result10.getInt("number_in_package"),
                        result10.getFloat("cost_per_item"),
                        result10.getFloat("selling_price"),
                        result10.getFloat("gross_cost")));
            }
            ResultSet result11 = statement.executeQuery(sql11);
            while (result11.next()) {
                list3.add(new AllGoods(result11.getString("name"),
                        result11.getInt("number_in_package"),
                        result11.getFloat("cost_per_item"),
                        result11.getFloat("selling_price"),
                        result11.getFloat("gross_cost")));

            }
            remove_table.setItems(list3);


        }catch (Exception e){

        }
    }



    public void onGoodsRemove(ActionEvent actionEvent) {
        int selectedID = remove_table.getSelectionModel().getSelectedIndex();
        remove_table.getItems().remove(selectedID);



    }

    @FXML
    private TableView<AllGoods> view_goods;

    @FXML
    private TableColumn<AllGoods, Integer> view_number;

    @FXML
    private TableColumn<AllGoods, String> view_name;

    @FXML
    private TableColumn<AllGoods, Float> view_cost;

    @FXML
    private TableColumn<AllGoods, Float> view_sell;

    @FXML
    private TableColumn<AllGoods, Float> view_gross;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_column.setCellValueFactory(new PropertyValueFactory<AllGoods, String>("name"));
        number_column.setCellValueFactory(new PropertyValueFactory<AllGoods, Integer>("numberInPackage"));
        cost_column.setCellValueFactory(new PropertyValueFactory<AllGoods, Float>("costPerItem"));
        selling_column.setCellValueFactory(new PropertyValueFactory<AllGoods, Float>("sellingPrice"));
        gross_column.setCellValueFactory(new PropertyValueFactory<AllGoods, Float>("gross_cost"));
        view_name.setCellValueFactory(new PropertyValueFactory<AllGoods, String>("name"));
        view_number.setCellValueFactory(new PropertyValueFactory<AllGoods, Integer>("numberInPackage"));
        view_cost.setCellValueFactory(new PropertyValueFactory<AllGoods, Float>("costPerItem"));
        view_sell.setCellValueFactory(new PropertyValueFactory<AllGoods, Float>("sellingPrice"));
        view_gross.setCellValueFactory(new PropertyValueFactory<AllGoods, Float>("gross_cost"));
        vend_name.setCellValueFactory(new PropertyValueFactory<Vendors, String>("name"));
        vend_product.setCellValueFactory(new PropertyValueFactory<Vendors, String>("productCategory"));
        vend_gender.setCellValueFactory(new PropertyValueFactory<Vendors,String>("gender"));
        vend_age.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("age"));
        vend_contact.setCellValueFactory(new PropertyValueFactory<Vendors, Integer>("phoneNumber"));

        receiver_column.setCellValueFactory(new PropertyValueFactory<IssuedGoods, String>("receiver"));
        issued_column.setCellValueFactory(new PropertyValueFactory<IssuedGoods, String>("good"));
        quantity_column.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Integer>("quantity"));
        issued_costColumn.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Float>("cost"));
        issued_gross.setCellValueFactory(new PropertyValueFactory<IssuedGoods, Float>("gross_cost"));

        bill_name.setCellValueFactory(new PropertyValueFactory<Bill, String>("billName"));
        bill_amount.setCellValueFactory(new PropertyValueFactory<Bill, Float>("billAmount"));
    }

    ObservableList<AllGoods> list3 = FXCollections.observableArrayList();

    public void onViewGoods(ActionEvent actionEvent) {
        try{
            list3.clear();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            String sql = "Select * from beverages";
            String sql2 = "Select * from bakery";
            String sql3 = "Select * from canned";
            String sql4 = "Select * from dairy";
            String sql5 = "select * from dry_goods";
            String sql6 = "select * from farm_produce";
            String sql7 = "select * from frozen_products";
            String sql8 = "select * from home_care";
            String sql9 = "select * from home_cleaners";
            String sql10 = "select * from meat";
            String sql11 = "select * from paper_goods";
            ResultSet result1 = statement.executeQuery(sql);
            while (result1.next()){
                list3.add(new AllGoods(result1.getString("name"),
                        result1.getInt("number_in_package"),
                        result1.getFloat("cost_per_item"),
                        result1.getFloat("selling_price"),
                        result1.getFloat("gross_cost")));
            }
            ResultSet result2 = statement.executeQuery(sql2);
            while (result2.next()){
                list3.add(new AllGoods(result2.getString("name"),
                        result2.getInt("number_in_package"),
                        result2.getFloat("cost_per_item"),
                        result2.getFloat("selling_price"),
                        result2.getFloat("gross_cost")));
            }
            ResultSet result3 = statement.executeQuery(sql3);
            while (result3.next()){
                list3.add(new AllGoods(result3.getString("name"),
                        result3.getInt("number_in_package"),
                        result3.getFloat("cost_per_item"),
                        result3.getFloat("selling_price"),
                        result3.getFloat("gross_cost")));
            }
            ResultSet result4 = statement.executeQuery(sql4);
            while (result4.next()){
                list3.add(new AllGoods(result4.getString("name"),
                        result4.getInt("number_in_package"),
                        result4.getFloat("cost_per_item"),
                        result4.getFloat("selling_price"),
                        result4.getFloat("gross_cost")));
            }
            ResultSet result5 = statement.executeQuery(sql5);
            while (result5.next()){
                list3.add(new AllGoods(result5.getString("name"),
                        result5.getInt("number_in_package"),
                        result5.getFloat("cost_per_item"),
                        result5.getFloat("selling_price"),
                        result5.getFloat("gross_cost")));
            }
            ResultSet result6 = statement.executeQuery(sql6);
            while (result6.next()){
                list3.add(new AllGoods(result6.getString("name"),
                        result6.getInt("number_in_package"),
                        result6.getFloat("cost_per_item"),
                        result6.getFloat("selling_price"),
                        result6.getFloat("gross_cost")));
            }
            ResultSet result7 = statement.executeQuery(sql7);
            while (result7.next()){
                list3.add(new AllGoods(result7.getString("name"),
                        result7.getInt("number_in_package"),
                        result7.getFloat("cost_per_item"),
                        result7.getFloat("selling_price"),
                        result7.getFloat("gross_cost")));
            }
            ResultSet result8 = statement.executeQuery(sql8);
            while (result8.next()){
                list3.add(new AllGoods(result8.getString("name"),
                        result8.getInt("number_in_package"),
                        result8.getFloat("cost_per_item"),
                        result8.getFloat("selling_price"),
                        result8.getFloat("gross_cost")));
            }
            ResultSet result9 = statement.executeQuery(sql9);
            while (result9.next()){
                list3.add(new AllGoods(result9.getString("name"),
                        result9.getInt("number_in_package"),
                        result9.getFloat("cost_per_item"),
                        result9.getFloat("selling_price"),
                        result9.getFloat("gross_cost")));
            }
            ResultSet result10 = statement.executeQuery(sql10);
            while (result10.next()){
                list3.add(new AllGoods(result10.getString("name"),
                        result10.getInt("number_in_package"),
                        result10.getFloat("cost_per_item"),
                        result10.getFloat("selling_price"),
                        result10.getFloat("gross_cost")));
            }
            ResultSet result11 = statement.executeQuery(sql11);
            while (result11.next()) {
                list3.add(new AllGoods(result11.getString("name"),
                        result11.getInt("number_in_package"),
                        result11.getFloat("cost_per_item"),
                        result11.getFloat("selling_price"),
                        result11.getFloat("gross_cost")));

            }
            view_goods.setItems(list3);
            }catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onViewVendors(ActionEvent actionEvent) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from vendors");
            while(resultSet.next()){
                vendorsObservableList.add(new Vendors(resultSet.getString("name"),
                        resultSet.getString("product_type"), resultSet.getString("gender"),
                        resultSet.getInt("age"), resultSet.getInt("contact")));
            }
            v_table.setItems(vendorsObservableList);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private TextField rec_name;

    @FXML
    private TextField issued_good;

    @FXML
    private TextField issued_cost;

    @FXML
    private TextField quantity;

    public void onAddIssuedGoods(ActionEvent actionEvent) {
        try{
            String name = rec_name.getText().toString();
            String good = issued_good.getText().toString();
            int quantity1 = Integer.parseInt(quantity.getText().toString());
            float cost1 = Float.parseFloat(issued_cost.getText().toString());
            IssuedGoods issuedGoods = new IssuedGoods(name, good, quantity1, cost1);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            String quotation = "\"";
            statement.execute("insert into issued_goods (receiver, good, quantity, cost) values (" + quotation + name +
                     quotation + ", " + quotation + good + quotation + ", " + quantity1 + ", " + cost1 + ")");

        }catch (Exception e){
            e.printStackTrace();
        }



    }

    @FXML
    private TableView<IssuedGoods> issued_table;

    @FXML
    private TableColumn<IssuedGoods, String> receiver_column;

    @FXML
    private TableColumn<IssuedGoods, String> issued_column;

    @FXML
    private TableColumn<IssuedGoods, Integer> quantity_column;

    @FXML
    private TableColumn<IssuedGoods, Float> issued_costColumn;

    @FXML
    private TableColumn<IssuedGoods, Float> issued_gross;

    ObservableList<IssuedGoods> issuedGoodsObservableList = FXCollections.observableArrayList();


    public void onViewIssuedGoods(ActionEvent actionEvent) {
        try{
            issuedGoodsObservableList.clear();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            String sql = "Select * from issued_goods";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                issuedGoodsObservableList.add(new IssuedGoods(resultSet.getString("receiver"),
                        resultSet.getString("good"), resultSet.getInt("quantity"), resultSet.getFloat("cost")));
            }
            issued_table.setItems(issuedGoodsObservableList);


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private TableView<Bill> bill_table;

    @FXML
    private TableColumn<Bill, String> bill_name;

    @FXML
    private TableColumn<Bill, Float> bill_amount;

    ObservableList<Bill> billObservableList = FXCollections.observableArrayList();



    public void onViewBill(ActionEvent actionEvent) {
        try{
            billObservableList.clear();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "~!@#$%^&*()_");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from bills");
            while(resultSet.next()){
                billObservableList.add(new Bill(resultSet.getString("name"),
                        resultSet.getFloat("amount")));
            }
            bill_table.setItems(billObservableList);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onViewGoodsToRemove(ActionEvent actionEvent) {
        addToTable();
    }
}

