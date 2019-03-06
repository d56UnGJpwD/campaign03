package edu.isu.cs.cs3308.traversals;

import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.Tree;
import edu.isu.cs.cs3308.structures.impl.AbstractBinaryTree;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;

import java.util.List;

public class PostOrderTraversal<E> extends DepthFirstTraversal<E>
{
    public PostOrderTraversal(Tree<E> tree)
    {
        super(tree);
    }

    public Iterable<Node<E>> subtree(Node<E> node, List<Node<E>> nodes) throws IllegalArgumentException
    {
        if(node == null || nodes == null)
        {
            throw new IllegalArgumentException();
        }

        AbstractBinaryTree.BinaryTreeNode<E> BTNode = (AbstractBinaryTree.BinaryTreeNode<E>) node;

        if(BTNode.getLeft() != null)
        {
            nodes = (List<Node<E>>)subtree(BTNode.getLeft(), nodes);
        }

        if(BTNode.getRight() != null)
        {
            nodes = (List<Node<E>>)subtree(BTNode.getRight(), nodes);
        }

        nodes.add(node);

        if(cmd != null)
        {
            cmd.execute(tree, node);
        }

        return nodes;
    }
}
