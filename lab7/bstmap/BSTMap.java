package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap <k extends Comparable<k>,v> implements Map61B<k,v> {


    public class node {
        public k key;
        public v value;
        public node left, right;

        public node(k key, v value, node left, node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private node sentinel;
    private int size;

    @Override
    public void clear() {
        sentinel=new node(null,null,null,null);
        sentinel.right=sentinel;
        sentinel.left=sentinel;
        size=0;
    }

    @Override
    public boolean containsKey(k key) {
       node temp = sentinel.right;
       while (temp != sentinel){
           if(key.compareTo(temp.key)==0)
               return true;
           if(key.compareTo(temp.key)>0)
               temp = temp.left;
           else
               temp = temp.right;
       }
       return false;
    }

    @Override
    public v get(k key) {
        node temp = sentinel.right;
        if(temp == sentinel)
            temp.key = key;
        while (temp != sentinel){
            if(key.compareTo(temp.key)==0)
                return temp.value;
            if(key.compareTo(temp.key)>0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(k key, v value) {
        node temp = sentinel.right;
        if (sentinel == temp) {
            sentinel.right=new node(key,value,sentinel,sentinel);
            size++;
            return;
        }
        while (true){
            if (key.compareTo(temp.key) == 0) {
                temp.value=value;
                return;
            }
            if (key.compareTo(temp.key) > 0) {
                if(temp.right==sentinel){
                    temp.right=new node(key,value,sentinel,sentinel);
                    size++;
                    return;
                }
                else {
                    temp = temp.right;
                }
            } else {
                if(temp.left==sentinel){
                    temp.left=new node(key,value,sentinel,sentinel);
                    size++;
                    return;
                }
                else {
                    temp = temp.left;
                }
            }
        }
    }

    @Override
    public Set<k> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public v remove(k key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public v remove(k key, v value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<k> iterator() {
        throw new UnsupportedOperationException();
    }
}
