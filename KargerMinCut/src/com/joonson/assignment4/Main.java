package com.joonson.assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		/*
		 * Input data
		 * 		200 nodes
		 *  	2517 edges
		 * */
		KargerMinCut kmc = new KargerMinCut(new GraphGenerator());
		System.out.println(kmc.getMinCut());
	}

}

