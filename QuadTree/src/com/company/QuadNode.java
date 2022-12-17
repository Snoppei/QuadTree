package com.company;

import java.util.LinkedList;

public class QuadNode {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int cntrx;
    private int cntry;
    private int treeDepth;

    private QuadNode nw;
    private QuadNode ne;
    private QuadNode sw;
    private QuadNode se;

    private LinkedList<Box> aabbs;

    public QuadNode(int x1, int y1, int x2, int y2, int treeDepth) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cntrx = (x1 + x2) / 2;
        this.cntry = (y1 + y2) / 2;
        this.treeDepth = treeDepth;
        aabbs = new LinkedList<>();
    }

    public QuadNode getNw() {
        return nw;
    }

    public void setNw(QuadNode nw) {
        this.nw = nw;
    }

    public QuadNode getNe() {
        return ne;
    }

    public void setNe(QuadNode ne) {
        this.ne = ne;
    }

    public QuadNode getSw() {
        return sw;
    }

    public void setSw(QuadNode sw) {
        this.sw = sw;
    }

    public QuadNode getSe() {
        return se;
    }

    public void setSe(QuadNode se) {
        this.se = se;
    }

    public LinkedList<Box> getAabbs() {
        return aabbs;
    }

    public void setAabbs(LinkedList<Box> aabbs) {
        this.aabbs = aabbs;
    }

    public LinkedList<Box> getBoxes() {
        return (aabbs);
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getCntrx() {
        return cntrx;
    }

    public void setCntrx(int cntr_x) {
        this.cntrx = cntr_x;
    }

    public int getCntry() {
        return cntry;
    }

    public void setCntry(int cntr_y) {
        this.cntry = cntr_y;
    }

    public int getTreeDepth() {
        return treeDepth;
    }

    public void setTreeDepth(int tree_Depth) {
        this.treeDepth = tree_Depth;
    }
}