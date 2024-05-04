package strukdat;

public class Heap<K extends Comparable<? super K>,V>{
    TheArrayList<Gnode<K,V>> arrList;
    boolean priority;
    
    public Heap(int capacity, boolean priority){
        arrList = new TheArrayList<Gnode<K,V>>(capacity);
        this.priority = priority;
    }

    public int size(){
        return arrList.size();
    }

    public V getData(int index){
        return arrList.get(index).data;
    }

    public V getData(Gnode<K,V>node){
        return node.data;
    }

    public K getKey(int index){
        return arrList.get(index).key;
    }

    public K getKey(Gnode<K,V>node){
        return node.key;
    }

    public void add(K key, V data){
        arrList.add(new Gnode<K,V>(key,data));
    }

    public void insert(K key, V data){
        arrList.add(new Gnode<K,V>(key,data));
        int size = arrList.size();
        for(int i = size / 2-1; i >= 0; i = (i + 1)/2 - 1){
            if(priority) heapifyMin(size, i);
            else heapifyMax(size, i);
        }
    }

    public void buildHeap(){
        int size = arrList.size();
        for(int i = size / 2-1; i >= 0; i--){
            if(priority) heapifyMin(size, i);
            else heapifyMax(size, i);
        }
    }

    void heapifyMax(int size, int i){
        int parent = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left<size && arrList.get(left).key.compareTo(arrList.get(parent).key)>0)
            parent = left;
        if(right<size && arrList.get(right).key.compareTo(arrList.get(parent).key)>0)
            parent = right;
        if(parent != i){
            Gnode<K,V> temp = arrList.get(i);
            arrList.set(i, arrList.get(parent));
            arrList.set(parent, temp);
            heapifyMax(size, parent);
        }
    }

    public void sort(){
        int size = arrList.size();
        buildHeap();

        for(int i = size - 1; i > 0; i--){
            Gnode<K, V> temp = arrList.get(0);
            arrList.set(0, arrList.get(i));
            arrList.set(i, temp);

            size --;
    
            if(priority)
                heapifyMin(size, 0);
            else
                heapifyMax(size, 0);
        }
    }

    void heapifyMin(int size, int i){
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left<size && arrList.get(left).key.compareTo(arrList.get(smallest).key)>0)
            smallest = left;
        if(right<size && arrList.get(right).key.compareTo(arrList.get(smallest).key)>0)
            smallest = right;
        if(smallest != i){
            Gnode<K,V> temp = arrList.get(i);
            arrList.set(i, arrList.get(smallest));
            arrList.set(smallest, temp);
            heapifyMin(size, smallest);
        }
    }

    public Gnode<K,V> first(){
        if (arrList.isEmpty()){
            return null;
        }
        return arrList.get(0);
    }

    public Gnode<K,V> removeFirst(){
        if (arrList.isEmpty()) {
            return null;
        }
    
        Gnode<K,V> root = arrList.get(0);
    
        arrList.set(0, arrList.get(arrList.size() - 1));

        arrList.remove(arrList.size() - 1);
    
        if (priority)
            heapifyMin(arrList.size(), 0);
        else
            heapifyMax(arrList.size(), 0);
    
        return root;
    }

    public void display(){
        arrList.cetakList();
    }
}