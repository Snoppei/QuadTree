package com.company;

public class Box {


        private double x1;

        private double y1;

        private double x2;

        private double y2;

        private double width;

        private double hight;

        private double dx;

        private double dy;

        private Box nearby;

        public Box() {
            x1 = 0;
            y1 = 0;
            x2 = 50;
            y2 = 50;
            dx = 0;
            dy = 0;
            width = x2;
            hight = y2;
            nearby = null;
        }

        public Box(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dx = 0;
            this.dy = 0;
            this.width = x2 - x1;
            this.hight = y2 - y1;
            this.nearby = null;
        }

        public boolean collidesWith(Box aabb) {
            if (x1 > aabb.x2 || aabb.x1 > x2) {
                return (false);
            }

            if (y2 < aabb.y1 || aabb.y2 < y1) {
                return (false);
            }

            return (true);
        }

        public double getdx() {
            return (dx);
        }

        public double getdy() {
            return (dy);
        }

        public double getHeight() {
            return (hight);
        }

        public double getWidth() {
            return (width);
        }

        public double getX1() {
            return (x1);
        }

        public double getX2() {
            return (x2);
        }

        public double getY1() {
            return (y1);
        }

        public double getY2() {
            return (y2);
        }

        public Box getNearby() {
            return (nearby);
        }

        public void relocate(double delta_x, double delta_y) {
            x1 += delta_x;
            y1 += delta_y;
            x2 += delta_x;
            y2 += delta_y;
        }

        public void setdx(double dx) {
            this.dx = dx;
        }


        public void setdy(double dy) {
            this.dy = dy;
        }

        public void setNearby(Box nrby) {
            nearby = nrby;
        }

        public void setSize(double w, double h) {
            x2 = x1 + w;
            y2 = y1 + h;
            width = x2 - x1;
            hight = y2 - y1;
        }

        public void setVelocity(double deltax, double deltay) {
            this.dx = deltax;
            this.dy = deltay;
        }
}
