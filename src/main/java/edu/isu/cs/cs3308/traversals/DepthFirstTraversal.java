package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

import java.util.LinkedList;
import java.util.List;

public abstract class DepthFirstTraversal<E> implements TreeTraversal<E>
{

    protected Tree<E> tree;
    protected TraversalCommand<E> traversalCommand = null;

    public abstract void subtree(Node<E> root, List<Node<E>> list);

    @Override
    public Iterable<Node<E>> traverse()
    {
        return traverseFrom(tree.root());
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node<E> node)
    {
        return subTreeTraverse(node);
    }

    @Override
    public void setCommand(TraversalCommand cmd)
    {
        traversalCommand = cmd;
    }

    public Iterable<Node<E>> subTreeTraverse(Node<E> node)
    {
        LinkedList<Node<E>> nodes = new LinkedList<>();
        if(tree.isEmpty() == false)
        {
            subtree(node, nodes);
        }
        return nodes;
    }
}
