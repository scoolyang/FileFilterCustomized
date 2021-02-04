package com.codewithyscool;

import com.codewithyscool.FileFilter.*;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String dirPath = "S:/demo";      //user defined directory path
        String suffix = ".txt";          //user defined file name suffix
        int size = 10;                   //user defined file name size

        FileFilterNode root = generateRoot(suffix, size, new AndOperator());

        File filePath = new File(dirPath);
        
        if (validDir(filePath, dirPath)) {
            File[] files = filePath.listFiles();

            List<File> res = FileFilterProcessor.filterGo(files, new FilterTypeParam(root));

            for (File f : res)
                System.out.println(f.getName());
        }
    }

    private static FileFilterNode generateRoot(String s, int size, OperatorInterface combineType) {
        FileFilterInterface suffixFilter = new SuffixFileFilter(new FilterTypeParam(s));
        FileFilterInterface sizeFilter = new SizeFileFilter(new FilterTypeParam(size));
        return new FileFilterNode(new FileFilterNode(suffixFilter),        // build tree for test
                new FileFilterNode(sizeFilter), combineType);
    }
//
    private static boolean validDir(File filePath, String dirPath) {
        if (!filePath.exists()) {
            System.out.println(String.format("Given directory path %s does not exist", dirPath));
            return false;
        }
        if (!filePath.isDirectory()) {
            System.out.println(String.format("Given value %s is not a valid directory", dirPath));
            return false;
        }
        return true;
    }
}
