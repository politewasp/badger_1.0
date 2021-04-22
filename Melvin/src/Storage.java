import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *  <h1>Storage interface</h1>
 *  Driver class
 *  Written Using Java 15
 *  @author Maraiah Matson
 *  @version 1.1
 *  @since 2021-04-01
 */


public class Storage {
    // debugger
    Debug debug = Debug.getInstance();
    // static variable single_instance of type Debug
    private static Storage single_instance = null;

    // constants
    String goalKey = "Goals";
    String categoryKey = "Categories";
    String [] goalAttributes = new String [] {
            "name", "description", "date", "completed", "message"
    };
    String [] categoryAttributes = new String [] {
            "name", "description", "image link"
    };

    // interface attributes
    ArrayList<Goal> goals;
    ArrayList<Category> categories;

    // backend management attributes
    String filename;
    FileWriter outFile;
    FileReader inFile;
    JSONObject json;
    JSONArray jsonGoals;
    JSONArray jsonCategories;

    private Storage() {
        goals = new ArrayList<>();
        categories = new ArrayList<>();
        filename = "Melvin\\storage\\storage.json";
        json = unpack(filename);
    }

    public static Storage load()
    {
        if (single_instance == null)
            single_instance = new Storage();

        return single_instance;
    }

    public void test() throws IOException {
//        Goal goal = new Goal();
//        goal.setName("goal2");
//        goal.setDescription("this is another goal description");
//        add(goal);
//        Category c = new Category("cat1");
//        add(c);
//        write();
//
//        for(Goal g: goals){
//            debug.print(g.getName());
//        }
//        delete(goals.get(0));
//        for(Goal g: goals){
//            System.out.println(g.getName());
//        }
//        write();
    }
    
    public boolean add(Goal goal){
        for(Goal g: goals){
            if(g.equals(goal)){
                debug.print("This Goal Name is taken. ");
                return false;
            }
        }
        goals.add(goal);
        return true;
    }

    public boolean add(Category category){
        for(Category c: categories){
            if(c.equals(category)){
                debug.print("This Category Name is taken. ");
                return false;
            }
        }
        categories.add(category);
        return true;
    }
    
    public boolean delete(Goal goal){
        boolean removed = goals.remove(goal);
        System.out.println(removed);
        return removed;
    }

    public boolean delete(Category c){
        boolean removed = categories.remove(c);
        debug.print(removed);
        return removed;

    }

    public ArrayList<String> getGoalNames(){
        ArrayList<String> goalList = new ArrayList<>();
        for(Goal g: goals){
            goalList.add(g.getName());
        }
        return goalList;
    }

    public ArrayList<String> getCategoryNames(){
        ArrayList<String> categoryList = new ArrayList<>();
        for(Category c: categories){
            categoryList.add(c.getName());
        }
        return categoryList;
    }

    public void close() throws IOException {
        pack();
        write();
    }

    private void pack(){
        /* take list of goals and list of categories
           and reconstruct the high level JSONObject */

        // initialize final json object to be written to file
        JSONObject jsonFinal = new JSONObject();

        // initializes json arrays for storage lists
        JSONArray jsonGoals = new JSONArray();
        JSONArray jsonCategories = new JSONArray();

        // converts each goal/category to json object
        for(Goal g: goals){
            jsonGoals.add(toJSON(g));

        }
        for(Category c: categories){
            jsonCategories.add(toJSON(c));
        }

        // add json arrays to final json object
        jsonFinal.put(goalKey, jsonGoals);
        jsonFinal.put(categoryKey, jsonCategories);
        json = jsonFinal;
    }

    private JSONObject unpack(String filename){
        /* take the high level JSONObject and construct
           the attributes goals and categories, should
           only run once at launch to populate gui
           elements
           this function only return JSONObject to make
           it more obvious what it happening in the
           constructor */

        // catches end of file exception if file is empty
        try{
            json = read();
        }
        catch(Throwable ignored){
            json = new JSONObject();
            json.put(goalKey, new JSONArray());
            json.put(categoryKey, new JSONArray());
        }
        debug.print("json read");

        // extracts arrays from json object
        jsonGoals = (JSONArray) json.get(goalKey);
        jsonCategories = (JSONArray) json.get(categoryKey);

        // builds interface attributes from json
        for(Object object: jsonGoals){
            debug.print("reading goal object");
            JSONObject o = (JSONObject) object;
            Goal goal = JSONtoGoal(o);
            goals.add(goal);
        }
        for(Object object: jsonCategories){
            debug.print("reading category object");
            JSONObject o = (JSONObject) object;
            Category c = JSONtoCategory(o);
            categories.add(c);
        }
        return json;
    }

    private JSONObject toJSON(Goal goal){
        // convert Goal object to JSONObject
        JSONObject o = new JSONObject();

        String value;
        for(String key: goalAttributes){
            value = goalMap(goal, key);
            o.put(key, value);
        }
        return o;
    }

    private JSONObject toJSON(Category c){
        // convert Category object to JSONObject
        JSONObject o = new JSONObject();
        String value;
        for(String key: categoryAttributes){
            value = categoryMap(c, key);
            o.put(key, value);
        }
        return o;
    }

    private Goal JSONtoGoal(JSONObject o){
        // convert JSONObject to Goal object
        Goal goal = new Goal();
        Habit habit = new Habit();
        JSONObject oh;

        for(String key: goalAttributes){
            populateGoalAttribute(goal, o, key);
        }
        return goal;
    }

    private Category JSONtoCategory(JSONObject o){
        // convert JSONObject to Category Object
        Category c = new Category();
        for(String key: categoryAttributes){
            populateCategoryAttribute(c, o, key);
        }
        return c;
    }

    private JSONObject read() throws IOException, ParseException {
        inFile = new FileReader(filename);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(inFile);
        inFile.close();
        return jsonObject;
    }

    private void write() throws IOException {
        outFile = new FileWriter(filename);
        outFile.write(json.toJSONString());
        outFile.close();
    }

    private String goalMap(Goal goal, String key){
        // backend method to return key from goal
        return switch (key) {
            case "name" -> goal.getName();
            case "description" -> goal.getDescription();
            case "completed" -> Boolean.toString(goal.getCompleted());
            case "date" -> "";
            case "message" -> goal.getMessage();
            default -> throw new IllegalStateException("Unexpected value: " + key);
        };
    }

    private String categoryMap(Category c, String key){
        // backend method to return key from category
        return switch(key){
            case "name" -> c.getName();
            case "description" -> c.getDescription();
            case "image link" -> c.getImageLink();
            default -> throw new IllegalStateException("Unexpected value: " + key);
        };
    }

    private String populateGoalAttribute(Goal goal, JSONObject o, String key){
        // inputs goal, json object goal, and key
        // calls set method for goal attribute
        String keyValue = (String) o.get(key);
        switch (key) {
            case "name" -> goal.setName(keyValue);
            case "category" -> goal.setCategoryName(keyValue);
            case "description" -> goal.setDescription(keyValue);
            case "date" -> {}
            case "completed" -> goal.setCompleted(Boolean.parseBoolean(keyValue));
            case "message" -> {}
            default -> throw new IllegalStateException("Unexpected value: " + key);
        }
        return keyValue;
    }

    private String populateCategoryAttribute(Category c, JSONObject o, String key){
        // inputs category, json object category, and key
        // calls set method for category attribute
        String keyValue = (String) o.get(key);
        switch(key){
            case "name" -> c.setName(keyValue);
            case "description" -> c.setDescription(keyValue);
            case "image link" -> c.setImageLink(keyValue);
            default -> throw new IllegalStateException("Unexpected value: " + key);
        }
        return keyValue;
    }
    
}
