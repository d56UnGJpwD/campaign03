package edu.isu.cs.cs3308;

import com.sun.jmx.snmp.Enumerated;
import com.sun.org.apache.xpath.internal.operations.Bool;
import edu.isu.cs.cs3308.structures.BinaryTree;
import edu.isu.cs.cs3308.structures.Node;
import edu.isu.cs.cs3308.structures.impl.AbstractBinaryTree;
import edu.isu.cs.cs3308.structures.impl.AbstractBinaryTree.BinaryTreeNode;
import edu.isu.cs.cs3308.structures.impl.BinarySearchTree;
import edu.isu.cs.cs3308.structures.impl.LinkedBinaryTree;
import edu.isu.cs.cs3308.traversals.BreadthFirstTraversal;
import edu.isu.cs.cs3308.traversals.InOrderTraversal;
import edu.isu.cs.cs3308.traversals.PreOrderTraversal;
import edu.isu.cs.cs3308.traversals.TreeTraversal;
import edu.isu.cs.cs3308.traversals.commands.EnumeratedSaveCommand;
import edu.isu.cs.cs3308.traversals.commands.EnumerationCommand;
import edu.isu.cs.cs3308.traversals.commands.TraversalCommand;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * A very simple classification tree example using a BinaryTree and console
 * input.
 *
 * @author Isaac Griffith
 */
public class ClassificationTree {

    private LinkedBinaryTree<Datum> tree;

    /**
     * Constructs a new Animal tree class which manages an underlying animal
     * tree
     */
    public ClassificationTree() {
        tree = new LinkedBinaryTree<>();
        load();
    }

    /**
     * Main method which controls the identification and tree management loop.
     */
    public void identify()
    {
        BinaryTreeNode<Datum> current = (BinaryTreeNode<Datum>) tree.root();

        LinkedList<String> descriptors = new LinkedList<>();
        String reply;

        if(current.getElement().getPrompt().equals("EMPTY"))
        {
            identifyFirst();
            return;
        }

        while(true)
        {

            System.out.println("Is the animal, " + current.getElement().getPrompt() + "? (Y/N) > ");
            Scanner scanner = new Scanner(System.in);
            reply = scanner.next().toUpperCase();

            if(!reply.equals("Y")|| !reply.equals("N"))
            {
                System.out.println("Sorry, I do not understand");
            }

            if(reply.equals("Y"))
            {
                if(current.getLeft() != null)
                {
                    descriptors.add(current.getElement().getPrompt());
                    current = current.getLeft();
                }
                else
                {
                    break;
                }
            }

            if(reply.equals("N"))
            {
                if(current.getRight() != null)
                {
                    descriptors.add("not " + current.getElement().getPrompt());
                    current = current.getRight();
                }
                else
                {
                    break;
                }
            }

        }
        if(reply.equals("Y"))
        {
            System.out.println("Im the best!");
        }
        else if(reply.equals("N"))
        {
            addAnimal(current, descriptors);
        }
        else
        {
            System.out.println("Try again");
        }
    }

    private void identifyFirst()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add the first animal. > ");
        String newAnimal = scanner.next().toUpperCase();

        System.out.println("Use a single word to describe it. > ");
        String newDescriptor = scanner.next().toUpperCase();

        tree.root().setElement(new Datum(newDescriptor));
        tree.addLeft(tree.root(), new Datum("A " + newAnimal));
    }

    private void addAnimal(BinaryTreeNode<Datum> node, LinkedList<String> descriptors)
    {
        Scanner scanner = new Scanner(System.in);
        Datum nodeD = node.getElement();
        String nodeAnimal = nodeD.getPrompt();

        System.out.println("I dont know any animals that are not ");
        for(String desc: descriptors)
        {
            System.out.println(desc + " ");
        }


        System.out.println("What is the name of the new animal? > ");
        String newAnimal = scanner.next().toUpperCase();

        System.out.println("Use a single word to describe it. > ");
        String newDescriptor = scanner.next().toUpperCase();

        if(node.getLeft() == null)
        {
            tree.set(node, new Datum(newDescriptor));
            tree.addLeft(node, new Datum(newAnimal));
            tree.addRight(node, nodeD);
        }
        else
        {
            tree.addRight(node, new Datum(newDescriptor));
            tree.addLeft(node.getRight(), new Datum(newAnimal));
        }
    }
    /**
     * Saves a tree to a file.
     */
    public void save()
    {
        BreadthFirstTraversal<Datum> traversal = new BreadthFirstTraversal<>(tree);
        traversal.setCommand(new EnumerationCommand());
        traversal.traverse();

        File in;
        PrintWriter writer;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a file to save to: > ");
        String file = input.next();

        try
        {
            in = new File(file);
            writer = new PrintWriter(in);
            traversal.setCommand(new EnumeratedSaveCommand(writer));
            traversal.traverse();
            writer.close();
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Save Failed");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }

    /**
     * Loads a tree from the given file, if an exception occurs during file
     * operations, a hardcoded basic tree will be loaded instead.
     */
    public void load()
    {
        tree.setRoot(new Datum("EMPTY"));
        /*
        BufferedReader br;
        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("Choose a file to load: >");
        String file = scanner.next();

        try
        {
            br = new BufferedReader(new FileReader(file));
            line = br.readLine();
            LinkedList<String> nodes = new LinkedList<>();

            while(line != null)
            {
                nodes.add(line);
                line = br.readLine();
            }

            LinkedBinaryTree<Datum> tree = new LinkedBinaryTree<>();
            BreadthFirstTraversal<Datum> traversal = new BreadthFirstTraversal<>(tree);
            EnumeratedLoadCommand
        }
        */
    }

}
