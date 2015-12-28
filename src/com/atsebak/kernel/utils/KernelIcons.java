package com.atsebak.kernel.utils;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public class KernelIcons {
    public static final Icon Linux = load("/linux.png");

    private static Icon load(String path) {
        return IconLoader.getIcon(path);
    }

}