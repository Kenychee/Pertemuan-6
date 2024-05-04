package strukdat;

public class BinaryTree<K,V> {
    
    public void printInOrder(Gnode<K,V> node){
        if(node==null) return;
        else {
            printInOrder(node.llink);
            System.out.print(node + " ");
            printInOrder(node.rlink);
        }
    }

    public void printPostOrder(Gnode<K,V> node){
        if(node == null) return;
        else{
            printPostOrder(node.llink);
            printPostOrder(node.rlink);
            System.out.print(node + " ");
        }
    }

    public void printPreOrder(Gnode<K,V> node){
        if(node == null) return;
        else{
            System.out.print(node + " ");
            printPreOrder(node.llink);
            printPreOrder(node.rlink);
        }
    }

    private void printLevelOrderRec(SingleList<Gnode<K,V> > q){
        if(q.isEmpty()) return;
        Gnode<K,V> node = q.remove();

        System.out.print(node + " ");
        if(node.llink != null) q.pushQ(node.llink);
        if(node.rlink != null) q.pushQ(node.rlink);
        printLevelOrderRec(q);
    }

    public void printLevelOrder(Gnode<K,V> node){
        SingleList<Gnode<K,V>>q = new SingleList<Gnode<K,V>>();
        q.pushQ(node);
        printLevelOrderRec(q);
    }
}
