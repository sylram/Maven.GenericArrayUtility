package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {


    E[] input;
    int inputSize;

    public ArrayUtility(E[] input) {
        inputSize = input.length;
        this.input = input;

    }

    public E[] mergeArrays(E[] arrayToMerge) {
        int size = arrayToMerge.length + inputSize;
        E[] mergeArrays = Arrays.copyOf(input, size);
        for (int i = 0; i < arrayToMerge.length; i++) {
            mergeArrays[input.length + i] = arrayToMerge[i];
        }
        return mergeArrays;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        return numberOfOcurrencies(mergeArrays(arrayToMerge), valueToEvaluate);
    }

    public Integer numberOfOcurrencies(E[] array, E element) {
        Integer counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                counter += 1;
            }
        }
        return counter;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        E[] mergeArrays = mergeArrays(arrayToMerge);
        E mostCommon = mergeArrays[0];
        Integer counter = 0;
        for (int i = 0; i < mergeArrays.length; i++) {

            Integer current = numberOfOcurrencies(mergeArrays, mergeArrays[i]);
            if (current > counter) {
                counter = current;
                mostCommon = mergeArrays[i];
            }
        }
        return mostCommon;

    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
      return numberOfOcurrencies(input,valueToEvaluate);
    }

    public E[] removeValue(E valueToRemove) {
       Integer numberOfOccurrences =  numberOfOcurrencies(input,valueToRemove);
       E[] newArray = Arrays.copyOf(input,input.length-numberOfOccurrences);
       int index = 0;
        for (int i = 0; i < input.length ; i++) {
            if(!input[i].equals(valueToRemove)){
                newArray[index]=input[i];
                index++; }

        }return newArray;
    }
}
//        for (int i = 0; i < ; i++) {
//
//        }
//        countDuplicatesInMerge(arrayToMerge,)
//
//        E mostCommon;
//
//        for(E e : mergeArrays){
//            if(e.equals(toCompare)){
//                mostCommon = e;
//            }

