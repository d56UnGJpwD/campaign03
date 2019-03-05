package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.impl.LinkedQueue;

import java.util.List;
import java.util.ArrayList;

public class BreadthFirstTraversal<E> extends AbstractTraversal<E>
{

    public BreadthFirstTraversal(Tree<E> tree)
    {
        //if null is handled in the super
        super(tree);
    }

    @Override
    public Iterable<Node<E>> traverse()
    {
        if(tree == null || tree.isEmpty())
        {
            return new ArrayList<>();
        }
        return traverseFrom(tree.root());
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node<E> node) throws IllegalArgumentException
    {
        if(node == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            ArrayList<Node<E>> arrList = new ArrayList<>();
            LinkedQueue<Node<E>> linkedQueue = new LinkedQueue<>();
        }
        Node<E> from = (Node<E>)node;
        //LinkedQueue<Node<E>> queue = new LinkedQueue<>();
        return null;
    }
}
