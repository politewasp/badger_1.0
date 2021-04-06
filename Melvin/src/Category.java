public class Category {
    String name;
    String description;
    String imageLink;

    public Category(){
        this.name = "tbd";
        this.description = "none";
        this.imageLink = "none";
    }

    public Category(String name){
        this.name = name;
        this.description = "none";
        this.imageLink = "none";
    }

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

    public void setName(String name){ this.name = name; }
    public void setDescription(String description){ this.description = description; }
    public void setImageLink(String imageLink){ this.imageLink = imageLink; }

    public String getName(){ return name; }
    public String getDescription(){ return description; }
    public String getImageLink(){ return imageLink; }

    public void uploadImage(){

    }

    public boolean equals(Category c) {
        return this.getName().equals(c.getName());
    }
}
