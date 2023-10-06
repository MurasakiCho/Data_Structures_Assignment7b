/*
Name: Briana O'Neal
Class: CS 3305/W01
Term: Fall 2022
Instructor: Sharon Perry
Assignment: 7-Part-2-Heaps
*/
import java.util.ArrayList;
import java.util.Scanner;

class Heap{
    ArrayList<Integer> list = new ArrayList<>();
    //add elements to heap from an array
    public Heap(int[] list){
        for (int j : list) {
            add(j);
        }
    }
    //add method that
    public void add(int n){
        list.add(n);
        //index of last node
        int current = list.size() - 1;
        //if current index is less than parent, current becomes parent
        while (current > 0){
            int parent = (current - 1)/2;
            if(list.get(current) < list.get(parent)){
                int temp = list.get(current);
                list.set(current, list.get(parent));
                list.set(parent, temp);
            }
            else{
                break;
            }
            //iterates list
            current = parent;
        }
    }
    //removes and prints root of heap
    public void remove(){
        //catches empty heap
        if(list.size() == 0){
            System.out.println("Heap is empty");
        }
        else{
            //head node of heap (lowest number)
            int removeInt = list.get(0);
            //sets the last node as the head node and removes last node
            list.set(0, list.get(list.size()-1));
            list.remove(list.size()-1);

            int current = 0;
            while(current < list.size()){
                int leftChild = 2 * current + 1;
                int rightChild = 2 * current + 2;
                if(leftChild >= list.size()){
                    break;
                }
                int min = leftChild;
                if(rightChild < list.size()){
                    if(list.get(min) > list.get(rightChild)){
                        min = rightChild;
                    }
                }
                if(list.get(current) > list.get(min)){
                    int temp = list.get(min);
                    list.set(min, list.get(current));
                    list.set(current, temp);
                    current = min;
                }
                else{
                    break;
                }
            }
            System.out.print(removeInt + " ");
        }
    }
}
public class Assignment7B {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("Enter 5 integers: ");
        for(int i = 0; i < 5; i ++){
            n = scan.nextInt();
            arr[i]= n;
        }
        Heap heap = new Heap(arr);
        for(int i = 0; i < 5; i++){
            heap.remove();
        }
    }
}
