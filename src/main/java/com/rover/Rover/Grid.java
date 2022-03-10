package com.rover.Rover;

import java.util.ArrayList;

public class Grid {

    private int width;
    private int depth;
    private ArrayList<Coordinates> scents = new ArrayList<Coordinates>();
    
    public Grid(int width, int depth){
        this.width = width;
        this.depth = depth;
    }

    public int getWidth(){
        return width;
    }

    public int getDepth(){
        return depth;
    }

    public void addScent(Coordinates coordinates){
        scents.add(coordinates);
    }

    public boolean hasScent(Coordinates coordinates){
        return scents.contains(coordinates);
    }
}
