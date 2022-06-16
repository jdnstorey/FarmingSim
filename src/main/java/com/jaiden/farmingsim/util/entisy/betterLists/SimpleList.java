package com.jaiden.farmingsim.util.entisy.betterLists;

import com.jaiden.farmingsim.util.entisy.FileHelper;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SimpleList<T> {

    public static final SimpleList EMPTY = new SimpleList();
    private static SimpleList instance;
    private List<T> list;

    public SimpleList() {
        list = new ArrayList<>();
        instance = this;
    }

    @SuppressWarnings("unchecked")
    public SimpleList(T... objects) {
        this();
        list.addAll(Arrays.asList(objects));
    }

    public SimpleList(Supplier<T> sup) {
        //TODO:
    }

    public static SimpleList<String> createStringList(File file, char splitCharacter) {
        return new SimpleList<>(FileHelper.readContent(file).split(splitCharacter + ""));
    }

    public static SimpleList<String> createStringList(String... s) {
        return new SimpleList<>(s);
    }

    public static SimpleList convert(List o) {
        o.forEach(l -> instance.list.add(l));
        return instance;
    }

    @SuppressWarnings("unchecked")
    public void append(T... objects) {
        list.addAll(Arrays.asList(objects));
    }

    @SuppressWarnings("unchecked")
    public void remove(T... objects) {
        list.removeAll(Arrays.asList(objects));
    }

    public void remove(int index) {
        list.remove(index);
    }

    public boolean contains(T object) {
        return list.contains(object);
    }

    @SuppressWarnings("unchecked")
    public T[] get() {
        return (T[]) Array.newInstance(list.get(0).getClass(), list.size());
    }

    public List<T> list() {
        return list;
    }

    public boolean isEmpty() {
        return list.size() <= 0;
    }

    public int size() {
        return list.size();
    }

    public boolean matches(Object x) {
        return list.stream().anyMatch(p -> p.equals(x));
    }

    public T get(int index) {
        return list.get(index);
    }

    public void forEach(Consumer<? super T> e) {
        for (T t : list) {
            e.accept(t);
        }
    }
}
