package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree.BinaryTreeNode;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

public class BreadthFirstTraversal<E> extends AbstractTraversal<E>
{
    protected Tree<E> tree;
    protected TraversalCommand traversalCommand = null;

    public BreadthFirstTraversal(Tree<E> tree)
    {
        //if null
        this.tree = tree;
    }

    @Override
    public Iterable<Node<E>> traverse()
    {
        return traverseFrom(tree.root());
    }

    @Override
    public Iterable<Node<E>> traverseFrom(Node<E> node)
    {
        //if null
        BinaryTreeNode<E> from = (BinaryTreeNode<E>)node;
        //LinkedQueue<Node<E>> queue = new LinkedQueue<>();
        return null;
    }
}
