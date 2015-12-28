package com.atsebak.kernel.locale;

import com.intellij.BundleBase;
import com.intellij.reference.SoftReference;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.lang.ref.Reference;
import java.util.ResourceBundle;

public class KernelBundle {

    @NonNls
    private static final String BUNDLE = "com.atsebak.kernel.locale.KernelBundle";
    private static Reference<ResourceBundle> ourBundle;

    /**
     * Private Constructor
     */
    private KernelBundle() {
    }

    /**
     * @param key
     * @param params
     * @return
     */
    public static String message(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, @NotNull Object... params) {
        return BundleBase.message(getBundle(), key, params);
    }

    /**
     * @return
     */
    private static ResourceBundle getBundle() {
        ResourceBundle bundle = com.intellij.reference.SoftReference.dereference(ourBundle);
        if (bundle == null) {
            bundle = ResourceBundle.getBundle(BUNDLE);
            ourBundle = new SoftReference<ResourceBundle>(bundle);
        }
        return bundle;
    }

    /**
     * @param key The Key
     * @return The Localized Text
     */
    public static String getString(@PropertyKey(resourceBundle = BUNDLE) final String key) {
        return getBundle().getString(key);
    }
}