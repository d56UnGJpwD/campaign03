package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;

public class LinkedBinaryTree<E> implements BinaryTree<E>
{

    public static class BinaryTreeNode<E> implements Node<E>
    {
        private E element;
        private BinaryTreeNode<E> parent, left, right;



        @Override
        public E getElement()
        {
            return null;
        }

        @Override
        public void setElement(E element) throws IllegalArgumentException
        {

        }

        @Override
        public Node<E> getParent()
        {
            return null;
        }
    }


    @Override
    public Node<E> left(Node<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Node<E> right(Node<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Node<E> sibling(Node<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Node<E> addLeft(Node<E> p, E element) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Node<E> addRight(Node<E> p, E element) throws IllegalArgumentException
    {
        return null;
    }
}
