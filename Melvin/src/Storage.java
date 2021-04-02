import java.io.*;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Storage {
    // constants
    String goalKey = "Goals";
    String categoryKey = "Categories";
    String [] goalAttributes = new String [] {
            "name", "category", "description", "start date", "completed",
            "short/long", "frequencypt1", "frequencypt2", "check in message",
            "logs on time", "logs missed", "end date", "good/bad"
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

    public Storage() {
        goals = new ArrayList<>();
        categories = new ArrayList<>();
        filename = "Melvin\\storage\\storage.json";
        json = unpack(filename);
    }

    public void test() throws IOException {
        Goal goal = new Goal();
        goal.setName("goal2");
        goal.setDescription("this is another goal description");
        add(goal);
        write();

        for(Goal g: goals){
            System.out.println(g.getName());
        }
    }
    
    public Boolean add(Goal goal){
        for(Goal g: goals){
            if(g.getName().equals(goal.getName())){
                System.out.println("This Goal Name is taken. ");
                return false;
            }
        }
        pack(goal, false);
        goals.add(goal);
        return true;
    }
    
    public boolean delete(Goal goal){
        pack(goal, true);
        return goals.remove(goal);

    }

    private void pack(Goal goal, boolean delete){
        /* take list of goals and list of categories
           and reconstruct the high level JSONObject */

        // convert single Goal to JSONObject
        JSONObject jsonGoal = toJSON(goal);

        // add to JSONObject json['Goals']
        JSONArray jsonarray = (JSONArray) json.get("Goals");
        jsonarray.add(jsonGoal);
    }

    private void pack(Category category){
        /* take list of goals and list of categories
           and reconstruct the high level JSONObject */

    }

    private JSONObject toJSON(Goal goal){
        // convert Goal object to JSONObject
        JSONObject o = new JSONObject();
        for(String key: goalAttributes){
            goalMap(goal, o, key, false);
        }
        return o;
    }

    private Goal toGoal(JSONObject o){
        // convert JSONObject to Goal object
        Goal goal = new Goal();
        for(String key: goalAttributes){
            goalMap(goal, o, key, true);
        }
        return goal;
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
        System.out.println("json read");

        // extracts arrays from json object
        jsonGoals = (JSONArray) json.get(goalKey);
        jsonCategories = (JSONArray) json.get(categoryKey);

        // builds interface attributes from json
        for(Object object: jsonGoals){
            System.out.println("reading object");
            JSONObject o = (JSONObject) object;
            Goal goal = toGoal(o);
            goals.add(goal);
        }

        return json;
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

    private void goalMap(Goal goal, JSONObject o, String key, Boolean set){
        // returns attribute by JSON key
        String keyValue;

        // if converting from Goal object to JSON
        if(!set){
            keyValue = switch (key) {
                case "name" -> goal.getName();
                case "category" -> goal.getCategoryName();
                case "description" -> goal.getDescription();
                case "start date" -> goal.getStart();
                case "completed" -> Boolean.toString(goal.getCompleted());
                case "short/long" -> Boolean.toString(goal.getShortLong());
                case "frequencypt1" -> "tbd";
                case "frequencypt2" -> "tbd";
                case "check in message" -> "tbd";
                case "logs on time" -> "tbd";
                case "logs missed" -> "tbd";
                case "end date" -> goal.getEnd();
                case "good/bad" -> Boolean.toString(goal.getGoodBad());
                default -> throw new IllegalStateException("Unexpected value: " + key);
            };
            o.put(key, keyValue);
        }
        // if converting from JSON to Goal object
        else {
            keyValue = (String) o.get(key);
            switch (key) {
                case "name" -> goal.setName(keyValue);
                case "category" -> goal.setCategoryName(keyValue);
                case "description" -> goal.setDescription(keyValue);
                case "start date" -> goal.setStart(keyValue);
                case "completed" -> goal.setCompleted(Boolean.parseBoolean(keyValue));
                case "short/long" -> goal.setShortLong(Boolean.parseBoolean(keyValue));
                case "frequencypt1" -> {}
                case "frequencypt2" -> {}
                case "check in message" -> {}
                case "logs on time" -> {}
                case "logs missed" -> {}
                case "end date" -> goal.setEnd(keyValue);
                case "good/bad" -> goal.setGoodBad(Boolean.parseBoolean(keyValue));
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
        }
    }
}
