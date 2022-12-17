package com.company;

import java.util.*;

public class QuadTree {

    private QuadNode root;

    private int maxTreeDepth;

    private Box[] allBoxes;

    public static final int SQUARE = 0;

    public static final int RECTANGULAR = 1;

    public QuadTree(Box[] aabbArray, int wdth, int hght, int mtd) {
        allBoxes = aabbArray;
        maxTreeDepth = mtd;

        reshape(wdth, hght);
    }

    public QuadNode buildQuadtree(int x1, int y1, int x2, int y2, int td) {
        QuadNode node = null;
        if (td <= maxTreeDepth) {
            node = new QuadNode(x1, y1, x2, y2, td);
            node.setNw(buildQuadtree(x1, y1, node.getCntrx(), node.getCntry(), td + 1));
            node.setNe(buildQuadtree(node.getCntrx(), y1, x2, node.getCntry(), td + 1));
            node.setSw(buildQuadtree(x1, node.getCntry(), node.getCntrx(), y2, td + 1));
            node.setSe(buildQuadtree(node.getCntrx(), node.getCntry(), x2, y2, td + 1));
        }
        return (node);
    }

    public Box[] getAllAABBs() {
        return (allBoxes);
    }

    public QuadNode getRoot() {
        return (root);
    }

    public void insert(QuadNode node) {
        LinkedList<Box> aabbs = node.getBoxes();
        if (node.getTreeDepth() < maxTreeDepth) {
            if (node.getBoxes().size() > 1) {
                for (Box aabb : aabbs) {
                    if (aabb.getY1() < node.getCntry()) {
                        if (aabb.getX1() < node.getCntrx()) {
                            if (node.getNw() != null) {
                                node.getNw().getBoxes().add(aabb);
                            }
                        }
                        if (aabb.getX2() > node.getCntrx()) {
                            if (node.getNe() != null) {
                                node.getNe().getBoxes().add(aabb);
                            }
                        }
                    }
                    if (aabb.getY2() > node.getCntry()) {
                        if (aabb.getX1() < node.getCntrx()) {
                            if (node.getSw() != null) {
                                node.getSw().getBoxes().add(aabb);
                            }
                        }
                        if (aabb.getX2() > node.getCntrx()) {
                            if (node.getSe() != null) {
                                node.getSe().getBoxes().add(aabb);
                            }
                        }
                    }
                }
                insert(node.getNw());
                insert(node.getNe());
                insert(node.getSw());
                insert(node.getSe());
            }
        } else {
            aabbs.forEach((aabb) -> {
                setNearby(aabbs, aabb);
            });
        }
    }

    private void resetQuadNodes(QuadNode node) {
        if (node != null) {
            if (!node.getBoxes().isEmpty()) {
                node.getBoxes().clear();
            }
            resetQuadNodes(node.getNw());
            resetQuadNodes(node.getNe());
            resetQuadNodes(node.getSw());
            resetQuadNodes(node.getSe());
        }
    }

    public void reshape(int wdth, int hght) {
        root = buildQuadtree(0, 0, wdth, hght, 0);
    }

    public void setAllAABBs(Box[] AABBs) {
        allBoxes = AABBs;
    }

    public void setMaxTreeDepth(int mtd) {
        if (maxTreeDepth != mtd) {
            maxTreeDepth = (mtd < 1 || mtd > 10) ? maxTreeDepth : mtd;
            root = buildQuadtree(root.getX1(), root.getY1(), root.getX2(), root.getY2(), 0);
            root.getBoxes().addAll(Arrays.asList(allBoxes));
        }
    }

    private void setNearby(LinkedList<Box> aabb_List, Box target) {
        for (Box aabb : aabb_List) {
            aabb.setNearby(target);
        }

    }

    public void update() {
        resetQuadNodes(root);
        root.getBoxes().addAll(Arrays.asList(allBoxes));
        for (Box aabb : allBoxes) {
            aabb.setNearby(null);
        }
        insert(root);
    }
}

