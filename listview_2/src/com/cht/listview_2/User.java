package com.cht.listview_2;

public class User 
{
	private String name;
	private String speak;
    private int image;
    public User(){}
    public User(String name,String speak, int image) {
        this.name = name;
        this.speak = speak;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getSpeak(){
    	return speak;
    }
    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSpeak(String speak){
    	this.speak = speak;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
             
