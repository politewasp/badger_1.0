import java.util.ArrayList;

/**
 * <h1>StoragePlaceholder</h1>
 *
 */
public class StoragePlaceholder {
    ArrayList<Goal> goals = new ArrayList<Goal>(100);
    public StoragePlaceholder(Integer amount){
        this.GenerateGoals(amount);
    }
    public void add(Goal newGoal){ goals.add(newGoal); }
    public void GenerateGoals(Integer amount){
        for(Integer i=0; i<amount; i++){
            goals.add(new Goal("Goal "+(i+1)));
        }
    }
}
