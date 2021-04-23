/**
 *  <h1>Category</h1>
 *  Category object to classify Goal
 *  Contains a name and description
 *  Written Using Java 15
 *  @author Maraiah Matson
 *  @version 1.1
 *  @since 2021-04-15
 */

public class Category {
    String name;
    String description;
    String imageLink;

    /**
     * Category Constructor initializes default values
     * for Category object
     * Default name is "misc"
     */
    public Category(){
        this.name = "misc";
        this.description = "uncategorized";
        this.imageLink = "none";
    }

    /**
     * Alternate Constructor where name can be input
     * as constructor parameter
     * @param name String name
     */
    public Category(String name){
        this.name = name;
        this.description = "none";
        this.imageLink = "none";
    }

    /**
     * Alternate Constructor where name and description can be input
     * as constructor parameter
     * @param name String name
     * @param description String description
     */
    public Category(String name, String description){
        this.name = name;
        this.description = description;
        this.imageLink = "none";
    }

    public Category(String name, String description, String imageLink){
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
    }

    /**
     * Sets name attribute
     * @param name String name
     */
    public void setName(String name){ this.name = name; }

    /**
     * Sets description attribute
     * @param description String description
     */
    public void setDescription(String description){ this.description = description; }

    public void setImageLink(String imageLink){ this.imageLink = imageLink; }

    /**
     * Gets name attribute
     * @return String name
     */
    public String getName(){ return name; }

    /**
     * Gets description attribute
     * @return String description
     */
    public String getDescription(){ return description; }

    public String getImageLink(){ return imageLink; }

    public void uploadImage(){

    }

    /**
     * Compares two categories by name to check if they are the same
     * @see Storage also to check if name is already taken when adding
     * a new category
     * @param c a different Category object
     * @return boolean
     */
    public boolean equals(Category c) {
        return this.getName().equals(c.getName());
    }
}
