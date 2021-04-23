import java.io.*;
import java.util.ArrayList;

/**
 *  <h1>Storage</h1>
 *  Interface for Box
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

    /**
     * ArrayLists are used to store Goal and Category
     * objects to interface with BadgerController
     */
    ArrayList<Goal> goals;
    ArrayList<Category> categories;
    Box box;

    /**
     * Storage Constructor is set to private so that
     * only one instance of it can be created
     */
    private Storage() {
        box = Box.load();
        goals = box.getGoals();
        categories = box.getCategories();
        populateDefaultCategories();
    }

    /**
     * Storage.load() is used to load Storage instance
     */
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

    /**
     * Application interface to add Goals to storage as objects
     * @param goal Goal object
     * @return boolean indicates whether Goal was added to storage
     * or if Goal already exists within storage (determined by name)
     */
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

    /**
     * Application interface to add Goals to storage as objects
     * @param category Category object
     * @return boolean indicates whether Category was added to storage
     * or if Category already exists within storage (determined by name)
     */
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

    /**
     * Application interface to delete Goals from storage
     * @param goal Goal object
     * @return boolean indicates whether Goal was deleted from storage
     * or if Goal does not exist within storage (determined by name)
     */
    public boolean delete(Goal goal){
        boolean removed = goals.remove(goal);
        System.out.println(removed);
        return removed;
    }

    /**
     * Application interface to delete Categories from storage
     * @param c Category object
     * @return boolean indicates whether Category was deleted from storage
     * or if Category does not exist within storage (determined by name)
     */
    public boolean delete(Category c){
        boolean removed = categories.remove(c);
        debug.print(removed);
        return removed;

    }

    /**
     * @return ArrayList of Goals from storage
     */
    public ArrayList<Goal> getGoals(){ return goals; }

    /**
     * @return ArrayList of Categories from storage
     */
    public ArrayList<Category> getCategories(){ return categories; }

    /**
     * @return ArrayList of Goal String names
     */
    public ArrayList<String> getGoalNames(){
        ArrayList<String> goalList = new ArrayList<>();
        for(Goal g: goals){
            goalList.add(g.getName());
        }
        return goalList;
    }

    /**
     * @return ArrayList of Category String names
     */
    public ArrayList<String> getCategoryNames(){
        ArrayList<String> categoryList = new ArrayList<>();
        for(Category c: categories){
            categoryList.add(c.getName());
        }
        return categoryList;
    }

    /**
     * Writes to JSON file and closes filewriter from Box
     */
    public void close() throws IOException {
        box.close();
    }

    /**
     * Creates default Category objects and adds them to interface
     */
    private void populateDefaultCategories(){
        Category blank = new Category();
        Category fitness = new Category("Fitness", "This habit is meant to keep you active!");
        Category health = new Category("Health", "This habit is meant to keep you healthy!");
        Category productivity = new Category("Productivity", "This habit is meant to keep you productive!");

        add(blank);
        add(fitness);
        add(health);
        add(productivity);
    }

}
