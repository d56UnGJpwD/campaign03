package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.traversals.PreOrderTraversal;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;


public abstract class AbstractBinaryTree<E> implements Tree<E>, BinaryTree<E>
{
    //some of my functions messed up, so they are in a slightly different format than that of the interfaces

    public static class BinaryTreeNode<E> implements Node<E>
    {
        private E element;
        private BinaryTreeNode<E> parent;
        private BinaryTreeNode<E> left;
        private BinaryTreeNode<E> right;

        //Binary tree node class, similar to regular singularly linked node classes
        //except they have a parent instead of a next
        public BinaryTreeNode(E element, BinaryTreeNode<E> parent, BinaryTreeNode<E> left, BinaryTreeNode<E> right)
        {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }


        @Override
        public E getElement()
        {
            return element;
        }

        @Override
        public void setElement(E element) throws IllegalArgumentException
        {
            if(element == null)
            {
                throw new IllegalArgumentException();
            }
            this.element = element;
        }

        @Override
        public Node<E> getParent()
        {
            return parent;
        }

        public void setParent(BinaryTreeNode<E> p)
        {
            parent = p;
        }

        public BinaryTreeNode<E> getLeft()
        {
            return left;
        }

        public void setLeft(BinaryTreeNode<E> left)
        {
            this.left = left;
        }

        public BinaryTreeNode<E> getRight()
        {
            return right;
        }

        public void setRight(BinaryTreeNode<E> right)
        {
            this.right = right;
        }
    }


    protected BinaryTreeNode<E> root;
    protected int size;


    protected BinaryTreeNode<E> createNode(E element, BinaryTreeNode<E> parent, BinaryTreeNode<E> left, BinaryTreeNode<E> right) throws IllegalArgumentException
    {
        if(element == null)
        {
            throw new IllegalArgumentException();
        }
        return new BinaryTreeNode<>(element, parent, left, right);
    }
    //returns the node child to the left of the provided node
    @Override
    public Node<E> left(Node<E> parent) throws IllegalArgumentException
    {
        validate(parent);
        return ((BinaryTreeNode<E>) parent).getLeft();
    }
    //returns the node child to the right
    @Override
    public Node<E> right(Node<E> parent) throws IllegalArgumentException
    {
        validate(parent);
        return ((BinaryTreeNode<E>) parent).getRight();
    }
    //chekcs if the parent, which I poorly named grandP in my infinite wisdom, returns a sibling of the parent node if it exists
    @Override
    public Node<E> sibling(Node<E> parent) throws IllegalArgumentException
    {
        validate(parent);

        BinaryTreeNode<E> grandP = (BinaryTreeNode<E>) parent.getParent();
        if(grandP.getRight() == parent)
        {
            return grandP.getLeft();
        }
        return grandP.getRight();
    }
    //adds to the left of the root
    @Override
    public Node<E> addLeft(Node<E> parent, E element) throws IllegalArgumentException
    {
        validate(parent);

        if(element == null || ((BinaryTreeNode<E>)parent).getLeft() != null)
        {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode<E> BTNode = createNode(element, (BinaryTreeNode<E>) parent, null, null);
        BTNode.setElement(element);
        BTNode.setParent((BinaryTreeNode<E>) parent);
        ((BinaryTreeNode<E>) parent).setLeft(BTNode);
        return ((BinaryTreeNode<E>) parent).getLeft();
    }
    //adds to the right of the root
    @Override
    public Node<E> addRight(Node<E> parent, E element) throws IllegalArgumentException
    {

        validate(parent);

        if(element == null || ((BinaryTreeNode<E>)parent).getRight() != null)
        {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode<E> BTNode = createNode(element, (BinaryTreeNode<E>) parent, null, null);
        BTNode.setElement(element);
        BTNode.setParent((BinaryTreeNode<E>) parent);
        ((BinaryTreeNode<E>) parent).setRight(BTNode);
        return ((BinaryTreeNode<E>) parent).getRight();
    }

    //validate handles the error checking so it needs to be ran at the start of every function
    @Override
    public Node<E> validate(Node<E> p) throws IllegalArgumentException
    {
        if(p == null || p.getClass() != BinaryTreeNode.class)
        {
            throw new IllegalArgumentException();
        }

        Node<E> current = p;

        while(current.getParent() != null)
        {
            current = current.getParent();
        }

        if(current != root)
        {
            throw new IllegalArgumentException();
        }

        return p;
    }
    //sets the starting node of the tree
    @Override
    public Node<E> setRoot(E item)
    {
        if(item == null)
        {
            size = 0;
            return null;
        }

        root = createNode(item, null, null, null);
        size++;

        return root;
    }
    //returns the parent node of the provided node
    @Override
    public Node<E> parent(Node<E> p) throws IllegalArgumentException
    {
        validate(p);

        return p.getParent();
    }
    //does nothing except return null at this point
    @Override
    public Iterable<Node<E>> children(Node<E> parent) throws IllegalArgumentException
    {
        //wip
        validate(parent);
        return null;
    }
    //traverses to the parent and gets the count of its children, we dont count the parent
    @Override
    public int numChildren(Node<E> parent) throws IllegalArgumentException
    {
        validate(parent);
        size = 0;

        PreOrderTraversal<E> traversal = new PreOrderTraversal<>(this);

        traversal.setCommand(new TraversalCommand()
        {
            @Override
            public void execute(Tree tree, Node node)
            {
                size++;
            }
        });

        traversal.traverseFrom(parent);
        return size - 1;
    }
    //returns the root
    @Override
    public Node<E> root()
    {
        return root;
    }
    //tests whether the node has children
    @Override
    public boolean isInternal(Node<E> p) throws IllegalArgumentException
    {
        validate(p);
        //might need to swap
        if(((BinaryTreeNode<E>) p).getLeft() == null && ((BinaryTreeNode<E>) p).getRight() == null)
        {
            return true;
        }
        return false;
    }
    //tests whether the node does not have children
    @Override
    public boolean isExternal(Node<E> p) throws IllegalArgumentException
    {
        validate(p);
        //might need to swap
        if(((BinaryTreeNode<E>) p).getLeft() == null && ((BinaryTreeNode<E>) p).getRight() == null)
        {
            return true;
        }
        return false;
    }
    //checks if it is the root
    @Override
    public boolean isRoot(Node<E> p) throws IllegalArgumentException
    {
        validate(p);
        if(p == root)
        {
            return true;
        }
        return false;
    }

    //inserts the item into as a child of the provided node
    @Override
    public Node<E> insert(E item, Node<E> p) throws IllegalArgumentException
    {
        validate(p);

        if(item == null)
        {
            throw new IllegalArgumentException();
        }

        BinaryTreeNode<E> BTNode = (BinaryTreeNode<E>) p;

        if(BTNode.getLeft() == null)
        {
            return addLeft(p, item);
        }
        if(BTNode.getRight() == null)
        {
            return addRight(p, item);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
    //removes the given item from the parent node
    @Override
    public boolean remove(E item, Node<E> p) throws IllegalArgumentException
    {
        validate(p);
        if(p.getParent() == null)
        {
            throw new IllegalArgumentException();
        }
        BinaryTreeNode<E> BTNode = (BinaryTreeNode<E>) p;

        if(BTNode.getRight().getElement() == item)
        {
            BTNode.setRight(null);
            return true;
        }
        if(BTNode.getLeft().getElement() == item)
        {
            BTNode.setLeft(null);
            return true;
        }
        return false;
    }
    //returns size of the tree
    @Override
    public int size()
    {
        size = 0;
        PreOrderTraversal<E> traversal = new PreOrderTraversal<>(this);
        traversal.setCommand(new TraversalCommand()
        {
            @Override
            public void execute(Tree tree, Node node)
            {
                size++;
            }
        });

        traversal.traverse();
        return size;
    }
    //returns true if the tree is empty
    @Override
    public boolean isEmpty()
    {
        if(root == null)
        {
            return true;
        }
        return false;
    }
    //changes the provided nodes value to the provided element
    @Override
    public E set(Node<E> node, E element) throws IllegalArgumentException
    {
        validate(node);
        if(element == null)
        {
            throw new IllegalArgumentException();
        }
        node.setElement(element);
        return null;
    }

    //just returns 0 at this point
    @Override
    public int depth(Node<E> node) throws IllegalArgumentException
    {
        return 0;
    }
    //gets the size of the subtree where the root is the provided node
    @Override
    public int subTreeSize(Node<E> node) throws IllegalArgumentException
    {
        validate(node);
        size = 0;
        PreOrderTraversal<E> traversal = new PreOrderTraversal<>(this);

        traversal.setCommand(new TraversalCommand()
        {
            @Override
            public void execute(Tree tree, Node node)
            {
                size++;
            }
        });
        traversal.traverseFrom(node);
        return size;
    }
    //unsupported
    @Override
    public boolean isLastChild(Node<E> node) throws IllegalArgumentException
    {
        throw new UnsupportedOperationException();
    }
}
