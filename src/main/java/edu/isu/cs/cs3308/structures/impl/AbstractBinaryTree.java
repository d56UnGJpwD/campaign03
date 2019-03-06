package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.traversals.PreOrderTraversal;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

public abstract class AbstractBinaryTree<E> implements Tree<E>, BinaryTree<E>
{
    public static class BinaryTreeNode<E> implements Node<E>
    {
        private E element;
        private BinaryTreeNode<E> parent;
        private BinaryTreeNode<E> left;
        private BinaryTreeNode<E> right;

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

        public void setParent(BinaryTreeNode<E> parent)
        {
            this.parent = parent;
        }

        public Node<E> getLeft()
        {
            return left;
        }

        public void setLeft(BinaryTreeNode<E> left)
        {
            this.left = left;
        }

        public Node<E> getRight()
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





}
