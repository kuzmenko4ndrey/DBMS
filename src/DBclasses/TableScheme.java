/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBclasses;

import DBclasses.TableRow.Cell;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Neophron
 */
public class TableScheme {

    private static class SchemeElement<T> {

        String name;
        String type;
        T dummy = null;

        private SchemeElement(String name, String type) {
            this.name = name;
            this.type = type;
        }

        protected Cell<T> getCell() {
            return new Cell();
        }

        private SchemeElement<T> getClone() {
            return new SchemeElement<>(name, type);
        }
    }

    protected boolean classCastChecker(Object o, int n) {
        try {
            if (header.get(n).type.equals("Double")) {
                Double t = (Double) o;
            }
            if (header.get(n).type.equals("Integer")) {
                Integer t = (Integer) o;
            }
            if (header.get(n).type.equals("Character")) {
                Character t = (Character) o;
            }
            if (header.get(n).type.equals("String")) {
                String t = (String) o;
            }
            if (header.get(n).type.equals("Picture")) {
                Picture t = (Picture) o;
            }
            return true;
        } catch (ClassCastException ex) {
            return false;
        }
    }

    private final ArrayList<SchemeElement> header = new ArrayList<>();

    protected void addDouble(String name) {
        SchemeElement<Double> c = new SchemeElement<>(name, "Double");
        header.add(c);
    }

    protected void addInt(String name) {
        SchemeElement<Integer> c = new SchemeElement<>(name, "Integer");
        header.add(c);
    }

    protected void addChar(String name) {
        SchemeElement<Character> c = new SchemeElement<>(name, "Character");
        header.add(c);
    }

    protected void addString(String name) {
        SchemeElement<String> c = new SchemeElement<>(name, "String");
        header.add(c);
    }

    protected void addPic(String name) {
        SchemeElement<Picture> c = new SchemeElement<>(name, "Picture");
        header.add(c);
    }

    protected TableRow createRow() {
        ArrayList<Cell> c = new ArrayList<>();
        for (int i = 0; i < header.size(); i++) {
            c.add(header.get(i).getCell());
        }
        TableRow r = new TableRow(c, this);
        return r;
    }

    protected Table createTable(String tname) {
        TableScheme s = new TableScheme();
        for (SchemeElement el : header) {
            s.header.add(el.getClone());
        }
        Table t = new Table(tname, s);
        return t;
    }

    @Override
    public boolean equals(Object o) {
        try {
            TableScheme ts = (TableScheme) o;
            for (int i = 0; i < Math.min(header.size(), ts.header.size()); i++) {
                if (!header.get(i).type.equals(ts.header.get(i).type)) {
                    return false;
                }
            }
            return header.size() == ts.header.size();
        } catch (ClassCastException ex) {
            return false;
        }
    }

}
