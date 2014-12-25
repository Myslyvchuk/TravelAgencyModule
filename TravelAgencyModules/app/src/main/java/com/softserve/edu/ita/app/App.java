package com.softserve.edu.ita.app;

import com.softserve.edu.ita.dao.EntityManagerUtil;

public class App {

	public static void main(String[] args) {

		GenerateData obj = new GenerateData();
		obj.GenerateDataForDB();

		EntityManagerUtil.closeConnection();
		EntityManagerUtil.closeFactory();

	}

}
