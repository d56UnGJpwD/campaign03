package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;

public class BinarySearchTree<E> implements BinaryTree<E>, Tree<E>
{
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

    @Override
    public Node<E> root()
    {
        return null;
    }

    @Override
    public Node<E> setRoot(E item)
    {
        return null;
    }

    @Override
    public Node<E> parent(Node<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Iterable<Node<E>> children(Node<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public int numChildren(Node<E> p) throws IllegalArgumentException
    {
        return 0;
    }

    @Override
    public boolean isInternal(Node<E> p) throws IllegalArgumentException
    {
        return false;
    }

    @Override
    public boolean isExternal(Node<E> p) throws IllegalArgumentException
    {
        return false;
    }

    @Override
    public boolean isRoot(Node<E> p) throws IllegalArgumentException
    {
        return false;
    }

    @Override
    public Node<E> insert(E item, Node<E> p)
    {
        return null;
    }

    @Override
    public boolean remove(E item, Node<E> p) throws IllegalArgumentException
    {
        return false;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public E set(Node<E> node, E element) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public Node<E> validate(Node<E> p) throws IllegalArgumentException
    {
        return null;
    }

    @Override
    public int depth(Node<E> node) throws IllegalArgumentException
    {
        return 0;
    }

    @Override
    public int subTreeSize(Node<E> node) throws IllegalArgumentException
    {
        return 0;
    }

    @Override
    public boolean isLastChild(Node<E> node) throws IllegalArgumentException
    {
        return false;
    }
}
