package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

import java.util.LinkedList;
import java.util.List;

public abstract class DepthFirstTraversal<E> extends AbstractTraversal<E>
{
    public DepthFirstTraversal(Tree<E> tree)
    {
        super(tree);
    }

    public Iterable<Node<E>> subtree(Node<E> root, List<Node<E>> list)
    {
        return null;
    }

    @Override
    public Iterable<Node<E>> traverse()
    {
        return subTreeTraverse(tree.root());
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node<E> node)
    {
        return subTreeTraverse(node);
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
