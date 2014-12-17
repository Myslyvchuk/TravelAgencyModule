package com.softserve.edu.ita.app;

import com.softserve.edu.ita.dao.HibernateUtil;

public class App {

	public static void main(String[] args) {

		GenerateData obj = new GenerateData();
		for (int i = 0; i < 50; i++) {
			
			obj.GenerateDataForDB();
		}
		HibernateUtil.closeFactory();

	}

}
