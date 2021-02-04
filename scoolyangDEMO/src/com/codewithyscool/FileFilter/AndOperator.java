package com.codewithyscool.FileFilter;

public class AndOperator implements OperatorInterface {
    @Override
    public boolean check(boolean left, boolean right) {
        return left && right;
    }
}
