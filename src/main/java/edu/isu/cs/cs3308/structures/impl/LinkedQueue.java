package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.Queue;
import edu.isu.cs.cs3308.structures.Stack;
public class LinkedQueue<E> implements Queue<E>
{


    //Here is the node class from all of my other assignments

    public class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next){
            this.value = value;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

        public Node<E> getNext(){
            return next;
        }

        public E getValue(){
            return value;
        }
    }

    //My queue has a size, and a first and last node that I use for tracking and adding/removing
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public LinkedQueue()
    {
        first = null;
        last = null;
    }
    //returns the size of the queue
    public int size()
    {
        return size;
    }
    //checks if the queue is empty
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //adds a node to the back of the queue
    public void offer(E element)
    {
        if(element != null)
        {
            Node<E> old = last;
            last = new Node(element, null);

            if (isEmpty())
            {
                first = last;
            } else
            {
                old.next = last;
            }
            size++;
        }
    }
    //looks at the node first in the queue and returns its value
    public E peek()
    {
        if(isEmpty())
        {
            return null;
        }
        else
        {
            return first.getValue();
        }
    }
    //similar to peek, but deletes the node as well
    public E poll()
    {
        if(isEmpty())
        {
            return null;
        }
        E removed = first.getValue();
        first = first.next;
        size--;
        if(isEmpty())
        {
            last = null;
        }
        return removed;
    }
    //prints the contents of the queue
    public void printQueue()
    {
        Node<E> current = first;
        for(int i = 0; i < size; i++)
        {
            System.out.println(current.getValue());
            current = current.next;
        }
    }
    //transfers the contents from the current queue to the provided one
    //and deletes the current queue
    public void transfer(Queue<E> into)
    {
        if(into != null)
        {
            reverse();
            while(!this.isEmpty())
            {
                into.offer(this.poll());
            }
        }

    }

    //uses a stack to reverse the queue
    public void reverse()
    {
        LinkedStack<E> stack = new LinkedStack<>();
        while(!this.isEmpty())
        {
            stack.push(this.poll());
        }
        while(!stack.isEmpty())
        {
            offer(stack.pop());
        }

    }

    //similar to transfer, but keeps the source queue intact
    public void merge(Queue<E> from)
    {
        if(from == null)
        {
        }
        else
        {
            LinkedQueue<E> temp = new LinkedQueue<>();
            while(!from.isEmpty())
            {
                E val = from.poll();
                offer(val);
                temp.offer(val);

            }
            while(!temp.isEmpty())
            {
                E val = temp.poll();
                from.offer(val);
            }

        }
    }

}
