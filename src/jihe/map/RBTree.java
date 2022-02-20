package jihe.map;

import java.io.FileFilter;

/**
 * @Title:
 * @author: Liu jiang
 * @Date: 2021-12-26 12:24
 * @FilePath: TextDemo  ==> RBTree
 * @Good Mood: Today is another beautiful day！
 * @Study Code: Did you study today？
 * 1、创建RBTree，定义颜色
 * 2、创建RBNode节点
 * 3、辅助方法的定义：parentof(node),isRed(node),isBlack(node),setRed(node),setBlack(node),inOrderPrint()
 * 4、左旋方法定义：leftRotate(node)
 * 5、右旋方法定义：rightRotate(node)
 * 6、公开插入接口方法定义：insert(K key,V value)
 * 7、内部插入接口方法定义：insert(RBNode node)
 * 8、修正插入导致红黑树失衡的方法定义：insertFIxUp(RBNode node)
 * 9、测试红黑树正确性
 */
public class RBTree <K extends Comparable<K>,V>{
    private static final boolean RED = true ;
    private static final boolean BLACK = false ;
    // 树根的引用
    private RBNode root ;

    public RBNode getRoot() {
        return root;
    }

    /*@Title： 获取当前节点的父节点
     * @Author Liu jiang
     * @Date 16:19 2021/12/26
     * @Param RBNode
     * @return  RBNode
     **/
    private RBNode parentof (RBNode node){
        if(node != null){
            return node.parent;
        }
        return null ;
    }

    /*@Title： 判断节点是否为红色
     * @Author Liu jiang
     * @Date 16:22 2021/12/26
     * @Param RBNode
     * @return Boolean
     **/
    private Boolean isRed (RBNode node){
        if(node != null){
            return node.color == RED;
        }
        return false;
    }
    /*@Title： 判断节点是否为黑色
     * @Author Liu jiang
     * @Date 16:25 2021/12/26
     * @Param RBNode
     * @return Boolean
     **/
    private Boolean isBlack (RBNode node){
        if(node != null){
            return node.color == BLACK;
        }
        return false ;
    }
    /*@Title： 设置节点为红色
     * @Author Liu jiang
     * @Date 16:27 2021/12/26
     * @Param RBNode
     * @return
     **/
    private void setRed(RBNode node){
        if(node != null){
            node.color = RED;
        }
    }

    /*@Title： 设置节点为黑色
     * @Author Liu jiang
     * @Date 16:27 2021/12/26
     * @Param RBNode
     * @return
     **/
    private void setBlack(RBNode node){
        if(node != null){
            node.color = BLACK;
        }
    }

    /*@Title： 中序打印树结构
     * @Author Liu jiang
     * @Date 16:30 2021/12/26
     * @Param
     * @return
     **/
    private void inOrderPrint(){
        inOrderPrint(this.root);
    }
    private void inOrderPrint(RBNode node){
        if(node != null){
            inOrderPrint(node.left);
            System.out.println("key:" + node.key + "      value:" + node.value);
            inOrderPrint(node.right);
        }
    }

    /*@Title： 左旋操作：（旋转节点是指插入节点的祖父节点）
     * 以某个节点为支点（旋转节点），其右节点变为旋转节点的父节点，右子节点的左子节点变为旋转节点的右子节点，左子节点保持不变
     * @Author Liu jiang
     * @Date 16:37 2021/12/26
     * @Param
     * @return
     * 示意图：
     *      p               p
     *      |               |
     *      x               y
     *     / \     ===>    / \
     *    lx  y           x   ry
     *       / \         / \
     *      ly  ry      lx  ly
     *
     * 1、将x的右子节点指向y的左子节点（ly）,将y的左子节点（ly）的父节点更新为x
     * 2、当x的父节点（不为空的时）更新y的父节点为x的父节点，并将x的父节点指定  子树（当前x子树位置）指定为y，为空的话则更新树根为y
     * 3、将x的父节点更新为y，将y的左子节点更新为x
     **/
    private void leftRotate (RBNode x){
        RBNode y = x.right ;
        //1、将x的右子节点指向y的左子节点（ly）,将y的左子节点（ly）的父节点更新为x
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }

        //2、当x的父节点（不为空的时）更新y的父节点为x的父节点，并将x的父节点指定  子树（当前x子树位置）指定为y
        if(x.parent != null){
            y.parent = x.parent;
            if(x == x.parent.left){
                x.parent.left = y ;
            }else{
                x.parent.right = y ;
            }
        }else{  //如果x的父节点为null，则说明当前x节点为root节点，则更新树根为y
            this.root = y;
            this.root.parent = null ;
        }

        //3、将x的父节点更新为y，将y的左子节点更新为x
        x.parent = y;
        y.left = x;
    }
        
    /*@Title： 右旋操作：（旋转节点是指插入节点的祖父节点）
     * 以某个节点为支点（旋转节点），其左子节点为旋转节点的父节点，左子节点右子节点变为旋转节点的左子节点，右子节点保持不变
     * @Author Liu jiang
     * @Date 17:27 2021/12/26
     * @Param 
     * @return
     * 示意图：
     *      p               p
     *      |               |
     *      y               x
     *     / \     ===>    / \
     *    x  ry           lx  y
     *   / \                 / \
     *  lx  ly              ly  ry
     *
     * 1、将y的左子节点指向x的右子节点，并且更新x的右子节点的父节点为y
     * 2、当y的父节点（不为空时）更新x的父节点为y的父节点，并将y的父节点指定 子树（当前y的位置）为x，如果为空则更新树根为x
     * 3、将y的父节点指向x，更新x的右子树指向y
     *
     **/
    private void rightRotate (RBNode y){
        RBNode x = y.left ;
        // 1、将y的左子节点指向x的右子节点，并且更新x的右子节点的父节点为y
        y.left = x.right ;
        if(x.right != null){
            x.right.parent = y;
        }

       // 2、当y的父节点（不为空时）更新x的父节点为y的父节点，并将y的父节点指定 子树（当前y的位置）为x，如果为空则更新树根为x
        if(y.parent !=null){
            x.parent = y.parent ;
            if(y == y.parent.right){
                y.parent.right = x;
            }else{
                y.parent.left  = x;
            }
        }else{
            this.root = x ;
            this.root.parent = null ;
        }

        //3、将y的父节点指向x，更新x的右子树指向y
        y.parent = x;
        x.right = y ;
    }

    /*@Title： 对外的公开插入方法
     * @Author Liu jiang
     * @Date 22:35 2021/12/26
     * @Param
     * @return
     **/
    public void insert(K key , V value ){
        //创建插入节点对象，默认颜色为红色
        RBNode  node= new RBNode();
        node.setKey(key);
        node.setValue(value);
        node.setColor(RED);
        insert(node);
    }

    /*@Title： 内部插入方法
     * @Author Liu jiang
     * @Date 22:38 2021/12/26
     * @Param
     * @return
     **/
    public void insert(RBNode  node){



        //第一步：找到当前node节点的父节点
        RBNode parent = null ;
        RBNode x = this.root ;
        while(x != null){
            parent = x ;
            /*
            cmp > 0 说明node.key 大于 x.key 需要到x的右子树查找
            cmp = 0 说明node.key 等于 x.key 需要用node节点替换x节点
            cmp < 0 说明node.key 小于 x.key 需要到x的左子树查找
            */
            int cmp = node.key.compareTo(x.key);
            if(cmp > 0){
                x = x.right;
            }else if(cmp == 0 ){
                x.setValue(node.getValue());
                return ;
            }else{
                x = x.left;
            }
        }
        //找到node的父节点后进行插入操作
        node.parent = parent;
        if(parent != null){
            //判断node插入在parent节点的左边还是右边
            int cmp = node.key.compareTo(parent.key);
            if(cmp > 0){
                //插入的node节点比父节点大，插入到右边
                parent.right = node ;
            }else{
                //插入的node节点比父节点小，插入左边
                parent.left = node ;
            }
        }else{
            //如果根节点为空，直接插入到跟节点
            this.root = node;
        }
        //判断红黑树是否平衡
        insertFIxUp(node);

    }

    /*@Title：插入节点后平衡红黑树
     * @Author Liu jiang
     * @Date 23:00 2021/12/26
     * @Param
     * @return
     *平衡红黑树的方法：
     *      |---情景1：红黑树为空树，将根节点该成黑色
     *      |---情景2：插入节点key已经存在不需要处理
     *      |---情景3：插入节点的父节点为黑色，因为你所插入的路径没有变化，黑色节点没有变化，所以红黑树依然平衡，所以不需要处理
     *      |---情景4：插入节点的父节点为红色
     *          |---情景4.1：叔叔节点存在，并且为红色（父-叔 双红），将爸爸和叔叔染成黑色，将爷爷节点染成红色，并且以爷爷节点为当前节点进行下一轮处理
     *          |---情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
     *              |---情景4.2.1：插入节点为父节点的左子节点（LL情况），将爸爸染色为黑色，爷爷染色为红色，然后爷爷进行右旋就完成了
     *              |---情景4.2.2：插入节点为父节点的右子节点（LR情况），将爸爸节点进行一次左旋，得到LL双红的情景（4.2.1），然后指定爸爸节点为当前节点进行下一步处理
     *          |---情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
     *              |---情景4.3.1：插入节点为父节点的右子节点（RR情况），将爸爸染色为黑色，将爷爷染色为红色，然后爷爷进行左旋就完成了
     *              |---情景4.3.2：插入节点为父节点的左子节点（RL情况），将爸爸节点进行一次右旋，得到RR双红的情景（4.3.1），然后指定爸爸节点为当前节点进行下一步处理
     *
     **/
    private void insertFIxUp(RBNode node ){
        //情景1：红黑树为空树，将根节点该成黑色
        this.root.setColor(BLACK);

        RBNode parent = parentof(node);//父节点
        RBNode gparent = parentof(parent);//爷爷节点
        //情景4：插入节点的父节点为红色
        if(parent != null && isRed(parent)){
            //如果父节点是红色，那么一定一定存在爷爷节点，因为根节点不可能是红色
            RBNode uncle = null ; //叔叔节点
            if(parent == gparent.left){ //父节点为爷爷节点的左子树
                uncle = gparent.right;
                //情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                if(uncle != null && isRed(uncle)){
                    // 将爸爸和叔叔染成黑色，将爷爷节点染成红色，并且以爷爷节点为当前节点进行下一轮处理
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFIxUp(gparent);
                    return ;
                }
                //情景4.2：叔叔节点不存在，或者为黑色，父节点为爷爷节点的左子树
                if(uncle == null || isBlack(uncle)){
                    //情景4.2.1：插入节点为父节点的左子节点（LL情况），将爸爸染色为黑色，爷爷染色为红色，然后爷爷进行右旋就完成了
                    if(node == parent.left){
                        setBlack(parent);
                        setRed(gparent);
                        rightRotate(gparent);
                        return ;
                    }else{
                        //情景4.2.2：插入节点为父节点的右子节点（LR情况），将爸爸节点进行一次左旋，得到LL双红的情景（4.2.1），然后指定爸爸节点为当前节点进行下一步处理
                        leftRotate(parent);
                        insertFIxUp(parent);
                        return ;
                    }


                }

            }else{//父节点为爷爷节点的右子树
                uncle = gparent.left;
                //情景4.1：叔叔节点存在，并且为红色（父-叔 双红）
                if(uncle != null && isRed(uncle)){
                    // 将爸爸和叔叔染成黑色，将爷爷节点染成红色，并且以爷爷节点为当前节点进行下一轮处理
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    insertFIxUp(gparent);
                    return ;
                }

                //情景4.3：叔叔节点不存在，或者为黑色，父节点为爷爷节点的右子树
                if (uncle == null || isBlack(uncle)) {
                    //情景4.3.1：插入节点为父节点的右子节点（RR情况）
                    if(node == parent.right){
                        //将爸爸染色为黑色，将爷爷染色为红色，然后爷爷进行左旋就完成了
                        setBlack(parent);
                        setRed(gparent);
                        leftRotate(gparent);
                        return ;
                    }else{
                        //情景4.3.2：插入节点为父节点的左子节点（RL情况），将爸爸节点进行一次右旋，得到RR双红的情景（4.3.1），然后指定爸爸节点为当前节点进行下一步处理
                        rightRotate(parent);
                        insertFIxUp(gparent);
                        return ;
                    }
                }
            }

        }

    }





    //创建存储数据的节点类
    static class RBNode<K extends  Comparable<K>,V>{
        //定义节点属性
        private RBNode parent ;  //父节点
        private RBNode left ;
        private RBNode right ;
        private Boolean color;
        private K key;
        private V value;
        //定义节点构造方法，get，set方法，toString方法
        public RBNode(RBNode parent, RBNode left, RBNode right, Boolean color, K key, V value) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.color = color;
            this.key = key;
            this.value = value;
        }
        public RBNode(){

        }

        public RBNode getParent() {
            return parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public RBNode getRight() {
            return right;
        }

        public Boolean getColor() {
            return color;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public void setColor(Boolean color) {
            this.color = color;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
        // 判断节点颜色是否为红色
      public Boolean isColor(){
           return  this.color == RED ;
        }
    }
}
