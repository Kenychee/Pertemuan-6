package strukdat;

public class BinarySearchTree<K extends Comparable<? super K>,V> extends BinaryTree<K,V> implements Tree<K,V>{ 
    private Gnode<K,V> root;

    public BinarySearchTree() {
    root= null;
    }

    public void insert(K key, V data){
        root = insertNode(root, key, data);
    }

    public void delete(K key){
        root = deleteNode(root,key);
    }

    public V search(K key){
        V info = null;
        info = getData(find(root,key));
        return info;
    }

    public K max(){
        K kunci = null;
        kunci = getKey(findMax(root));
        return kunci;
    }

    public K min(){
        K kunci = null;
        kunci = getKey(findMin(root));
        return kunci;
    }

    private Gnode<K,V> insertNode(Gnode<K,V>node, K k, V data){
        if(node == null){
            Gnode<K,V> newNode = new Gnode<K,V>(k, data);
            return newNode;
        }
        else if(k.compareTo(node.key) < 0){
            node.llink = insertNode(node.llink, k, data);
            return node;
        }
        else{
            node.rlink = insertNode(node.rlink, k, data);
            return node;
        }
    }

    private Gnode<K,V> deleteNode(Gnode<K,V> node, K k) {
        if (node == null) {
            return node;
        }
        if (k.compareTo(node.key) < 0) {
            node.llink = deleteNode(node.llink, k);
        } else if (k.compareTo(node.key) > 0) {
            node.rlink = deleteNode(node.rlink, k);
        } else {
            if (node.llink == null) {
                return node.rlink;
            } else if (node.rlink == null) {
                return node.llink;
            }
            node.key = findMax(node.llink).key;
            node.llink = deleteNode(node.llink, node.key);
        }
        return node;
    }
    
    private Gnode<K,V> find(Gnode<K,V> node, K k){
        if(node==null || node.key == k) return node;
        else if(node.key.compareTo(k) < 0) return find(node.rlink, k);
        else return find(node.llink, k);
    }

    private Gnode<K,V> findMin(Gnode<K,V> node) {
        if (node == null)
            return null;
    
        while (node.llink != null)
            node = node.llink;
    
        return node;
    }
    

    private Gnode<K,V> findMax(Gnode<K,V> node) {
        if (node == null)
            return null;
    
        while (node.rlink != null)
            node = node.rlink;
    
        return node;
    }
    

    public void inOrder(){
        printInOrder(root);
    }

    public void preOrder(){
        printPreOrder(root);
    }

    public void PostOrder(){
        printPostOrder(root);
    }

    public void LevelOrder(){
        printLevelOrder(root);
    }

    public K getKey(Gnode<K,V> node){
        return node.key;
    }

    public V getData(Gnode<K,V> node){
        return node.data;
    }
}