package com.codewithyscool.FileFilter;

public class OrOperator implements OperatorInterface {
    @Override
    public boolean check(boolean left, boolean right) {
        return left || right;
    }
}