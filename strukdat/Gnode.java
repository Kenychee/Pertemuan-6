package strukdat;

public class Gnode<K,V>{
    K key;
    V data;
    Gnode<K,V> llink;
    Gnode<K,V> rlink;

    public Gnode(K k, V data) {
        this.key = k;
        this.data = data;
        llink = null;
        rlink = null;
    }


    @Override
    public String toString(){
        return(key.toString() + ":" + data.toString() + " ");
    }
}