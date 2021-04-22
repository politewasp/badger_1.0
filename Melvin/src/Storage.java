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

    // interface attributes
    ArrayList<Goal> goals;
    ArrayList<Category> categories;
    Box box;

    private Storage() {
        box = Box.load();
        goals = box.getGoals();
        categories = box.getCategories();
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
        box.close();
    }

}
