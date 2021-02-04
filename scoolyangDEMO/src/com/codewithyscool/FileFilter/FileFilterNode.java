package com.codewithyscool.FileFilter;

public class FileFilterNode {
    OperatorInterface operator;
    FileFilterInterface filter;
    FileFilterNode left;
    FileFilterNode right;

    public FileFilterNode(FileFilterNode leftC, FileFilterNode rightC, OperatorInterface oper) {
        this.operator = oper;
        if (leftC != null)
            this.left = leftC;
        if (rightC != null)
            this.right = rightC;
    }

    public FileFilterNode(FileFilterInterface filter) {
        this.filter = filter;
        this.left = null;
        this.right = null;
        this.operator = null;
    }

    public boolean isOperatorNode() {
        return operator != null;
    }
}
