package com.dgl.www.my.customView.animator;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator {
  
    @Override  
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        MyPoint startPoint = (MyPoint) startValue;
        MyPoint endPoint = (MyPoint) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());  
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        MyPoint point = new MyPoint(x, y);
        return point;  
    }  
  
}